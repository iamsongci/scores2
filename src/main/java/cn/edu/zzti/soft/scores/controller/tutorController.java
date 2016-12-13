package cn.edu.zzti.soft.scores.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.zzti.soft.scores.entity.Notify;
import cn.edu.zzti.soft.scores.entity.StudentTutorProject;
import cn.edu.zzti.soft.scores.entity.Tutor;
import cn.edu.zzti.soft.scores.entity.tools.StudentInfo;
import cn.edu.zzti.soft.scores.entity.tools.StudentInfoWithScores;
import cn.edu.zzti.soft.scores.supervisor.ConfigDo;
import cn.edu.zzti.soft.scores.supervisor.ResultDo;
import cn.edu.zzti.soft.scores.supervisor.ServiceFit;
@Controller
@RequestMapping("/tutor/")
public class tutorController implements ConfigDo{
	@Resource
	private ServiceFit serviceFit;
	@RequestMapping("home")
	public String homePage(Model model,HttpSession session) {
		model.addAttribute("menuSelected1", ConfigDo.INDEX);
		return "./tutor/home";
	}
	//功能未做实现-----空页面
	@RequestMapping("empty")
	public String empty(Model model) {
		model.addAttribute("menuSelected1", ConfigDo.EMPTY);
		return "./tutor/empty";
	}
	
	//更新学生分数
	@RequestMapping("updateStudentScore")
	public String updateStudentScore(Model model,HttpSession session, @RequestParam("score")String score, @RequestParam("curindex")String curindex) {
		StudentTutorProject stu = new StudentTutorProject();
		stu.setIndex(curindex);
		stu.setStudentTotalScore(Integer.parseInt(score));
		List<StudentTutorProject> scoreList = new ArrayList<StudentTutorProject>();
		scoreList.add(stu);
		ResultDo resultDo = serviceFit.getTutorService().updateStuProScore(scoreList);
		if(resultDo.isSuccess()){
			model.addAttribute("message","1" );
		}else{
			model.addAttribute("message","0" );
		}
		return "redirect:./myStuInfoWithScores.do";
	}
	
	//导出我的学生信息
	@RequestMapping("exportExcel")
	public void exportExcel(Model model, HttpSession session, HttpServletResponse response) {
		Tutor tutor=(Tutor)session.getAttribute("user");
		ResultDo result = new ResultDo();
		String tutorID = tutor.getTutorID();
		result = serviceFit.getTutorService().selectStudentInfoWithScores(tutorID);
		List<StudentInfoWithScores> infoList = (List<StudentInfoWithScores>)result.getResult();
		Integer size = infoList.size();
		String codedFileName = "我的学生信息";
		OutputStream fOut = null;
		try {
			codedFileName = java.net.URLEncoder.encode("中文", "UTF-8");
			response.setHeader("content-disposition", "attachment;filename=" + codedFileName + ".xls");
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet();
			HSSFCell cell = null;
			String[] stuStr = null;
			StudentInfoWithScores stuInfo = null;
			HSSFRow row = sheet.createRow((int) 0);
			cell = row.createCell((int) 0);
			cell.setCellValue("学号");
			cell = row.createCell((int) 1);
			cell.setCellValue("姓名");
			cell = row.createCell((int) 2);
			cell.setCellValue("课题类型");
			cell = row.createCell((int) 3);
			cell.setCellValue("成绩");
			
			for (int i = 1; i < size + 1; i++) {
				stuInfo = infoList.get(i - 1);
				row  = sheet.createRow(i);
				stuStr = new String[] {stuInfo.getStudentID(), stuInfo.getStudentName(), stuInfo.getProjectName()};
				for (int j = 0; j < 2; j++) {
					cell = row.createCell(j);
					cell.setCellValue(stuStr[j]);
				}
			}
			fOut = response.getOutputStream();
			workbook.write(fOut);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fOut.flush();
				fOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			session.setAttribute("state", "open");
		}
		System.out.println("文件生成...");
	}

