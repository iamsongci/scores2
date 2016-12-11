package cn.edu.zzti.soft.scores.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.zzti.soft.scores.entity.Student;
import cn.edu.zzti.soft.scores.entity.tools.ProjectAssignInfo;
import cn.edu.zzti.soft.scores.entity.tools.StudentInfo;
@Repository
public interface StudentDao {

	Student stuLogin(String stuId);

	Integer updateStuPhone(String stuId, String stuPhone);
	
	Integer updateStuPsd(String stuId, String stuPsd);
	
	List<ProjectAssignInfo> selectStuProjectInfo(String stuId);
	
	StudentInfo selectStuInfo (String stuId);
	
	Integer updateStuPorject(Integer index, String stuProName);
}
