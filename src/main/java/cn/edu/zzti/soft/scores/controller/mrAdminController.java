package cn.edu.zzti.soft.scores.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.zzti.soft.scores.entity.MachineRoom;
import cn.edu.zzti.soft.scores.entity.Notify;
import cn.edu.zzti.soft.scores.entity.Tutor;
import cn.edu.zzti.soft.scores.supervisor.ConfigDo;
import cn.edu.zzti.soft.scores.supervisor.ResultDo;
import cn.edu.zzti.soft.scores.supervisor.ServiceFit;

@Controller
@RequestMapping("/mrAdmin/")
public class mrAdminController implements ConfigDo {
	@Resource
	private ServiceFit serviceFit;

	@RequestMapping("home")
	public String homePage(Model model, HttpSession session) {
		model.addAttribute("menuSelected1", ConfigDo.INDEX);
		return "./mrAdmin/home";
	}

	// 功能未做实现-----空页面
	@RequestMapping("empty")
	public String empty(Model model) {
		model.addAttribute("menuSelected1", ConfigDo.EMPTY);
		return "./mrAdmin/empty";
	}

	// 删除通知
	@RequestMapping("deleteNotify")
	public String deleteNotify(Model model, HttpSession session,
			@RequestParam("notifyID") String notifyID) {
		serviceFit.getNotifyService().deleteNotify(notifyID);
		return "redirect:./notify.do";
	}

	// 新建通知
	@RequestMapping("createNotify")
	public String createNotify(Model model, HttpSession session,
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam("toStudent") Boolean toStudent) {
		Tutor tutor = (Tutor) session.getAttribute("user");

		serviceFit.getNotifyService().insertNotify(
				new Notify(null, title, content, tutor.getTutorName(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),
						toStudent));
		return "./superAdmin/notify";
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

	// 个人信息
	@RequestMapping("mrTeaInfo")
	public String mrTeaInfo(Model model, HttpSession session) {
		Tutor tutor = (Tutor) session.getAttribute("user");
		ResultDo resultDo = serviceFit.getTutorService().TutLogin(
				tutor.getTutorID());
		if (resultDo.isSuccess()) {
			model.addAttribute("mrTeaInfo", resultDo.getResult());
		} else {
			model.addAttribute("message", "0");// 未在前台添加事件
		}
		model.addAttribute("menuSelected1", ConfigDo.MRTEAINFO);
		return "./mrAdmin/mrTeaInfo";
	}

	// 更新老师信息
	@RequestMapping("updateMrAdminInfo")
	public String updateMrAdminInfo(Model model, HttpSession session,
			@RequestParam("tutorPhone") String tutorPhone,
			@RequestParam("tutorEmail") String tutorEmail) {
		Tutor tutor = (Tutor) session.getAttribute("user");
		ResultDo resultDo = serviceFit.getTutorService().updateTutorPhoAndEma(
				tutor.getTutorID(), tutorPhone, tutorEmail);
		ResultDo resultDo1 = serviceFit.getTutorService().TutLogin(
				tutor.getTutorID());
		if (resultDo.isSuccess()) {
			model.addAttribute("mrTeaInfo", resultDo1.getResult());
			model.addAttribute("message", "1");
		} else {
			model.addAttribute("message", "0");
		}
		return "./mrAdmin/mrTeaInfo";
	}

	// 修改个人信息--密码
	@RequestMapping("updateMrAdminPsd")
	public String updateMrAdminPsd(Model model, HttpSession session,
			@RequestParam("pwd") String pwd) {
		Tutor tutor = (Tutor) session.getAttribute("user");
		ResultDo resultDo = serviceFit.getTutorService().updateTutorPsd(
				tutor.getTutorID(), pwd);
		model.addAttribute("message", "1");
		return "redirect:./mrTeaInfo.do";
	}

	// 导师机房分配
	@RequestMapping("mrAssign")
	public String mrAssign(Model model, HttpSession session) {
		ResultDo resultDo = serviceFit.getTutorService()
				.selectTutorAssignInfo();
		if (resultDo.isSuccess()) {
			model.addAttribute("assignInfo", resultDo.getResult());
		} else {
			model.addAttribute("message", "0");// 未在前台添加事件
		}
		model.addAttribute("menuSelected1", ConfigDo.MRTEAINFO);
		return "./mrAdmin/mrAssign";
	}

	// 机房信息维护
	@RequestMapping("mrInfo")
	public String mrInfo(Model model, HttpSession session) {
		ResultDo resultDo = serviceFit.getMachineRoomAdminService()
				.selectMachRoomInfo();
		if (resultDo.isSuccess()) {
			model.addAttribute("mrInfo", (List) resultDo.getResult());
		} else {
			model.addAttribute("message", "0");// 未在前台添加事件
		}
		model.addAttribute("menuSelected1", ConfigDo.MRINFO);
		return "./mrAdmin/mrInfo";
	}

	// 更新机房信息
	@RequestMapping("updateMrInfo")
	public String updateMrInfo(Model model, HttpSession session,
			@RequestParam("mrID") String mrID) {
		ResultDo resultDo = serviceFit.getMachineRoomAdminService()
				.selectMachRoomByID(mrID);
		if (resultDo.isSuccess()) {
			model.addAttribute("mrInfo", resultDo.getResult());
		} else {
			model.addAttribute("message", "0");// 未在前台添加事件
		}
		model.addAttribute("menuSelected1", ConfigDo.MRINFO);

		return "./mrAdmin/updateMrInfo";
	}

	// 更新机房信息
	@RequestMapping("updateMrSeatNum")
	public String updateMrSeatNum(Model model, HttpSession session,
			@RequestParam("id") String machineRoomID,
			@RequestParam("num") String machineNumbers) {
		List<MachineRoom> roomList = new ArrayList<MachineRoom>();
		roomList.add(new MachineRoom(machineRoomID, Integer
				.parseInt(machineNumbers)));
		ResultDo resultDo = serviceFit.getMachineRoomAdminService()
				.updateMachRoomSeatNum(roomList);
		model.addAttribute("message", "1");
		return "redirect:./mrInfo.do";
	}

	// 分配
	@RequestMapping("assign")
	public String assign(Model model, HttpSession session,
			@RequestParam("tutorName") String tutorName,
			@RequestParam("tutorID") String tutorID) {
		ResultDo resultDo = serviceFit.getMachineRoomAdminService()
				.selectMachRoomInfo();
		try {
			tutorName = URLDecoder.decode(tutorName, "utf8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (resultDo.isSuccess()) {
			model.addAttribute("tutorName", tutorName);
			System.out.println(tutorName);
			model.addAttribute("tutorID", tutorID);
			model.addAttribute("mrInfo", (List) resultDo.getResult());
		} else {
			model.addAttribute("message", "0");// 未在前台添加事件
		}
		model.addAttribute("menuSelected1", ConfigDo.MRINFO);
		return "./mrAdmin/assign";
	}

}
