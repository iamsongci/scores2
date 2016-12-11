package cn.edu.zzti.soft.scores.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.zzti.soft.scores.entity.Notify;
import cn.edu.zzti.soft.scores.entity.Student;
import cn.edu.zzti.soft.scores.entity.Tutor;
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
