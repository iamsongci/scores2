package cn.edu.zzti.soft.scores.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.zzti.soft.scores.entity.Notify;

@Repository
public interface NotifyDao {
	
	Integer insertNotify(Notify notify);
	
	Integer updateNotify(String notifyID, String content);
	
	Integer deleteNotify(String notifyID);
	
	Notify selectNotifyByID(String notifyID);
	
	List<Notify> selectNotifyByOwner(String owner);
	
	List<Notify> selectAllNotify();
	
	List<Notify> selectNotify(String stuID);
	
}
