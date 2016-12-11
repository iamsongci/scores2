package cn.edu.zzti.soft.scores.supervisor;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.zzti.soft.scores.dao.MachineRoomAdminDao;
import cn.edu.zzti.soft.scores.dao.StudentDao;
import cn.edu.zzti.soft.scores.dao.SuperAdminDao;
import cn.edu.zzti.soft.scores.dao.TutorDao;
import cn.edu.zzti.soft.scores.dao.NotifyDao;


@Repository
public class DaoFit {
	@Resource
	private StudentDao studentDao;
	
	@Resource
	private TutorDao tutorDao;
	
	@Resource
	private MachineRoomAdminDao machineRoomAdminDao;
	
	@Resource
	private SuperAdminDao superAdminDao;
	
	@Resource
	private NotifyDao NotifyDao;

	public NotifyDao getNotifyDao() {
		return NotifyDao;
	}

	public void setNotifyDao(NotifyDao notifyDao) {
		NotifyDao = notifyDao;
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public TutorDao getTutorDao() {
		return tutorDao;
	}

	public void setTutorDao(TutorDao tutorDao) {
		this.tutorDao = tutorDao;
	}

	public MachineRoomAdminDao getMachineRoomAdminDao() {
		return machineRoomAdminDao;
	}

	public void setMachineRoomAdminDao(MachineRoomAdminDao machineRoomAdminDao) {
		this.machineRoomAdminDao = machineRoomAdminDao;
	}

	public SuperAdminDao getSuperAdminDao() {
		return superAdminDao;
	}

	public void setSuperAdminDao(SuperAdminDao superAdminDao) {
		this.superAdminDao = superAdminDao;
	}

	
}
