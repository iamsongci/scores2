package cn.edu.zzti.soft.scores.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.zzti.soft.scores.dao.NotifyDao;
import cn.edu.zzti.soft.scores.entity.Notify;
import cn.edu.zzti.soft.scores.service.NotifyService;
import cn.edu.zzti.soft.scores.supervisor.DaoFit;
import cn.edu.zzti.soft.scores.supervisor.ResultDo;

@Service("notifyServiceImpl")
public class NotifyServiceImpl implements NotifyService {

	ResultDo resultDo;
	@Resource
	private DaoFit daoFit;

	public ResultDo insertNotify(Notify notify) {
		resultDo = new ResultDo();
		Integer i = null;
		i = daoFit.getNotifyDao().insertNotify(notify);
		if(i != null && i == 1) {
			resultDo.setResult(i);
			resultDo.setSuccess(true);
		} 
		else {
			resultDo.setMessage("插入失败!");
		}
			
		return resultDo;
	}


	public ResultDo updateNotify(String notifyID, String content) {
		resultDo = new ResultDo();
		Integer i = null;
		i = daoFit.getNotifyDao().updateNotify(notifyID, content);
		if(i != null && i == 1) {
			resultDo.setResult(i);
			resultDo.setSuccess(true);
		} 
		else {
			resultDo.setMessage("更新失败!");
		}
		return resultDo;
	}


	public ResultDo deleteNotify(String notifyID) {
		resultDo = new ResultDo();
		Integer i = null; 
		i = daoFit.getNotifyDao().deleteNotify(notifyID);
		if(i != null && i == 1) {
			resultDo.setSuccess(true);
			resultDo.setResult(i);
		} 
		else {
			resultDo.setMessage("删除失败!");
		}
		
		
		return resultDo;
	}


	public ResultDo selectNotifyByID(String notifyID) {
		resultDo = new ResultDo();
		Notify notify = null;
		notify = daoFit.getNotifyDao().selectNotifyByID(notifyID);
		
		if(notify != null) {
			resultDo.setSuccess(true);
			resultDo.setResult(notify);
		} 
		else {
			resultDo.setMessage("查询失败!");
		}
		return resultDo;
	}


	public ResultDo selectNotifyByOwner(String owner) {
		resultDo = new ResultDo();
		List<Notify> notifyList = daoFit.getNotifyDao().selectNotifyByOwner(owner);
		if(notifyList != null) {
			resultDo.setResult(notifyList);
			resultDo.setSuccess(true);
		}
		else {
			resultDo.setMessage("查询失败!");
		}
		return resultDo;
	}


	@Override
	public ResultDo selectAllNotify() {
		resultDo = new ResultDo();
		List<Notify> notifyList = daoFit.getNotifyDao().selectAllNotify();
		if(notifyList != null) {
			resultDo.setResult(notifyList);
			resultDo.setSuccess(true);
		}
		else {
			resultDo.setMessage("查询失败!");
		}
		return resultDo;
	}


	@Override
	public ResultDo selectNotify(String stuID) {
		resultDo = new ResultDo();
		List<Notify> notifyList = daoFit.getNotifyDao().selectNotify(stuID);
		if(notifyList != null) {
			resultDo.setResult(notifyList);
			resultDo.setSuccess(true);
		}
		else {
			resultDo.setMessage("查询失败!");
		}
		return resultDo;
	}

}
