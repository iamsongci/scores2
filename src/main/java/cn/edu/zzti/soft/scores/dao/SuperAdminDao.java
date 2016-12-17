package cn.edu.zzti.soft.scores.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.zzti.soft.scores.entity.Project;
import cn.edu.zzti.soft.scores.entity.Student;
import cn.edu.zzti.soft.scores.entity.Tutor;
import cn.edu.zzti.soft.scores.entity.tools.TutorIDWithPower;
import cn.edu.zzti.soft.scores.entity.tools.TutorInfo;
import cn.edu.zzti.soft.scores.entity.tools.TutorPower;
import cn.edu.zzti.soft.scores.entity.tools.TutorWithPower;
import cn.edu.zzti.soft.scores.util.MyString;

@Repository
public interface SuperAdminDao {
    //查看导师信息
	List<TutorInfo> selectTutorInfo();
	//导师密码重置
	Integer updateTutorPwd(String TutorId);
	//导师基本信息的修改
	Integer updateTutorInfoA(Tutor tutor);
	
	Integer updateTutorInfo(List<TutorInfo> infoList);
	
	Integer updateTutorPowerInfo(List<TutorPower> powerList);
	
	List<Project> selectAllProject();
	
	List<TutorWithPower> selectTutorWithPower();
	
	TutorIDWithPower selectTutorIDWithPower(String tutorID);
	
	Integer updateTutorPro(String tutorID, String power1, String pwoer2);
	
	List<Student> selectStudent();
	
	List<Tutor> selectTutor();
	
	Integer insertStudent(List<Student> stuList);
	
	Integer insertTutor(List<Tutor> tutList);
	
	Integer deleteStudent(String stuID);
	
	Integer deleteTutor(String tutorID);
	
	List<MyString> selectStudentHasPro();
	
}