	@RequestMapping("check")
	public void check(HttpServletRequest request, HttpServletResponse response) {
		try {
			if ("open".equals(request.getSession().getAttribute("state"))) {
				request.getSession().setAttribute("state", null);
				response.getWriter().write("true");
				response.getWriter().flush();
			} else {
				response.getWriter().write("false");
				response.getWriter().flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//我的学生成绩信息
	@RequestMapping("myStuInfoWithScores") 
	public String myStuInfoWithScores(Model model,HttpSession session) {
		Tutor tutor=(Tutor)session.getAttribute("user");
		String tutorID= tutor.getTutorID();
		ResultDo result = new ResultDo();
		result = serviceFit.getTutorService().selectStudentInfoWithScores(tutorID);
		if(result.isSuccess()) {
			model.addAttribute("info", (List<StudentInfoWithScores>)result.getResult());
		}
		else{
			model.addAttribute("message","0" );
		}
		return "./tutor/myStuInfoWithScores";
	}
	
	//我的学生信息
	@RequestMapping("myStuInfo")
	public String myStuInfo(Model model,HttpSession session) {
		Tutor tutor=(Tutor)session.getAttribute("user");
		ResultDo result = new ResultDo();
		String tutorID= tutor.getTutorID();
		result = serviceFit.getTutorService().findAllStu(tutorID);
		if(result.isSuccess()) {
			model.addAttribute("info", (List<StudentInfo>)result.getResult());
		}
		else{
			model.addAttribute("message","0" );//未在前台添加事件
		}
		
		return "./tutor/myStuInfo";
	}
	
	//我的机房信息
	@RequestMapping("myMrInfo")
	public String myMrInfo(Model model,HttpSession session) {
		Tutor tutor=(Tutor)session.getAttribute("user");
		ResultDo result = new ResultDo();
		String tutorID= tutor.getTutorID();
		result = serviceFit.getTutorService().selectMachRoomInfo(tutorID);
		if(result.isSuccess()) {
			model.addAttribute("info", result.getResult());
		}
		else{
			model.addAttribute("message","0" );//未在前台添加事件
		}
		
		return "./tutor/myMrInfo";
	}
	
	
	//删除通知
	@RequestMapping("deleteNotify")
	public String deleteNotify(Model model,HttpSession session, @RequestParam("notifyID")String notifyID) {
		serviceFit.getNotifyService().deleteNotify(notifyID);
		return "redirect:./notify.do";
	}
	
	//新建通知
	@RequestMapping("createNotify")
	public String createNotify(Model model,HttpSession session, @RequestParam("title")String title, @RequestParam("content") String content, @RequestParam("toStudent") Boolean toStudent) {
		Tutor tutor=(Tutor)session.getAttribute("user");
		
		serviceFit.getNotifyService().insertNotify(new Notify(null, title, content, tutor.getTutorName(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), toStudent));
		return "./tutor/notify";
	}
	
	//通知
	@RequestMapping("notify")
	public String notify(Model model, HttpSession session) {
		Tutor tutor=(Tutor)session.getAttribute("user");
		ResultDo result = new ResultDo();
		result = serviceFit.getNotifyService().selectAllNotify();
		if(result.isSuccess()) {
			model.addAttribute("notifyList", (List<Notify>)result.getResult());
			model.addAttribute("user", tutor);
		}
		else{
			model.addAttribute("message","0" );//未在前台添加事件
		}
		return "./tutor/notify";
	}
	
	//查看个人信息
	@RequestMapping("teaInfo")
	public String tutorInfo(Model model,HttpSession session){
		Tutor tutor=(Tutor)session.getAttribute("user");
		ResultDo resultDo=serviceFit.getTutorService().TutLogin(tutor.getTutorID());
		if(resultDo.isSuccess()){
			model.addAttribute("teaInfo", resultDo.getResult());
		}else{
			model.addAttribute("message","0" );//未在前台添加事件
		}
		model.addAttribute("menuSelected1", ConfigDo.TEAINFO);
		return "./tutor/teaInfo";
	}
	
	//更新老师信息
	@RequestMapping("updateTutorInfo")
	public String updateTutorInfo(Model model,HttpSession session,@RequestParam("tutorPhone") String tutorPhone, @RequestParam("tutorEmail") String tutorEmail){
		Tutor tutor=(Tutor)session.getAttribute("user");
		ResultDo resultDo=serviceFit.getTutorService().updateTutorPhoAndEma(tutor.getTutorID(), tutorPhone, tutorEmail);
		ResultDo resultDo1=serviceFit.getTutorService().TutLogin(tutor.getTutorID());
		if(resultDo.isSuccess()){
			model.addAttribute("teaInfo", resultDo1.getResult());
			model.addAttribute("message","1" );
		}else{
			model.addAttribute("message","0" );
		}
		return "./tutor/teaInfo";
	}
	
	//修改个人信息--密码
	@RequestMapping("updateTutorPsd")
	public String updateTutorPsd(Model model,HttpSession session,@RequestParam("pwd") String pwd){
		Tutor tutor=(Tutor)session.getAttribute("user");
		ResultDo resultDo=serviceFit.getTutorService().updateTutorPsd(tutor.getTutorID(), pwd);
		model.addAttribute("message","1" );
		return "redirect:./teaInfo.do";
	}
	
	
	
}
