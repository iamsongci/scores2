package cn.edu.zzti.soft.scores.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.zzti.soft.scores.entity.Notify;
import cn.edu.zzti.soft.scores.entity.Project;
import cn.edu.zzti.soft.scores.entity.Tutor;
import cn.edu.zzti.soft.scores.entity.tools.TutorInfo;
import cn.edu.zzti.soft.scores.supervisor.ConfigDo;
import cn.edu.zzti.soft.scores.supervisor.ResultDo;
import cn.edu.zzti.soft.scores.supervisor.ServiceFit;
@Controller
@RequestMapping("/superAdmin/")
public class SuperAdminController implements ConfigDo{
	@Resource
	private ServiceFit serviceFit;
	@RequestMapping("home")
	public String homePage(Model model,HttpSession session) {
		model.addAttribute("menuSelected1", ConfigDo.INDEX);
		return "./superAdmin/home";
	}
	//功能未做实现-----空页面
	@RequestMapping("empty")
	public String empty(Model model) {
		model.addAttribute("menuSelected1", ConfigDo.EMPTY);
		return "./superAdmin/empty";
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
		serviceFit.getNotifyService().insertNotify(new Notify(null, title, content, "zzti", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), toStudent));
		return "./superAdmin/notify";
	}
	
	@RequestMapping("powerAssign")
	public String powerAssign(Model model,HttpSession session) {
		ResultDo resultDo = null;
		resultDo = serviceFit.getSuperAdminService().selectAllProject();
		//List<Project> proList = (List<Project>)resultDo.getResult();
		if(resultDo.isSuccess()){
			model.addAttribute("proList", (List)resultDo.getResult());
		} else {
			model.addAttribute("message", "0");
		}
		model.addAttribute("menuSelected1", ConfigDo.SUPTUTOR);
		model.addAttribute("menuSelected2", ConfigDo.SUPTUTORPOWER);
		
		return "./superAdmin/powerAssign";
	}
	
	
	
	
	
	
	//通知
	@RequestMapping("notify")
	public String notify(Model model, HttpSession session) {
		ResultDo result = new ResultDo();
		result = serviceFit.getNotifyService().selectAllNotify();
		if(result.isSuccess()) {
			model.addAttribute("notifyList", (List<Notify>)result.getResult());
		}
		else{
			model.addAttribute("message","0" );//未在前台添加事件
		}
		model.addAttribute("menuSelected1", ConfigDo.SUPNOTIFY);
		return "./superAdmin/notify";
	}
	
	//导师信息查看
	@RequestMapping("selectTutorInfo")
	public String selectTutorInfo(Model model,HttpSession session){
		ResultDo result =new ResultDo();
		result=serviceFit.getSuperAdminService().selectTutorInfo();
		if(result.isSuccess()){
			model.addAttribute("tutorList", (List)result.getResult());
			model.addAttribute("menuSelected1", ConfigDo.SUPTUTOR);
			model.addAttribute("menuSelected2", ConfigDo.SUPTUTORINFO);
			return "./superAdmin/supTutorInfo";
		}else{
			return "./superAdmin/empty";
		}
	}
	//导师重置密码
	@RequestMapping("resetPassword")
	public  @ResponseBody Map<String, Object> resetPassword(HttpSession session,@RequestParam("TutorId") String TutorId){
		ResultDo result =new ResultDo();
		Map<String, Object> map = new HashMap<String, Object>();
		String mag = "";
		boolean flag = false;
		result=serviceFit.getSuperAdminService().updateTutorPwd(TutorId);
		if(result.isSuccess()){
			flag = true;
			mag = "重置密码成功.";
		}else{
			mag = "密码重置失败";
		}
		map.put("status", flag);
		map.put("mag", mag);
		return map;
	}
	//导师基本信息修改
	@RequestMapping("updateTutorInfoA")
	public  String updateTutorInfoA(Model model,HttpSession session,@RequestParam("tutorID") String tutorID){
		ResultDo result =new ResultDo();
		result=serviceFit.getTutorService().TutLogin(tutorID);
		Tutor tutor=(Tutor)result.getResult();
		model.addAttribute("tutor", tutor);
		return "./superAdmin/TutorInfoA";
}
	@RequestMapping("updateTutorInfoB")
	public  String updateTutorInfoB(Model model,HttpSession session,HttpServletRequest request){
		Tutor tutor=new Tutor();
		tutor.setTutorID( request.getParameter("tutorId"));
		tutor.setTutorName(request.getParameter("tutorName"));
		Boolean sex=new Boolean(request.getParameter("tutorSex"));
		tutor.setTutorSex(sex);
		tutor.setTutorEmail(request.getParameter("tutorEmail"));
		tutor.setTutorPhone(request.getParameter("tutorPhone"));
		ResultDo result =new ResultDo();
		result=serviceFit.getSuperAdminService().updateTutorInfoA(tutor);
		if(result.isSuccess()){
			return "redirect:./selectTutorInfo.do";
		}else{
			return "";  //当信息未添加成功时为添加状态
		}
	}


}
