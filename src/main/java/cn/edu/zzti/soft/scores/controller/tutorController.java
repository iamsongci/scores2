package cn.edu.zzti.soft.scores.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.zzti.soft.scores.entity.Notify;
import cn.edu.zzti.soft.scores.entity.Project;
import cn.edu.zzti.soft.scores.entity.StudentTutorProject;
import cn.edu.zzti.soft.scores.entity.Tutor;
import cn.edu.zzti.soft.scores.entity.tools.StudentInfo;
import cn.edu.zzti.soft.scores.entity.tools.StudentInfoWithScores;
import cn.edu.zzti.soft.scores.entity.tools.StudentWithClass;
import cn.edu.zzti.soft.scores.supervisor.ConfigDo;
import cn.edu.zzti.soft.scores.supervisor.DaoFit;
import cn.edu.zzti.soft.scores.supervisor.ResultDo;
import cn.edu.zzti.soft.scores.supervisor.ServiceFit;
import cn.edu.zzti.soft.scores.util.ExcelUtil;
import cn.edu.zzti.soft.scores.util.MyString;

@Controller
@RequestMapping("/tutor/")
public class tutorController implements ConfigDo {
	@Resource
	private ServiceFit serviceFit;

	@RequestMapping("home")
	public String homePage(Model model, HttpSession session) {
		model.addAttribute("menuSelected1", ConfigDo.INDEX);
		return "./tutor/home";
	}

