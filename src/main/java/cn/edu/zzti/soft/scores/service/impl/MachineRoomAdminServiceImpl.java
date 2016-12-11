package cn.edu.zzti.soft.scores.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.zzti.soft.scores.entity.MachineRoom;
import cn.edu.zzti.soft.scores.entity.tools.MachineChoice;
import cn.edu.zzti.soft.scores.entity.tools.MachineRoomInfo;
import cn.edu.zzti.soft.scores.service.MachineRoomAdminService;
import cn.edu.zzti.soft.scores.supervisor.DaoFit;
import cn.edu.zzti.soft.scores.supervisor.ResultDo;
import cn.edu.zzti.soft.scores.util.StringUtil;

@Service("machineRoomAdminServiceImpl")
public class MachineRoomAdminServiceImpl implements MachineRoomAdminService {
	ResultDo resultDo;
	@Resource
	private DaoFit daoFit;
	
	public ResultDo selectMachRoomInfo() {
		resultDo = new ResultDo();
		List<MachineRoomInfo> roomList = daoFit.getMachineRoomAdminDao().selectMachRoomInfo();
		if (roomList != null && roomList.size() != 0) {
			
			for (MachineRoomInfo info : roomList) {
				String[] pacInfo = null;
				if(info.getMachineRoomAssignSeatNums() != null) {
					pacInfo = info.getMachineRoomAssignSeatNums().split("-|, ");
					List<Integer> assList = new ArrayList<Integer>();
					assList.add(0);
					for (String num : pacInfo) {
						assList.add(Integer.parseInt(num));
					}
					assList.add(info.getMachineRoomSeatNums() + 1);
					Collections.sort(assList); //排序
					
					StringBuffer strb = new StringBuffer();
					for (int i = 0; i < assList.size(); i += 2) {
						if(assList.get(i + 1) - assList.get(i) != 1) {
							strb.append("" + (assList.get(i) + 1) + "-" + (assList.get(i + 1) - 1) + ",");
						}
					}
					info.setMachineRoomUnAssignSeatNums(strb.toString());
				}
			}
			
			resultDo.setSuccess(true);
			resultDo.setResult(roomList);
		}
		else {
			resultDo.setMessage("查询失败或列表为空!");
		}
		return resultDo;
	}
	public ResultDo updateMachRoomSeatNum(List<MachineRoom> infoList) {
		resultDo = new ResultDo();
		Integer i = null;
		if(infoList != null && infoList.size()!=0) {
			i = daoFit.getMachineRoomAdminDao().updateMachRoomSeatNum(infoList);
		}
		if(i != null && i == 1) {
			resultDo.setSuccess(true);
			resultDo.setResult(i);
		}
		else {
			resultDo.setMessage("更新失败!");
		}
		return resultDo;
	}
	public ResultDo updateMachRoomAdmPhoAndEma(String tutorId, String tutorPho,
			String tutorEma) {
		resultDo = new ResultDo();
		Integer i = null;
		if(StringUtil.isNotEmpty(tutorEma) && StringUtil.isNotEmpty(tutorPho) && StringUtil.isNotEmpty(tutorId)) {
			i = daoFit.getMachineRoomAdminDao().updateMachRoomAdmPhoAndEma(tutorId, tutorPho, tutorEma);
		}
		if(i != null && i == 1) {
			resultDo.setSuccess(true);
			resultDo.setResult(i);
		}
		else {
			resultDo.setMessage("更新失败!");
		}
		return resultDo;
	}
	public ResultDo insertMachChoice(List<MachineChoice> choiceList) {
		resultDo = new ResultDo();
		Integer i = null;
		if(choiceList != null && choiceList.size() != 0) {
			i = daoFit.getMachineRoomAdminDao().insertMachChoice(choiceList);
		}
		if(i != null && i == 1) {
			resultDo.setSuccess(true);
			resultDo.setResult(i);
		}
		else {
			resultDo.setMessage("更新失败!");
		}
		return resultDo;
	}
	
	public ResultDo selectMachRoomByID(String id) {
		resultDo = new ResultDo();
		MachineRoom machineRoom = null;
		if(StringUtil.isNotEmpty(id)) {
			machineRoom = daoFit.getMachineRoomAdminDao().selectMachRoomByID(id);
		}
		if(machineRoom != null) {
			resultDo.setSuccess(true);
			resultDo.setResult(machineRoom);
		}
		else {
			resultDo.setMessage("查询失败!");
		}
		return resultDo;
	}

	
}
