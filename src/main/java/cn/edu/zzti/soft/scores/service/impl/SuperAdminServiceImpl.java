package cn.edu.zzti.soft.scores.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.zzti.soft.scores.entity.Project;
import cn.edu.zzti.soft.scores.entity.Tutor;
import cn.edu.zzti.soft.scores.entity.tools.MachineChoice;
import cn.edu.zzti.soft.scores.entity.tools.TutorInfo;
import cn.edu.zzti.soft.scores.entity.tools.TutorPower;
import cn.edu.zzti.soft.scores.entity.tools.TutorWithPower;
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
		if(infoList != null) {
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
		i = daoFit.getSuperAdminDao().updateTutorPowerInfo(powerList);
		
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
		i = daoFit.getSuperAdminDao().updateTutorPwd(TutorId);
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
		i=daoFit.getSuperAdminDao().updateTutorInfoA(tutor);
		if(i!=null){
			resultDo.setResult(i);
			resultDo.setSuccess(true);
			resultDo.setMessage("导师信息修改成功");
		}else{
			resultDo.setMessage("导师信息修改失败!");
		}
		return resultDo;
	}

	@Override
	public ResultDo selectAllProject() {
		resultDo = new ResultDo();
		List<TutorWithPower> tutorList = daoFit.getSuperAdminDao().selectTutorWithPower();
		List<Project> proList = daoFit.getSuperAdminDao().selectAllProject();

		
		Integer power1Size = null;
		Integer power2Size = null;
		
		String[] pow1 = null;
		String[] pow2 = null;
		
		
		for (Project pro : proList) {
			
			for (TutorWithPower tutor : tutorList) {
				if(tutor.getPower1() != null) 
					pow1 = tutor.getPower1().split(",");
				if(tutor.getPower2() != null) 
					pow2 = tutor.getPower2().split(",");
				
				power1Size = pow1.length;
				power2Size = pow2.length;
				
				if(power1Size != 0) 
					for (int i = 0; i < power1Size; i++) {
						if(pow1[i].equals(pro.getProjectID())) {
							if(pro.getPower1() == null)
								pro.setPower1(tutor.getTutorName());
							else
								pro.setPower1(pro.getPower1() + "," + tutor.getTutorName());
						}
					}
				
				if(power2Size != 0) 
					for (int i = 0; i < power2Size; i++) {
						if(pow2[i].equals(pro.getProjectID())) {
							if(pro.getPower2() == null)
								pro.setPower2(tutor.getTutorName());
							else
								pro.setPower2(pro.getPower2() + "," + tutor.getTutorName());
						}
						
					}
			}
		}
		if(proList != null) {
			resultDo.setResult(proList);
			resultDo.setSuccess(true);
		}
		else {
			resultDo.setMessage("查询失败!");
		}
		return resultDo;
	}

/*	@Override
	public ResultDo selectTutorWithPower() {
		resultDo = new ResultDo();
		List<TutorWithPower> tutorList = daoFit.getSuperAdminDao().selectTutorWithPower();
		List<Project> proList = daoFit.getSuperAdminDao().selectAllProject();
		
//		for (TutorWithPower tutor : tutorList) {
//			if(tutor.getPower1() != null) 
//				tutor.setPower1Array(tutor.getPower1().split(","));
//		
//			if(tutor.getPower2() != null) 
//				tutor.setPower2Array(tutor.getPower2().split(","));
//		}
		
		Integer power1Size = null;
		Integer power2Size = null;
//		TutorWithPower curTutor = null;
//		Project curPro = null;
		
		
		for (Project pro : proList) {
			
			for (TutorWithPower tutor : tutorList) {
				if(tutor.getPower1() != null) 
					tutor.setPower1Array(tutor.getPower1().split(","));
				if(tutor.getPower2() != null) 
					tutor.setPower2Array(tutor.getPower2().split(","));//分割
				
				power1Size = tutor.getPower1Array().length;
				power2Size = tutor.getPower2Array().length;
				
				if(power1Size != 0) 
					for (int i = 0; i < power1Size; i++) {
						if(tutor.getPower1Array()[i] == pro.getProjectID()) {
							if(pro.getPower1() == null)
								pro.setPower1(tutor.getTutorName());
							else
								pro.setPower1(pro.getPower1() + "," + tutor.getTutorName());
						}
						
					}
				
				
				if(power2Size != 0) 
					for (int i = 0; i < power2Size; i++) {
						if(tutor.getPower2Array()[i] == pro.getProjectID()) {
							if(pro.getPower2() == null)
								pro.setPower2(tutor.getTutorName());
							else
								pro.setPower2(pro.getPower2() + "," + tutor.getTutorName());
						}
						
					}
				
				
			}
		}
		
		
		if(tutorList != null) {
			resultDo.setResult(tutorList);
			resultDo.setSuccess(true);
		}
		else {
			resultDo.setMessage("查询失败!");
		}
		return resultDo;
	}
*/

}