	// 功能未做实现-----空页面
	@RequestMapping("empty")
	public String empty(Model model) {
		model.addAttribute("menuSelected1", ConfigDo.EMPTY);
		return "./tutor/empty";
	}
	
	
	@RequestMapping("assignStudent")
	public String assignStudent(Model model, HttpSession session, @RequestParam("studentID") String studentID, @RequestParam("tutorID") String tutorID, @RequestParam("proID") String proID, @RequestParam("tutorName") String tutorName) {
		try {
			tutorName = URLDecoder.decode(tutorName, "utf8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		List<StudentTutorProject> stuList = new ArrayList<StudentTutorProject>();
		stuList.add(new StudentTutorProject(studentID, tutorID, proID, null, null, null, null));
		ResultDo resultDo = serviceFit.getTutorService().insertStuTutorPro(stuList);
		if (resultDo.isSuccess()) {
			model.addAttribute("tutorID", tutorID);
			model.addAttribute("proID", proID);
			model.addAttribute("tutorName", tutorName);
		} else {
			model.addAttribute("message", "0");// 未在前台添加事件
		}
		return "redirect:./assign.do";
	}
	
	
	@RequestMapping("assign")
	public String assign(Model model, HttpSession session, @RequestParam("proID") String proID, @RequestParam("tutorID") String tutorID, @RequestParam("tutorName") String tutorName) {
		try {
			tutorName = URLDecoder.decode(tutorName, "utf8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		ResultDo resultDo = serviceFit.getTutorService().selectStuNotHasThisPro(proID);
		List<StudentWithClass> stuList = (List<StudentWithClass>)resultDo.getResult();
		if (resultDo.isSuccess()) {
			model.addAttribute("stuList", stuList);
			model.addAttribute("tutorID", tutorID);
			model.addAttribute("proID", proID);
			model.addAttribute("tutorName", tutorName);
		} else {
			model.addAttribute("message", "0");// 未在前台添加事件
		}
		return "./tutor/assign";
	}
	
	//删除学生
	@RequestMapping("deleteStu")
	public String deleteStu(Model model, HttpSession session, @RequestParam("index") String index) {
		ResultDo result = new ResultDo();
		result = serviceFit.getTutorService().deleteByIndex(index);

		if (result.isSuccess()) {
			model.addAttribute("message", "1");
		} else {
			model.addAttribute("message", "0");// 未在前台添加事件
		}
		return "./tutor/tutorStu";
	}
	
	
	//查看学生
	@RequestMapping("tutorStu")
	public String tutorStu(Model model, HttpSession session, @RequestParam("tutorID") String tutorID, @RequestParam("tutorName") String tutorName, @RequestParam("proName") String proName) {
		try {
			proName = URLDecoder.decode(proName, "utf8");
			tutorName = URLDecoder.decode(tutorName, "utf8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		MyString pro = new MyString(proName); 
		MyString tutor = new MyString(tutorName); 
		
		ResultDo result = new ResultDo();
		result = serviceFit.getTutorService().selectStudentInfoWithScores(tutorID);
		List<StudentInfoWithScores> stuList = (List<StudentInfoWithScores>) result.getResult(); //获取成功
		if (result.isSuccess()) {
			model.addAttribute("stuList", stuList);
			model.addAttribute("tutorID", tutorID);
			model.addAttribute("tutorName", tutor);
			model.addAttribute("proName", pro);
		} else {
			model.addAttribute("message", "0");// 未在前台添加事件
		}
		return "./tutor/tutorStu";
	}
	
	//进入导师列表
	@RequestMapping("tutorList")
	public String tutorList(Model model, HttpSession session, @RequestParam("proID") String proID, @RequestParam("proName") String proName) {
		try {
			proName = URLDecoder.decode(proName, "utf8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultDo result =new ResultDo();
		result=serviceFit.getSuperAdminService().selectTutorInfo();
		if(result.isSuccess()){
			model.addAttribute("tutorList", (List)result.getResult());
			model.addAttribute("proID", proID);
			model.addAttribute("proName", proName);
			
		} else {
			model.addAttribute("message", "0");
		}
		return "./tutor/tutorList";
	}
	
	//导师分配学生
	@RequestMapping("tutorAssign")
	public String tutorAssign(Model model, HttpSession session) {
		Tutor tutor = (Tutor) session.getAttribute("user");
		tutor = (Tutor) serviceFit.getTutorService().TutLogin(tutor.getTutorID()).getResult();
		List<String> scoresNum = Arrays.asList(tutor.getTutorPower1().split(","));
		List<Project> proList = new ArrayList<Project>();
		Project pro = null;
		for (String str : scoresNum) {
			pro = (Project)serviceFit.getTutorService().selectProject(str).getResult();
			proList.add(pro);
		}
		model.addAttribute("proList", (List<Project>) proList);
		return "./tutor/tutorAssign";
	}
	// 导出我的学生信息
	@RequestMapping("downloadByPro")
	public String downloadByPro(Model model, HttpSession session, HttpServletResponse response, @RequestParam("proID") String proID) throws IOException {
		List<StudentInfoWithScores> projects = (List<StudentInfoWithScores>) (serviceFit.getTutorService()
				.selectStudentByProjectID(proID).getResult());
		
		List<Map<String, Object>> list = createExcelRecord(projects);
		String columnNames[] = { "index", "学号", "姓名", "课题类型", "分数" };// 列名
		String keys[] = { "index", "ID", "name", "project", "score" };// map中的key
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ExcelUtil.createWorkBook(list, keys, columnNames).write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] content = os.toByteArray();
		InputStream is = new ByteArrayInputStream(content);
		// 设置response参数，可以打开下载页面
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(("我的学生信息.xls").getBytes(), "utf-8"));
		ServletOutputStream out = response.getOutputStream();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[2048];
			int bytesRead;
			// Simple read/write loop.
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (final IOException e) {
			throw e;
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
		return null;
	}
	
	//查看
	@RequestMapping("lookProject")
	public String lookProject(Model model, HttpSession session, @RequestParam("proID") String proID) {
		ResultDo resultDo = new ResultDo();
		resultDo = serviceFit.getTutorService().selectStudentByProjectID(proID);
		if (resultDo.isSuccess()) {
			model.addAttribute("stus", (List)resultDo.getResult());
			model.addAttribute("proID", proID);
		} else {
			model.addAttribute("message", "0");
		}
		return "./tutor/lookProject";
	}
	
	//汇总成绩
	@RequestMapping("collectScores")
	public String collectScores(Model model, HttpSession session) {
		Tutor tutor = (Tutor) session.getAttribute("user");
		tutor = (Tutor) serviceFit.getTutorService().TutLogin(tutor.getTutorID()).getResult();
		List<String> scoresNum = Arrays.asList(tutor.getTutorPower2().split(","));
		List<Project> proList = new ArrayList<Project>();
		Project pro = null;
		for (String str : scoresNum) {
			pro = (Project)serviceFit.getTutorService().selectProject(str).getResult();
			proList.add(pro);
		}
		model.addAttribute("proList", (List<Project>) proList);
		return "./tutor/collectScores";
	}

	// 更新学生分数
	@RequestMapping("updateStudentScore")
	public String updateStudentScore(Model model, HttpSession session, @RequestParam("score") String score,
			@RequestParam("curindex") String curindex) {
		StudentTutorProject stu = new StudentTutorProject();
		stu.setIndex(curindex);
		stu.setStudentTotalScore(Integer.parseInt(score));
		List<StudentTutorProject> scoreList = new ArrayList<StudentTutorProject>();
		scoreList.add(stu);
		ResultDo resultDo = serviceFit.getTutorService().updateStuProScore(scoreList);
		if (resultDo.isSuccess()) {
			model.addAttribute("message", "1");
		} else {
			model.addAttribute("message", "0");
		}
		return "redirect:./myStuInfoWithScores.do";
	}

	
	@RequestMapping("upLoad")
	public String upLoad(Model model, HttpSession session, HttpServletResponse response,
			@RequestParam("file") MultipartFile excelFile) throws Exception {
		StudentTutorProject stu = null;
		List<StudentTutorProject> scoreList = new ArrayList<StudentTutorProject>();
		POIFSFileSystem fs = new POIFSFileSystem(excelFile.getInputStream());
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet hssfSheet = wb.getSheetAt(0);
		HSSFRow hssfRow = null;
		if (hssfSheet != null) {
			for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				hssfRow = hssfSheet.getRow(rowNum);
				if(hssfRow == null) {
					continue;
				}
				String index = getStringCellValue(hssfRow.getCell(0));
				String scoreStr = getStringCellValue(hssfRow.getCell(4));
				Double score = null;
				if(!"".equals(scoreStr.trim()) && scoreStr != null)
					score = Double.parseDouble(scoreStr);
				
				stu = new StudentTutorProject();
				stu.setIndex(index);
				if(score == null)
					stu.setStudentTotalScore(0);
				else
					stu.setStudentTotalScore(score.intValue());
				scoreList.add(stu);
			}
		}
		serviceFit.getTutorService().updateStuProScore(scoreList);
			
		
		
		return null;
	}
	
	

	// 导出我的学生信息
	@RequestMapping("download")
	public String download(Model model, HttpSession session, HttpServletResponse response) throws IOException {
		Tutor tutor = (Tutor) session.getAttribute("user");
		List<StudentInfoWithScores> projects = (List<StudentInfoWithScores>) (serviceFit.getTutorService()
				.selectStudentInfoWithScores(tutor.getTutorID()).getResult());

		List<Map<String, Object>> list = createExcelRecord(projects);
		String columnNames[] = { "index", "学号", "姓名", "课题类型", "分数" };// 列名
		String keys[] = { "index", "ID", "name", "project", "score" };// map中的key
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ExcelUtil.createWorkBook(list, keys, columnNames).write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] content = os.toByteArray();
		InputStream is = new ByteArrayInputStream(content);
		// 设置response参数，可以打开下载页面
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(("我的学生信息.xls").getBytes(), "utf-8"));
		ServletOutputStream out = response.getOutputStream();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[2048];
			int bytesRead;
			// Simple read/write loop.
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (final IOException e) {
			throw e;
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
		
		
		return null;
	}

	// 我的学生成绩信息
	@RequestMapping("myStuInfoWithScores")
	public String myStuInfoWithScores(Model model, HttpSession session) {
		Tutor tutor = (Tutor) session.getAttribute("user");
		String tutorID = tutor.getTutorID();
		ResultDo result = new ResultDo();
		result = serviceFit.getTutorService().selectStudentInfoWithScores(tutorID);
		if (result.isSuccess()) {
			model.addAttribute("info", (List<StudentInfoWithScores>) result.getResult());
		} else {
			model.addAttribute("message", "0");
		}
		return "./tutor/myStuInfoWithScores";
	}

	// 我的学生信息
	@RequestMapping("myStuInfo")
	public String myStuInfo(Model model, HttpSession session) {
		Tutor tutor = (Tutor) session.getAttribute("user");
		ResultDo result = new ResultDo();
		String tutorID = tutor.getTutorID();
		result = serviceFit.getTutorService().findAllStu(tutorID);
		if (result.isSuccess()) {
			model.addAttribute("info", (List<StudentInfo>) result.getResult());
		} else {
			model.addAttribute("message", "0");// 未在前台添加事件
		}
		return "./tutor/myStuInfo";
	}

	// 我的机房信息
	@RequestMapping("myMrInfo")
	public String myMrInfo(Model model, HttpSession session) {
		Tutor tutor = (Tutor) session.getAttribute("user");
		ResultDo result = new ResultDo();
		String tutorID = tutor.getTutorID();
		result = serviceFit.getTutorService().selectMachRoomInfo(tutorID);
		if (result.isSuccess()) {
			model.addAttribute("info", result.getResult());
		} else {
			model.addAttribute("message", "0");// 未在前台添加事件
		}

		return "./tutor/myMrInfo";
	}

	// 删除通知
	@RequestMapping("deleteNotify")
	public String deleteNotify(Model model, HttpSession session, @RequestParam("notifyID") String notifyID) {
		serviceFit.getNotifyService().deleteNotify(notifyID);
		return "redirect:./notify.do";
	}

	// 新建通知
	@RequestMapping("createNotify")
	public String createNotify(Model model, HttpSession session, @RequestParam("title") String title,
			@RequestParam("content") String content, @RequestParam("toStudent") Boolean toStudent) {
		Tutor tutor = (Tutor) session.getAttribute("user");

		serviceFit.getNotifyService().insertNotify(new Notify(null, title, content, tutor.getTutorName(),
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), toStudent));
		return "./tutor/notify";
	}

	// 通知
	@RequestMapping("notify")
	public String notify(Model model, HttpSession session) {
		Tutor tutor = (Tutor) session.getAttribute("user");
		ResultDo result = new ResultDo();
		result = serviceFit.getNotifyService().selectAllNotify();
		if (result.isSuccess()) {
			model.addAttribute("notifyList", (List<Notify>) result.getResult());
			model.addAttribute("user", tutor);
		} else {
			model.addAttribute("message", "0");// 未在前台添加事件
		}
		return "./tutor/notify";
	}

	// 查看个人信息
	@RequestMapping("teaInfo")
	public String tutorInfo(Model model, HttpSession session) {
		Tutor tutor = (Tutor) session.getAttribute("user");
		ResultDo resultDo = serviceFit.getTutorService().TutLogin(tutor.getTutorID());
		if (resultDo.isSuccess()) {
			model.addAttribute("teaInfo", resultDo.getResult());
		} else {
			model.addAttribute("message", "0");// 未在前台添加事件
		}
		model.addAttribute("menuSelected1", ConfigDo.TEAINFO);
		return "./tutor/teaInfo";
	}

	// 更新老师信息
	@RequestMapping("updateTutorInfo")
	public String updateTutorInfo(Model model, HttpSession session, @RequestParam("tutorPhone") String tutorPhone,
			@RequestParam("tutorEmail") String tutorEmail) {
		Tutor tutor = (Tutor) session.getAttribute("user");
		ResultDo resultDo = serviceFit.getTutorService().updateTutorPhoAndEma(tutor.getTutorID(), tutorPhone,
				tutorEmail);
		ResultDo resultDo1 = serviceFit.getTutorService().TutLogin(tutor.getTutorID());
		if (resultDo.isSuccess()) {
			model.addAttribute("teaInfo", resultDo1.getResult());
			model.addAttribute("message", "1");
		} else {
			model.addAttribute("message", "0");
		}
		return "./tutor/teaInfo";
	}

	// 修改个人信息--密码
	@RequestMapping("updateTutorPsd")
	public String updateTutorPsd(Model model, HttpSession session, @RequestParam("pwd") String pwd) {
		Tutor tutor = (Tutor) session.getAttribute("user");
		ResultDo resultDo = serviceFit.getTutorService().updateTutorPsd(tutor.getTutorID(), pwd);
		model.addAttribute("message", "1");
		return "redirect:./teaInfo.do";
	}

	private List<Map<String, Object>> createExcelRecord(List<StudentInfoWithScores> projects) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		StudentInfoWithScores studentInfoWithScores = null;
		for (int j = 0; j < projects.size(); j++) {
			studentInfoWithScores = projects.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
			mapValue.put("index", studentInfoWithScores.getIndex());
			mapValue.put("ID", studentInfoWithScores.getStudentID());
			mapValue.put("name", studentInfoWithScores.getStudentName());
			mapValue.put("project", studentInfoWithScores.getProjectName());
			mapValue.put("score", studentInfoWithScores.getTotalScore());
			listmap.add(mapValue);
		}
		return listmap;
	}
	
	/**
     * 获取单元格数据内容为字符串类型的数据
     * 
     * @param cell Excel单元格
     * @return String 单元格数据内容
     */
	private String getStringCellValue(HSSFCell cell) {
		String strCell = "";
		if(cell == null)
			return "";
		switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_STRING:
				strCell = cell.getStringCellValue();
				break;
			case HSSFCell.CELL_TYPE_NUMERIC:
				strCell = String.valueOf(cell.getNumericCellValue());
				break;
			case HSSFCell.CELL_TYPE_BOOLEAN:
				strCell = String.valueOf(cell.getBooleanCellValue());
				break;
			case HSSFCell.CELL_TYPE_BLANK:
				strCell = "";
				break;
			default:
				strCell = "";
				break;
		}
		if (strCell.equals("") || strCell == null) {
			return "";
		}
		if (cell == null) {
			return "";
		}
		return strCell;
	}

}
