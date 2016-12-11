package cn.edu.zzti.soft.scores.dao;


import java.util.List;
import org.springframework.stereotype.Repository;

import cn.edu.zzti.soft.scores.entity.MachineRoom;
import cn.edu.zzti.soft.scores.entity.tools.MachineChoice;
import cn.edu.zzti.soft.scores.entity.tools.MachineRoomInfo;

@Repository
public interface MachineRoomAdminDao {

	List<MachineRoomInfo> selectMachRoomInfo();
	
	Integer updateMachRoomSeatNum(List<MachineRoom> infoList);
	
	Integer updateMachRoomAdmPhoAndEma(String tutorId, String tutorPho, String tutorEma);
	
	Integer insertMachChoice(List<MachineChoice> choiceList);
	
	MachineRoom selectMachRoomByID(String id);
}
