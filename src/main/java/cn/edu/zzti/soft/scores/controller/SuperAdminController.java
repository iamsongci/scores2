package cn.edu.zzti.soft.scores.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.zzti.soft.scores.entity.Notify;
import cn.edu.zzti.soft.scores.entity.Project;
import cn.edu.zzti.soft.scores.entity.Student;
import cn.edu.zzti.soft.scores.entity.StudentTutorProject;
import cn.edu.zzti.soft.scores.entity.Tutor;
import cn.edu.zzti.soft.scores.entity.tools.StudentInfoWithScores;
import cn.edu.zzti.soft.scores.entity.tools.TutorIDWithPower;
import cn.edu.zzti.soft.scores.entity.tools.TutorInfo;
import cn.edu.zzti.soft.scores.supervisor.ConfigDo;
import cn.edu.zzti.soft.scores.supervisor.ResultDo;
import cn.edu.zzti.soft.scores.supervisor.ServiceFit;
import cn.edu.zzti.soft.scores.util.ExcelUtil;
import cn.edu.zzti.soft.scores.util.MyString;
import cn.edu.zzti.soft.scores.util.StringUtil;

@Controller
@RequestMapping("/superAdmin/")
public class SuperAdminController implements ConfigDo {
	@Resource
	private ServiceFit serviceFit;

	@RequestMapping("home")
	public String homePage(Model model, HttpSession session) {
		model.addAttribute("menuSelected1", ConfigDo.INDEX);
		return "./superAdmin/home";
	}

