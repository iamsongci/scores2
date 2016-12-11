package cn.edu.zzti.soft.scores.supervisor;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.zzti.soft.scores.dao.TutorDao;
import cn.edu.zzti.soft.scores.entity.Notify;
import cn.edu.zzti.soft.scores.service.MachineRoomAdminService;
import cn.edu.zzti.soft.scores.service.NotifyService;
import cn.edu.zzti.soft.scores.service.StudentService;
import cn.edu.zzti.soft.scores.service.SuperAdminService;
import cn.edu.zzti.soft.scores.service.TutorService;

@Repository
public class ServiceFit {
	
	@Resource
	private StudentService studentService;
	@Resource
	private MachineRoomAdminService machineRoomAdminService;
	@Resource
	private SuperAdminService superAdminService;
	@Resource
	private TutorService tutorService;
	@Resource
	private NotifyService notifyService;
	
	
	public NotifyService getNotifyService() {
		return notifyService;
	}
	public void setNotifyService(NotifyService notifyService) {
		this.notifyService = notifyService;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public MachineRoomAdminService getMachineRoomAdminService() {
		return machineRoomAdminService;
	}
	public void setMachineRoomAdminService(
			MachineRoomAdminService machineRoomAdminService) {
		this.machineRoomAdminService = machineRoomAdminService;
	}
	public SuperAdminService getSuperAdminService() {
		return superAdminService;
	}
	public void setSuperAdminService(SuperAdminService superAdminService) {
		this.superAdminService = superAdminService;
	}
	public TutorService getTutorService() {
		return tutorService;
	}
	public void setTutorService(TutorService tutorService) {
		this.tutorService = tutorService;
	}

}
