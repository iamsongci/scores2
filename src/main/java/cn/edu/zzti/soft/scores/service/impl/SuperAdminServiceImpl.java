package cn.edu.zzti.soft.scores.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.zzti.soft.scores.entity.Tutor;
import cn.edu.zzti.soft.scores.entity.tools.MachineChoice;
import cn.edu.zzti.soft.scores.entity.tools.TutorInfo;
import cn.edu.zzti.soft.scores.entity.tools.TutorPower;
import cn.edu.zzti.soft.scores.service.MachineRoomAdminService;
import cn.edu.zzti.soft.scores.service.SuperAdminService;
import cn.edu.zzti.soft.scores.supervisor.DaoFit;
import cn.edu.zzti.soft.scores.supervisor.ResultDo;
@Service("superAdminServiceImpl")
public class SuperAdminServiceImpl implements SuperAdminService {
	ResultDo resultDo;
	@Resource
	private DaoFit daoFit;
	
	public ResultDo selectTutorInfo() {
		resultDo = new ResultDo();
		List<TutorInfo> infoList = daoFit.getSuperAdminDao().selectTutorInfo();
		if(infoList != null && infoList.size() != 0) {
			resultDo.setResult(infoList);
			resultDo.setSuccess(true);
		}
		else {
			resultDo.setMessage("查询失败或列表为空!");
		}
		return resultDo;
	}
	
	public ResultDo updateTutorInfo(List<TutorInfo> infoList) {
		resultDo = new ResultDo();
		Integer i = null;
		if(infoList.size() != 0 && infoList != null)
			i = daoFit.getSuperAdminDao().updateTutorInfo(infoList);
		if(i != null) {
			resultDo.setResult(i);
			resultDo.setSuccess(true);
		} 
		else {
			resultDo.setMessage("更新失败!");
		}
		return resultDo;
	}
	
	public ResultDo updateTutorPowerInfo(List<TutorPower> powerList) {
		resultDo = new ResultDo();
		Integer i = null;
		if(powerList.size() != 0 && powerList != null) {
			i = daoFit.getSuperAdminDao().updateTutorPowerInfo(powerList);
		}
		if(i != null) {
			resultDo.setResult(i);
			resultDo.setSuccess(true);
		} 
		else {
			resultDo.setMessage("更新失败!");
		}
		return resultDo;
	}

	public ResultDo updateTutorPwd(String TutorId) {
		// TODO Auto-generated method stub
		resultDo = new ResultDo();
		Integer i = null;
		if(TutorId!=null||TutorId!=""){
			i = daoFit.getSuperAdminDao().updateTutorPwd(TutorId);
		}
		if(i!=null){
			resultDo.setResult(i);
			resultDo.setSuccess(true);
			resultDo.setMessage("重置成功");
		}else{
			resultDo.setMessage("重置失败!");
		}
		return resultDo;
	}

	public ResultDo updateTutorInfoA(Tutor tutor) {
		// TODO Auto-generated method stub
		resultDo = new ResultDo();
		Integer i = null;
		if(tutor.getTutorID()!=null){
			i=daoFit.getSuperAdminDao().updateTutorInfoA(tutor);
		}
		if(i!=null){
			resultDo.setResult(i);
			resultDo.setSuccess(true);
			resultDo.setMessage("导师信息修改成功");
		}else{
			resultDo.setMessage("导师信息修改失败!");
		}
		return resultDo;
	}


}
