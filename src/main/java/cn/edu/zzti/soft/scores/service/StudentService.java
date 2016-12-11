package cn.edu.zzti.soft.scores.service;

import cn.edu.zzti.soft.scores.entity.tools.ProjectAssignInfo;
import cn.edu.zzti.soft.scores.supervisor.ResultDo;

public interface StudentService {
	
	/**
	 * 用于学生登陆信息的验证
	 * @param stuId
	 * @return
	 */
	ResultDo stuLogin(String stuId);
	
	/**
	 * 更新学生手机信息
	 * @param stuId
	 * @return
	 */
	ResultDo updateStuPhone(String stuId, String stuPhone);
	
	/**
	 * 更新学生密码信息
	 * @param stuId
	 * @param stuPsd
	 * @return
	 */
	ResultDo updateStuPsd(String stuId, String stuPsd);
	
	/**
	 * 查看学生成绩信息
	 * @param stuId
	 * @param proId
	 * @return
	 */
	ResultDo selectStuProjectInfo(String stuId);
	
	/**
	 * 查询学生个人信息
	 * @param stuId
	 * @return
	 */
	ResultDo selectStuInfo(String stuId);
	
	/**
	 * 修改课题名
	 * @param index
	 * @param stuProName
	 * @return
	 */
	ResultDo updateStuPorject(Integer index, String stuProName);
}
