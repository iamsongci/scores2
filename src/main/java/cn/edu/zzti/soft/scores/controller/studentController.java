package cn.edu.zzti.soft.scores.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.zzti.soft.scores.entity.Notify;
import cn.edu.zzti.soft.scores.entity.Student;
import cn.edu.zzti.soft.scores.entity.Tutor;
import cn.edu.zzti.soft.scores.entity.tools.ProjectAssignInfo;
import cn.edu.zzti.soft.scores.supervisor.ConfigDo;
import cn.edu.zzti.soft.scores.supervisor.ResultDo;
import cn.edu.zzti.soft.scores.supervisor.ServiceFit;

@Controller
@RequestMapping("/student/")
public class studentController implements ConfigDo {
	@Resource
	private ServiceFit serviceFit;
	@RequestMapping("home")
	public String homePage(Model model,HttpSession session) {
		ResultDo result = new ResultDo();
		Student stu=(Student)session.getAttribute("user");
		result = serviceFit.getNotifyService().selectNotify(stu.getStudentID());
		if(result.isSuccess()) {
			model.addAttribute("notifyList", (List<Notify>)result.getResult());
		}
		else{
			model.addAttribute("message","0" );//未在前台添加事件
		}
		model.addAttribute("menuSelected1", ConfigDo.INDEX);
		return "./student/home";
	}
	//功能未做实现-----空页面
	@RequestMapping("empty")
	public String empty(Model model) {
		model.addAttribute("menuSelected1", ConfigDo.EMPTY);
		return "./student/empty";
	}
	
	@RequestMapping("updatePorName")
	public String updatePorName(Model model,HttpSession session, @RequestParam("newProName") String newProName,  @RequestParam("index") String index){
		ResultDo resultDo = new ResultDo();
		resultDo = serviceFit.getStudentService().updateStuPorject(Integer.parseInt(index), newProName);
		if (resultDo.isSuccess()) {
			model.addAttribute("message", "1");
		} else {
			model.addAttribute("message", "0");
		}
		return "redirect:./stuSubjectInfo.do";
	}
	
	//通知
	@RequestMapping("notify")
	public String notify(Model model, HttpSession session) {
		ResultDo result = new ResultDo();
		Student stu=(Student)session.getAttribute("user");
		result = serviceFit.getNotifyService().selectNotify(stu.getStudentID());
		if(result.isSuccess()) {
			model.addAttribute("notifyList", (List<Notify>)result.getResult());
		}
		else{
			model.addAttribute("message","0" );//未在前台添加事件
		}
		return "./student/notify";
	}
	
	//查看学生课题信息
	@RequestMapping("stuSubjectInfo")
	public String stuSubjectInfo(Model model,HttpSession session){
		Student stu=(Student)session.getAttribute("user");
		ResultDo resultDo=serviceFit.getStudentService().selectStuProjectInfo(stu.getStudentID());
		if(resultDo.isSuccess()){
			model.addAttribute("projectAssignInfoList", (List<ProjectAssignInfo>)resultDo.getResult());
		}else{
			model.addAttribute("message","0" );//未在前台添加事件
		}
		model.addAttribute("menuSelected1", ConfigDo.STUSUBJECTINFO);
		return "./student/stuSubjectInfo";
	}
	
	//查看学生个人信息
	@RequestMapping("studentInfo")
	public String studentInfo(Model model,HttpSession session){
		Student stu=(Student)session.getAttribute("user");
		ResultDo resultDo=serviceFit.getStudentService().selectStuInfo(stu.getStudentID());
		if(resultDo.isSuccess()){
			model.addAttribute("studentInfo", resultDo.getResult());
		}else{
			model.addAttribute("message","0" );//未在前台添加事件
		}
		model.addAttribute("menuSelected1", ConfigDo.STUINFO);
		return "./student/stuInfo";
	}
	
	
	//修改学生个人信息---手机号码
	@RequestMapping("updateStuPhone")
	public String updateStuPhone(Model model,HttpSession session,@RequestParam("stuPhone") String stuPhone){
		Student student = (Student) session.getAttribute("user");
		String stuId=student.getStudentID();
		ResultDo resultDo=serviceFit.getStudentService().updateStuPhone(stuId, stuPhone);
		ResultDo resultDo1=serviceFit.getStudentService().selectStuInfo(student.getStudentID());
		if(resultDo.isSuccess()){
			model.addAttribute("studentInfo", resultDo1.getResult());
			model.addAttribute("message","1" );
		}else{
			model.addAttribute("message","0" );
		}
		return "./student/stuInfo";
	}
	//修改密码
	@RequestMapping("updateStuPsd")
	public String updateStuPsd(Model model,HttpSession session,@RequestParam("pwd") String pwd){
		Student student = (Student) session.getAttribute("user");
		String stuId=student.getStudentID();
		ResultDo resultDo=serviceFit.getStudentService().updateStuPsd(stuId, pwd);
		model.addAttribute("message","1" );
		return "redirect:./studentInfo.do";
	}	
}
