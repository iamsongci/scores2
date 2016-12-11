package cn.edu.zzti.soft.scores.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.zzti.soft.scores.entity.Student;
import cn.edu.zzti.soft.scores.entity.tools.ProjectAssignInfo;
import cn.edu.zzti.soft.scores.entity.tools.StudentInfo;
import cn.edu.zzti.soft.scores.service.StudentService;
import cn.edu.zzti.soft.scores.supervisor.DaoFit;
import cn.edu.zzti.soft.scores.supervisor.ResultDo;
import cn.edu.zzti.soft.scores.util.StringUtil;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {
	ResultDo resultDo;
	@Resource
	private DaoFit daoFit;
/**
 * 学生登陆验证
 */
	public ResultDo stuLogin(String stuId) {
		Student stu = null;
		resultDo = new ResultDo();
		if(StringUtil.isNotEmpty(stuId))
			stu=daoFit.getStudentDao().stuLogin(stuId);
		if(stu!=null){
			resultDo.setSuccess(true);
			resultDo.setResult(stu);
		}
		else {
			resultDo.setMessage("用户信息不存在！");
		}
		return resultDo;
	}

	public ResultDo updateStuPhone(String stuId, String stuPhone) {
		Integer i = null;
		resultDo = new ResultDo();
		if(StringUtil.isNotEmpty(stuPhone) && StringUtil.isNotEmpty(stuId))
			i = daoFit.getStudentDao().updateStuPhone(stuId, stuPhone);
		else{
			i = daoFit.getStudentDao().updateStuPhone(stuId, "");
		}
		if(i == 1) {
			resultDo.setSuccess(true);
			resultDo.setResult(i);
		} 
		else {
			resultDo.setMessage("更新失败!");
		}
		return resultDo;
	}

	public ResultDo updateStuPsd(String stuId, String stuPsd) {
		Integer i = null;
		resultDo = new ResultDo();
			i = daoFit.getStudentDao().updateStuPsd(stuId, stuPsd);
		if(i == 1) {
			resultDo.setSuccess(true);
			resultDo.setResult(i);
		}
		else {
			resultDo.setMessage("更新失败!");
		}
		return resultDo;
	}

	public ResultDo selectStuProjectInfo(String stuId) {
		List<ProjectAssignInfo> proInfo = null;
		resultDo = new ResultDo();
		if(StringUtil.isNotEmpty(stuId))
			proInfo = daoFit.getStudentDao().selectStuProjectInfo(stuId);
		if(proInfo != null) {
			resultDo.setSuccess(true);
			resultDo.setResult(proInfo);
		} 
		else {
			resultDo.setMessage("查询失败!");
		}
		return resultDo;
	}

	public ResultDo selectStuInfo(String stuId) {
		// TODO Auto-generated method stub
		StudentInfo stu =null;
		resultDo = new ResultDo();
		if(StringUtil.isNotEmpty(stuId))
			stu=daoFit.getStudentDao().selectStuInfo(stuId);//方法未写，为实现。
		if(stu!=null){
			resultDo.setSuccess(true);
			resultDo.setResult(stu);
		}
		else {
			resultDo.setMessage("用户信息不存在！");
		}
		return resultDo;
	}

	@Override
	public ResultDo updateStuPorject(Integer index, String stuProName) {
		Integer i = null;
		resultDo = new ResultDo();
		i = daoFit.getStudentDao().updateStuPorject(index, stuProName);
		if(i!=null){
			resultDo.setSuccess(true);
			resultDo.setResult(i);
		}
		else {
			resultDo.setMessage("更新失败!");
		}
		return resultDo;
	}
}
