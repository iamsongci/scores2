package cn.edu.zzti.soft.scores.service;

import java.util.List;

import cn.edu.zzti.soft.scores.entity.StudentTutorProject;
import cn.edu.zzti.soft.scores.entity.tools.StudentAssignTutor;
import cn.edu.zzti.soft.scores.entity.tools.StudentInfoWithScores;
import cn.edu.zzti.soft.scores.supervisor.ResultDo;

public interface TutorService {
	
	/**
	 * 导师登录信息验证
	 * @param tutId
	 * @return
	 */
	ResultDo TutLogin(String tutorId);
	/**
	 * 查找导师机房信息
	 * @param tutorId
	 * @return
	 */
	ResultDo selectMachRoomInfo(String tutorId);
	
	/**
	 * 插入成绩信息 
	 * @param scoreList
	 * @return
	 */
	ResultDo insertStuProScore(List<StudentTutorProject> scoreList);
	
	/**
	 * 更新学生成绩
	 * @param scoreList
	 * @return
	 */
	ResultDo updateStuProScore(List<StudentTutorProject> scoreList);
	
	/**
	 * 找导师所有学生
	 * @param tutorId
	 * @return
	 */
	ResultDo findAllStu(String tutorId);
	
	/**
	 * 更新导师联系方式, 邮箱
	 * @param tutorId
	 * @param tutorPho
	 * @param tutorEma
	 * @return
	 */
	ResultDo updateTutorPhoAndEma(String tutorId, String tutorPho, String tutorEma);
	
	/**
	 * 更新密码
	 * @param tutorId
	 * @param tutorPsd
	 * @return
	 */
	ResultDo updateTutorPsd(String tutorId, String tutorPsd);
	
	/**
	 * 查询导师分配信息
	 * @return
	 */
	ResultDo selectTutorAssignInfo();
	
	/**
	 * 查询班级分配信息
	 * @return
	 */
	ResultDo selectClassAssignInfo();
	
	/**
	 * 查询导师分配学生
	 * @return
	 */
	ResultDo selectStudentAssignInfo();
	
	/**
	 * 学生分配导师
	 * @param assignInfo
	 * @return
	 */
	ResultDo updateStuAssignTutorInfo(List<StudentAssignTutor> assignInfo);
	
	/**
	 * 查所有学生带成绩
	 * @param tutorID
	 * @return
	 */
	ResultDo selectStudentInfoWithScores(String tutorID);
	
}
