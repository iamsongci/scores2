package cn.edu.zzti.soft.scores.service;

import java.util.List;

import cn.edu.zzti.soft.scores.entity.MachineRoom;
import cn.edu.zzti.soft.scores.entity.tools.MachineChoice;
import cn.edu.zzti.soft.scores.entity.tools.MachineRoomInfo;
import cn.edu.zzti.soft.scores.supervisor.ResultDo;

public interface MachineRoomAdminService {
	
	/**
	 * 查询所有机房信息
	 * @return
	 */
	ResultDo selectMachRoomInfo();
	
	/**
	 * 更新机房机位数
	 * @param infoMap
	 * @return
	 */
	ResultDo updateMachRoomSeatNum(List<MachineRoom> infoList);
	
	/**
	 * 更新手机号, 邮箱
	 * @param tutorId
	 * @param tutorPho
	 * @param tutorEma
	 * @return
	 */
	ResultDo updateMachRoomAdmPhoAndEma(String tutorId, String tutorPho, String tutorEma);
	
	/**
	 * 插入选择机位信息
	 * @param choiceList
	 * @return
	 */
	ResultDo insertMachChoice(List<MachineChoice> choiceList);
	
	/**
	 * 查询机房信息
	 * @param id
	 * @return
	 */
	ResultDo selectMachRoomByID(String id);
	
}