	// 功能未做实现-----空页面
	@RequestMapping("empty")
	public String empty(Model model) {
		model.addAttribute("menuSelected1", ConfigDo.EMPTY);
		return "./superAdmin/empty";
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
		serviceFit.getNotifyService().insertNotify(new Notify(null, title, content, "zzti",
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), toStudent));
		return "./superAdmin/notify";
	}

	@RequestMapping("powerAssign")
	public String powerAssign(Model model, HttpSession session) {
		ResultDo resultDo = null;
		resultDo = serviceFit.getSuperAdminService().selectAllProject();
		// List<Project> proList = (List<Project>)resultDo.getResult();
		if (resultDo.isSuccess()) {
			model.addAttribute("proList", (List) resultDo.getResult());
		} else {
			model.addAttribute("message", "0");
		}
		model.addAttribute("menuSelected1", ConfigDo.SUPTUTOR);
		model.addAttribute("menuSelected2", ConfigDo.SUPTUTORPOWER);

		return "./superAdmin/powerAssign";
	}

	// 通知
	@RequestMapping("notify")
	public String notify(Model model, HttpSession session) {
		ResultDo result = new ResultDo();
		result = serviceFit.getNotifyService().selectAllNotify();
		if (result.isSuccess()) {
			model.addAttribute("notifyList", (List<Notify>) result.getResult());
		} else {
			model.addAttribute("message", "0");// 未在前台添加事件
		}
		model.addAttribute("menuSelected1", ConfigDo.SUPNOTIFY);
		return "./superAdmin/notify";
	}

	// 导师信息查看
	@RequestMapping("selectTutorInfo")
	public String selectTutorInfo(Model model, HttpSession session) {
		ResultDo result = new ResultDo();
		result = serviceFit.getSuperAdminService().selectTutorInfo();
		if (result.isSuccess()) {
			model.addAttribute("tutorList", (List) result.getResult());
			model.addAttribute("menuSelected1", ConfigDo.SUPTUTOR);
			model.addAttribute("menuSelected2", ConfigDo.SUPTUTORINFO);
			return "./superAdmin/supTutorInfo";
		} else {
			return "./superAdmin/empty";
		}
	}

	// 导师重置密码
	@RequestMapping("resetPassword")
	public @ResponseBody Map<String, Object> resetPassword(HttpSession session,
			@RequestParam("TutorId") String TutorId) {
		ResultDo result = new ResultDo();
		Map<String, Object> map = new HashMap<String, Object>();
		String mag = "";
		boolean flag = false;
		result = serviceFit.getSuperAdminService().updateTutorPwd(TutorId);
		if (result.isSuccess()) {
			flag = true;
			mag = "重置密码成功.";
		} else {
			mag = "密码重置失败";
		}
		map.put("status", flag);
		map.put("mag", mag);
		return map;
	}

	// 导师基本信息修改
	@RequestMapping("updateTutorInfoA")
	public String updateTutorInfoA(Model model, HttpSession session, @RequestParam("tutorID") String tutorID) {
		ResultDo result = new ResultDo();
		result = serviceFit.getTutorService().TutLogin(tutorID);
		Tutor tutor = (Tutor) result.getResult();
		model.addAttribute("tutor", tutor);
		return "./superAdmin/TutorInfoA";
	}

	@RequestMapping("updateTutorInfoB")
	public String updateTutorInfoB(Model model, HttpSession session, HttpServletRequest request) {
		Tutor tutor = new Tutor();
		tutor.setTutorID(request.getParameter("tutorId"));
		tutor.setTutorName(request.getParameter("tutorName"));
		Boolean sex = new Boolean(request.getParameter("tutorSex"));
		tutor.setTutorSex(sex);
		tutor.setTutorEmail(request.getParameter("tutorEmail"));
		tutor.setTutorPhone(request.getParameter("tutorPhone"));
		ResultDo result = new ResultDo();
		result = serviceFit.getSuperAdminService().updateTutorInfoA(tutor);
		if (result.isSuccess()) {
			return "redirect:./selectTutorInfo.do";
		} else {
			return ""; // 当信息未添加成功时为添加状态
		}
	}

	@RequestMapping("pro1")
	public String pro1(Model model, HttpSession session, @RequestParam("proID") String proID,
			@RequestParam("proName") String proName) {
		try {
			proName = URLDecoder.decode(proName, "utf8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ResultDo resultDo = new ResultDo();
		resultDo = serviceFit.getSuperAdminService().selectTutorHasNoThisPower1(proID);
		if (resultDo.isSuccess()) {
			model.addAttribute("tutorList", (List) resultDo.getResult());
			model.addAttribute("proID", proID);
			model.addAttribute("proName", proName);
			
		} else {
			model.addAttribute("message", "0"); // 未在前台添加事件
		}
		return "./superAdmin/pro1";
	}
	
	
	@RequestMapping("pro2")
	public String pro2(Model model, HttpSession session, @RequestParam("proID") String proID,
			@RequestParam("proName") String proName) {
		try {
			proName = URLDecoder.decode(proName, "utf8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ResultDo resultDo = new ResultDo();
		resultDo = serviceFit.getSuperAdminService().selectTutorHasNoThisPower2(proID);
		if (resultDo.isSuccess()) {
			model.addAttribute("tutorList", (List) resultDo.getResult());
			model.addAttribute("proID", proID);
			model.addAttribute("proName", proName);
			
		} else {
			model.addAttribute("message", "0"); // 未在前台添加事件
		}
		return "./superAdmin/pro2";
	}

	
	@RequestMapping("assign1")
	public String assign1(Model model, HttpSession session,
			@RequestParam("proID") String proID, @RequestParam("tutorID") String tutorID) {
		
		proID = new StringBuffer().append(proID).append(",").toString();
		TutorIDWithPower tutorPower = (TutorIDWithPower)(serviceFit.getSuperAdminService().selectTutorIDWithPower(tutorID).getResult());

		if(tutorPower.getTutorPower1() != null)
			tutorPower.setTutorPower1(new StringBuilder().append(tutorPower.getTutorPower1()).append(proID).toString());
		else 
			tutorPower.setTutorPower1(new StringBuilder().append(proID).toString());
		serviceFit.getSuperAdminService().updateTutorPro(tutorPower.getTutorID(), tutorPower.getTutorPower1(), tutorPower.getTutorPower2());
		
		return "redirect:./powerAssign.do";
	}
	
	
	@RequestMapping("assign2")
	public String assign2(Model model, HttpSession session,
			@RequestParam("proID") String proID, @RequestParam("tutorID") String tutorID) {

		proID = new StringBuffer().append(proID).append(",").toString();
		TutorIDWithPower tutorPower = (TutorIDWithPower)(serviceFit.getSuperAdminService().selectTutorIDWithPower(tutorID).getResult());
		if(tutorPower.getTutorPower2() != null)
			tutorPower.setTutorPower2(new StringBuilder().append(tutorPower.getTutorPower2()).append(proID).toString());
		else 
			tutorPower.setTutorPower2(new StringBuilder().append(proID).toString());
		serviceFit.getSuperAdminService().updateTutorPro(tutorPower.getTutorID(), tutorPower.getTutorPower1(), tutorPower.getTutorPower2());
		
		return "redirect:./powerAssign.do";
	}
	
	
	@RequestMapping("del1")
	public String del1(Model model, HttpSession session, @RequestParam("proID") String proID,
			@RequestParam("tutorID") String tutorID) {
		proID = new StringBuffer().append(proID).append(",").toString();
		TutorIDWithPower tutorPower = (TutorIDWithPower)(serviceFit.getSuperAdminService().selectTutorIDWithPower(tutorID).getResult());
		tutorPower.setTutorPower1(tutorPower.getTutorPower1().replaceAll(proID, ""));
		ResultDo resultDo = new ResultDo();
		resultDo = serviceFit.getSuperAdminService().updateTutorPro(tutorPower.getTutorID(), tutorPower.getTutorPower1(), tutorPower.getTutorPower2());
		if(resultDo.isSuccess()) {
			model.addAttribute("message", "1");
		} else {
			model.addAttribute("message", "0");
		}
		return "redirect:./powerAssign.do";
	}
	
	@RequestMapping("del2")
	public String del2(Model model, HttpSession session, @RequestParam("proID") String proID,
			@RequestParam("tutorID") String tutorID) {
		proID = new StringBuffer().append(proID).append(",").toString();
		TutorIDWithPower tutorPower = (TutorIDWithPower)(serviceFit.getSuperAdminService().selectTutorIDWithPower(tutorID).getResult());
		tutorPower.setTutorPower2(tutorPower.getTutorPower2().replaceAll(proID, ""));
		ResultDo resultDo = new ResultDo();
		resultDo = serviceFit.getSuperAdminService().updateTutorPro(tutorPower.getTutorID(), tutorPower.getTutorPower1(), tutorPower.getTutorPower2());
		if(resultDo.isSuccess()) {
			model.addAttribute("message", "1");
		} 
		else {
			model.addAttribute("message", "0");
		}
		return "redirect:./powerAssign.do";
	}
	
	
	@RequestMapping("tutor")
	public String tutor(Model model, HttpSession session) {
		ResultDo resultDo = new ResultDo();
		resultDo = serviceFit.getSuperAdminService().selectTutor();
		if(resultDo.isSuccess()) {
			model.addAttribute("tutorList", (List) resultDo.getResult());
			model.addAttribute("message", "1");
		} 
		else {
			model.addAttribute("message", "0");
		}
		return "./superAdmin/tutor";
	}
	
	
	@RequestMapping("student")
	public String student(Model model, HttpSession session) {
		ResultDo resultDo = new ResultDo();
		resultDo = serviceFit.getSuperAdminService().selectStudent();

		if(resultDo.isSuccess()) {
			model.addAttribute("studentList", (List) resultDo.getResult());
			model.addAttribute("message", "1");
		} 
		else {
			model.addAttribute("message", "0");
		}
		return "./superAdmin/student";
	}
	
	@RequestMapping("delStu")
	public String delStu(Model model, HttpSession session, @RequestParam("stuID") String stuID) {

		ResultDo resultDo = new ResultDo();
		resultDo = serviceFit.getSuperAdminService().deleteStudent(stuID);
		if(resultDo.isSuccess()) {
			model.addAttribute("message", "1");
		} 
		else {
			model.addAttribute("message", "0");
		}
		return "redirect:./student.do";
	}
	
	@RequestMapping("delTutor")
	public String delTutor(Model model, HttpSession session, @RequestParam("tutorID") String tutorID) {

		ResultDo resultDo = new ResultDo();
		resultDo = serviceFit.getSuperAdminService().deleteTutor(tutorID);
		if(resultDo.isSuccess()) {
			model.addAttribute("message", "1");
		} 
		else {
			model.addAttribute("message", "0");
		}
		return "redirect:./tutor.do";
	}
	
	@RequestMapping("upLoadStu")
	public String upLoadStu(Model model, HttpSession session, HttpServletResponse response,
			@RequestParam("file") MultipartFile excelFile) throws Exception {
		Student stu = null;
		  
		List<Student> stuList = new ArrayList<Student>();
		POIFSFileSystem fs = new POIFSFileSystem(excelFile.getInputStream());
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet hssfSheet = null;
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			hssfSheet = wb.getSheetAt(i);
			if(hssfSheet != null) {
				HSSFRow hssfRow = null;
				if (hssfSheet != null) {
					for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
						hssfRow = hssfSheet.getRow(rowNum);
						if(hssfRow == null) {
							continue;
						}
						String ID = getStringCellValue(hssfRow.getCell(0));
						String name = getStringCellValue(hssfRow.getCell(1));
						String sexStr = getStringCellValue(hssfRow.getCell(2));
						String className = getStringCellValue(hssfRow.getCell(3));
						
						Boolean sex = sexStr.equals("男") ? false : true;
		
						if(StringUtil.isNotEmpty(ID)) {
							if(!className.contains("卓越")) {
								className = ID.substring(0, 10);
							}
							else {
								className = ID.substring(0, 4);
							}
							
							stu = new Student();
							stu.setStudentID(ID);
							stu.setStudentName(name);
							stu.setStudentClassID(className);
							stu.setStudentSex(sex);
							
							
							stuList.add(stu);
						}
						
					}
				}
			}
		}
		serviceFit.getSuperAdminService().insertStudent(stuList);
		return null;
	}
	
	@RequestMapping("upLoadTutor")
	public String upLoadTutor(Model model, HttpSession session, HttpServletResponse response,
			@RequestParam("file") MultipartFile excelFile) throws Exception {
		Tutor tutor = null;
		  
		List<Tutor> tutorList = new ArrayList<Tutor>();
		POIFSFileSystem fs = new POIFSFileSystem(excelFile.getInputStream());
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet hssfSheet = null;
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			hssfSheet = wb.getSheetAt(i);
			if(hssfSheet != null) {
				HSSFRow hssfRow = null;
				if (hssfSheet != null) {
					for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
						hssfRow = hssfSheet.getRow(rowNum);
						if(hssfRow == null) {
							continue;
						}
						String ID = getStringCellValue(hssfRow.getCell(0));
						String name = getStringCellValue(hssfRow.getCell(1));
						String sexStr = getStringCellValue(hssfRow.getCell(2));
						Boolean sex = sexStr.equals("男") ? false : true;
						if(StringUtil.isNotEmpty(ID)) {
							tutor = new Tutor();
							tutor.setTutorID(ID);
							tutor.setTutorName(name);
							tutor.setTutorSex(sex);
							tutorList.add(tutor);
						}
					}
				}
			}
		}
		serviceFit.getSuperAdminService().insertTutor(tutorList);
		return null;
	}
	
	
	@RequestMapping("download")
	public String download(Model model, HttpSession session, HttpServletResponse response) throws IOException {

		ResultDo resultDo = new ResultDo();
		resultDo = serviceFit.getSuperAdminService().selectTutor();
		List<Tutor> tutorList = (List<Tutor>)resultDo.getResult();
		List<Map<String, Object>> list = createExcelRecord(tutorList);
		String columnNames[] = { "工号", "姓名", "管理课题ID", "汇总分数课题ID" };// 列名
		String keys[] = {"ID", "name", "power1", "power2" };// map中的key
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
	
	
	
	
	
	
	
	
	
	/**
     * 获取单元格数据内容为字符串类型的数据
     * 
     * @param cell Excel单元格
     * @return String 单元格数据内容
     */
	private String getStringCellValue(HSSFCell cell) {
		String strCell = "";
		DecimalFormat df = new DecimalFormat("0");
		if(cell == null)
			return "";
		switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_STRING:
				strCell = cell.getStringCellValue();
				break;
			case HSSFCell.CELL_TYPE_NUMERIC:
				strCell = String.valueOf(df.format(cell.getNumericCellValue()));
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
	
	private List<Map<String, Object>> createExcelRecord(List<Tutor> projects) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		Tutor tutor = null;
		for (int j = 0; j < projects.size(); j++) {
			tutor = projects.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
			mapValue.put("ID", tutor.getTutorID());
			mapValue.put("name", tutor.getTutorName());
			mapValue.put("power1", tutor.getTutorPower1());
			mapValue.put("power2", tutor.getTutorPower2());
			listmap.add(mapValue);
		}
		return listmap;
	}
	
	
}
