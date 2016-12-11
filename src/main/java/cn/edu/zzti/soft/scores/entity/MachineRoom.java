package cn.edu.zzti.soft.scores.entity;

public class MachineRoom {
	
	private String machineRoomID;
	private Integer machineNumbers;
	
	public MachineRoom() {
	}
	
	public MachineRoom(String machineRoomID, Integer machineNumbers) {
		this.machineRoomID = machineRoomID;
		this.machineNumbers = machineNumbers;
	}

	public Integer getMachineNumbers() {
		return machineNumbers;
	}
	public void setMachineNumbers(Integer machineNumbers) {
		this.machineNumbers = machineNumbers;
	}
	public String getMachineRoomID() {
		return machineRoomID;
	}
	public void setMachineRoomID(String machineRoomID) {
		this.machineRoomID = machineRoomID;
	}
	@Override
	public String toString() {
		return "MachineRoom [machineRoomID=" + machineRoomID
				+ ", machineNumbers=" + machineNumbers + "]";
	}
	
	
	
}
