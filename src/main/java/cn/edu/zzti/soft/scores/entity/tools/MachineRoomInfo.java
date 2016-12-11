package cn.edu.zzti.soft.scores.entity.tools;

public class MachineRoomInfo {
	
	private String machineRoomID;
	private Integer machineRoomSeatNums;
	private String machineRoomAssignSeatNums;
	private String machineRoomUnAssignSeatNums;
	private String machineRoomAssignTutorName;
	public String getMachineRoomID() {
		return machineRoomID;
	}
	public void setMachineRoomID(String machineRoomID) {
		this.machineRoomID = machineRoomID;
	}
	public Integer getMachineRoomSeatNums() {
		return machineRoomSeatNums;
	}
	public void setMachineRoomSeatNums(Integer machineRoomSeatNums) {
		this.machineRoomSeatNums = machineRoomSeatNums;
	}
	public String getMachineRoomAssignSeatNums() {
		return machineRoomAssignSeatNums;
	}
	public void setMachineRoomAssignSeatNums(String machineRoomAssignSeatNums) {
		this.machineRoomAssignSeatNums = machineRoomAssignSeatNums;
	}
	public String getMachineRoomUnAssignSeatNums() {
		return machineRoomUnAssignSeatNums;
	}
	public void setMachineRoomUnAssignSeatNums(String machineRoomUnAssignSeatNums) {
		this.machineRoomUnAssignSeatNums = machineRoomUnAssignSeatNums;
	}
	public String getMachineRoomAssignTutorName() {
		return machineRoomAssignTutorName;
	}
	public void setMachineRoomAssignTutorName(String machineRoomAssignTutorName) {
		this.machineRoomAssignTutorName = machineRoomAssignTutorName;
	}
	
	@Override
	public String toString() {
		return "MachineRoomInfo [machineRoomID=" + machineRoomID
				+ ", machineRoomSeatNums=" + machineRoomSeatNums
				+ ", machineRoomAssignSeatNums=" + machineRoomAssignSeatNums
				+ ", machineRoomUnAssignSeatNums="
				+ machineRoomUnAssignSeatNums + ", machineRoomAssignTutorName="
				+ machineRoomAssignTutorName + "]";
	}
	
}
