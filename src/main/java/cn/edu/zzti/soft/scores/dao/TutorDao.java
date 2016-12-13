package cn.edu.zzti.soft.scores.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.zzti.soft.scores.entity.StudentTutorProject;
import cn.edu.zzti.soft.scores.entity.Tutor;
import cn.edu.zzti.soft.scores.entity.tools.ClassAssignInfo;
import cn.edu.zzti.soft.scores.entity.tools.MachineRoomAdmInfo;
import cn.edu.zzti.soft.scores.entity.tools.StudentAssignTutor;
import cn.edu.zzti.soft.scores.entity.tools.StudentAssignInfo;
import cn.edu.zzti.soft.scores.entity.tools.StudentInfo;
import cn.edu.zzti.soft.scores.entity.tools.StudentInfoWithScores;
import cn.edu.zzti.soft.scores.entity.tools.TutorAssignInfo;

@Repository
public interface TutorDao {
    Tutor tutLogin (String tutorId);
	
	MachineRoomAdmInfo selectMachRoomInfo(String tutorId);
	
	Integer insertStuProScore(List<StudentTutorProject> scoreList);
	
	Integer updateStuProScore(List<StudentTutorProject> scoreList);
	
	List<StudentInfo> findAllStu(String tutorId);
	
	Integer updateTutorPhoAndEma(String tutorId, String tutorPho, String tutorEma);
	
	Integer updateTutorPsd(String tutorId, String tutorPsd);
	
	List<TutorAssignInfo> selectTutorAssignInfo();
	
	List<ClassAssignInfo> selectClassAssignInfo();
	
	List<StudentAssignInfo> selectStudentAssignInfo();
	
	Integer updateStuAssignTutorInfo(List<StudentAssignTutor> assignInfo);
	
	List<StudentInfoWithScores> selectStudentInfoWithScores(String tutorID);
	
}
