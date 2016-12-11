package cn.edu.zzti.soft.scores.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.edu.zzti.soft.scores.entity.Student;
import cn.edu.zzti.soft.scores.entity.Tutor;
import cn.edu.zzti.soft.scores.supervisor.ResultDo;
import cn.edu.zzti.soft.scores.supervisor.ServiceFit;

@Controller
@RequestMapping("/")
public class Login {
	@Resource
	private ServiceFit serviceFit;
	@RequestMapping("login")
	public  ModelAndView viewAll(Map model,RedirectAttributes attr,@RequestParam("p") String p,@RequestParam("u") String u,HttpSession session){
		u = u.trim();
		String role="index";
		ModelAndView mv=new ModelAndView();
		session.setAttribute("isLogin",null);
		int n=u.length();
		if(n==2||n==3){//判断导师姓名进行登录
			ResultDo resultDo=serviceFit.getTutorService().TutLogin(u);
			Tutor tut=(Tutor)resultDo.getResult();
			if(resultDo.isSuccess()){
				if(tut.getTutorPassword().equals(p)){
					if(tut.getTutorPower1().equals("1")&&tut.getTutorPower2().equals("1")){
						session.setAttribute("isLogin","true");
						role="redirect:./mrAdmin/home.do";
						session.setAttribute("pathCode","mrAdmin");
					}else{
						session.setAttribute("isLogin","true");
						role="redirect:./tutor/home.do";
						session.setAttribute("pathCode", "tutor");
					}
					session.setAttribute("user",tut);
				}else{
					model.put("message", "用户名或密码不正确，请重新输入！");
				}
			}else{
		    	model.put("message", resultDo.getMessage());
		    }
		}else if(n==12){//判斷是學生登录
			ResultDo resultDo=serviceFit.getStudentService().stuLogin(u);
			Student stu=(Student)resultDo.getResult();
		    if(resultDo.isSuccess()){
		    	if(stu.getStudentPassword().equals(p)){
		    		session.setAttribute("user",stu);
		    		session.setAttribute("isLogin","true");
		    		role="redirect:./student/home.do";
		    		session.setAttribute("pathCode", "student");
		    	}else{
		    		model.put("message", "用户名或密码不正确，请重新输入！");
		    	}
		    	
		    }else{
		    	model.put("message", resultDo.getMessage());
		    }
		}else if(u.equals("zzti")&&p.equals("zzti00")){//跳转超级管理员界面
			session.setAttribute("isLogin","true");
			session.setAttribute("pathCode", "superAdmin");
			role="redirect:./superAdmin/home.do";
		}else{
			model.put("message", "您输入的内容有误，请重试");
		}
		return	new ModelAndView(role,model);
		
	}
	//登出
	  @RequestMapping("logout")
	    public String logout(HttpSession session){
	        session.invalidate();
	        return "./index";
	    }
	
}
