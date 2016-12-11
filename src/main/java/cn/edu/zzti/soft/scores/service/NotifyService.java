package cn.edu.zzti.soft.scores.service;

import java.util.List;

import cn.edu.zzti.soft.scores.dao.NotifyDao;
import cn.edu.zzti.soft.scores.entity.Notify;
import cn.edu.zzti.soft.scores.supervisor.ResultDo;

public interface NotifyService{

	/**
	 * 插入通知
	 * @param notify
	 * @return
	 */
	ResultDo insertNotify(Notify notify);
	
	/**
	 * 更新通知
	 * @param notifyID
	 * @param notify
	 * @return
	 */
	ResultDo updateNotify(String notifyID, String content);
	
	/**
	 * 删除通知
	 * @param notifyID
	 * @return
	 */
	ResultDo deleteNotify(String notifyID);
	
	/**
	 * 通过ID查询通知
	 * @param notifyID
	 * @return
	 */
	ResultDo selectNotifyByID(String notifyID);
	
	/**
	 * 通过条件查询通知
	 * @param owner 发布者
	 * @return
	 */
	ResultDo selectNotifyByOwner(String owner);
	
	/**
	 * 查询所有
	 * @return
	 */
	ResultDo selectAllNotify();
	
	/**
	 * 学生查询
	 * @param stuID 学生ID
	 * @return
	 */
	ResultDo selectNotify(String stuID);
	

}
