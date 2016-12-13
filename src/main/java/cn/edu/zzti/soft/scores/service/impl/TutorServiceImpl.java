package cn.edu.zzti.soft.scores.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.zzti.soft.scores.entity.StudentTutorProject;
import cn.edu.zzti.soft.scores.entity.Tutor;
import cn.edu.zzti.soft.scores.entity.tools.ClassAssignInfo;
import cn.edu.zzti.soft.scores.entity.tools.MachineRoomAdmInfo;
import cn.edu.zzti.soft.scores.entity.tools.StudentAssignInfo;
import cn.edu.zzti.soft.scores.entity.tools.StudentAssignTutor;
import cn.edu.zzti.soft.scores.entity.tools.StudentInfo;
import cn.edu.zzti.soft.scores.entity.tools.StudentInfoWithScores;
import cn.edu.zzti.soft.scores.entity.tools.TutorAssignInfo;
import cn.edu.zzti.soft.scores.service.TutorService;
import cn.edu.zzti.soft.scores.supervisor.DaoFit;
import cn.edu.zzti.soft.scores.supervisor.ResultDo;
import cn.edu.zzti.soft.scores.util.StringUtil;
@Service("tutorServiceImpl")
public class TutorServiceImpl implements TutorService {
	ResultDo resultDo;
	@Resource
	private DaoFit daoFit;
	
	public ResultDo selectMachRoomInfo(String tutorId) {
		resultDo = new ResultDo();
		MachineRoomAdmInfo machRoomAdmInfo = null;
		if(StringUtil.isNotEmpty(tutorId))
			machRoomAdmInfo = daoFit.getTutorDao().selectMachRoomInfo(tutorId);
		if(machRoomAdmInfo != null) {
			resultDo.setResult(machRoomAdmInfo);
			resultDo.setSuccess(true);
		}
		else {
			resultDo.setMessage("查询失败!");
		}
		return resultDo;
	}
	
	public ResultDo insertStuProScore(List<StudentTutorProject> scoreList) {
		resultDo = new ResultDo();
		Integer i = null;
		if(scoreList.size() != 0 && scoreList != null) {
			i = daoFit.getTutorDao().insertStuProScore(scoreList);
		}
		if(i != null && i == scoreList.size()) {
			resultDo.setResult(i);
			resultDo.setSuccess(true);
		} 
		else {
			resultDo.setMessage("插入失败!");
		}
		return resultDo;
	}
	
	public ResultDo updateStuProScore(List<StudentTutorProject> scoreList) {
		resultDo = new ResultDo();
		Integer i = null;
		if(scoreList.size() !=0 && scoreList != null) {
			i = daoFit.getTutorDao().updateStuProScore(scoreList);
		}
		if(i != null) {
			resultDo.setResult(i);
			resultDo.setSuccess(true);
		} 
		else {
			resultDo.setMessage("插入失败!");
		}
		return resultDo;
	}
	public ResultDo findAllStu(String tutorId) {
		resultDo = new ResultDo();
		List<StudentInfo> stuList = null;
		if(StringUtil.isNotEmpty(tutorId)) {
			stuList = daoFit.getTutorDao().findAllStu(tutorId);
		}
		if(stuList != null) {
			resultDo.setResult(stuList);
			resultDo.setSuccess(true);
		}
		else {
			resultDo.setMessage("查询失败!");
		}
		return resultDo;
	}
	public ResultDo updateTutorPhoAndEma(String tutorId, String tutorPho,
			String tutorEma) {
		resultDo = new ResultDo();
		Integer i = null;
		if(StringUtil.isNotEmpty(tutorId))
			i = daoFit.getTutorDao().updateTutorPhoAndEma(tutorId, tutorPho, tutorEma);
		if(i != null && i == 1) {
			resultDo.setResult(i);
			resultDo.setSuccess(true);
		}
		else {
			resultDo.setMessage("更新失败!");
		}
		return resultDo;
	}
	public ResultDo updateTutorPsd(String tutorId, String tutorPsd) {
		resultDo = new ResultDo();
		Integer i = null;
		if(StringUtil.isNotEmpty(tutorId))
			i = daoFit.getTutorDao().updateTutorPsd(tutorId, tutorPsd);
		if(i != null && i == 1) {
			resultDo.setResult(i);
			resultDo.setSuccess(true);
		}
		else {
			resultDo.setMessage("更新失败!");
		}
		return resultDo;
	}
	public ResultDo selectTutorAssignInfo() {
		resultDo = new ResultDo();
		List<TutorAssignInfo> infoList = daoFit.getTutorDao().selectTutorAssignInfo();
		if(infoList.size() != 0 && infoList != null) {
			resultDo.setSuccess(true);
			resultDo.setResult(infoList);
		}
		else {
			resultDo.setMessage("查询失败!");
		}
		return resultDo;
	}
	public ResultDo selectClassAssignInfo() {
		resultDo = new ResultDo();
		List<ClassAssignInfo> infoList = daoFit.getTutorDao().selectClassAssignInfo();
		if (infoList.size() != 0 && infoList != null) {
			resultDo.setSuccess(true);
			resultDo.setResult(infoList);
		}
		else {
			resultDo.setMessage("查询失败!");
		}
		return resultDo;
	}
	public ResultDo selectStudentAssignInfo() {
		resultDo = new ResultDo();
		List<StudentAssignInfo> infoList = daoFit.getTutorDao().selectStudentAssignInfo();
		if (infoList.size() != 0 && infoList != null) {
			resultDo.setSuccess(true);
			resultDo.setResult(infoList);
		}
		else {
			resultDo.setMessage("查询失败!");
		}
		return resultDo;
	}
	public ResultDo updateStuAssignTutorInfo(List<StudentAssignTutor> assignInfo) {
		resultDo = new ResultDo();
		Integer i = null;
		if(assignInfo.size() != 0 && assignInfo != null) {
			i = daoFit.getTutorDao().updateStuAssignTutorInfo(assignInfo);
		}
		if(i != null) {
			resultDo.setSuccess(true);
			resultDo.setResult(i);
		}
		else {
			resultDo.setMessage("更新失败!");
		}
		return resultDo;
	}

	public ResultDo TutLogin(String tutorId) {
		resultDo = new ResultDo();
		Tutor tut=null;
	
	    if(StringUtil.isNotEmpty(tutorId))
	     tut=daoFit.getTutorDao().tutLogin(tutorId);
	    if(tut!=null){
			resultDo.setSuccess(true);
			resultDo.setResult(tut);
		}else {
			resultDo.setMessage("用户信息不存在！");
		}
		return resultDo;
	}

	@Override
	public ResultDo selectStudentInfoWithScores(String tutorID) {
		resultDo = new ResultDo();
		List<StudentInfoWithScores> stuList = null;
		if(StringUtil.isNotEmpty(tutorID)) {
			stuList = daoFit.getTutorDao().selectStudentInfoWithScores(tutorID);
		}
		if(stuList != null) {
			resultDo.setResult(stuList);
			resultDo.setSuccess(true);
		}
		else {
			resultDo.setMessage("查询失败!");
		}
		return resultDo;
	}

}
