package cn.edu.zzti.soft.scores.service;

import java.util.List;

import cn.edu.zzti.soft.scores.entity.Project;
import cn.edu.zzti.soft.scores.entity.Tutor;
import cn.edu.zzti.soft.scores.entity.tools.TutorInfo;
import cn.edu.zzti.soft.scores.entity.tools.TutorPower;
import cn.edu.zzti.soft.scores.entity.tools.TutorWithPower;
import cn.edu.zzti.soft.scores.supervisor.ResultDo;

public interface SuperAdminService {
	
	/**
	 * 查询导师信息
	 * @return
	 */
	ResultDo selectTutorInfo();
	/**
	 * 导师密码重置
	 * @param TutorId
	 * @return
	 */
	ResultDo updateTutorPwd(String TutorId);
	
	/**
	 * 更新导师基本信息
	 * @param tutor
	 * @return
	 */
	ResultDo updateTutorInfoA(Tutor tutor);
	/**
	 * 更新导师信息
	 * @param infoList
	 * @return
	 */
	ResultDo updateTutorInfo(List<TutorInfo> infoList);
	
	/**
	 * 更新导师权限
	 * @param powerList
	 * @return
	 */
	ResultDo updateTutorPowerInfo(List<TutorPower> powerList);
	
	/**
	 * 查询所有课题
	 * @return
	 */
	ResultDo selectAllProject();
	
	/**
	 * 查询所有带权限的老师
	 * @return
	 */
//	ResultDo selectTutorWithPower();

}
