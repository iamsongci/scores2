package cn.edu.zzti.soft.scores.entity;

public class TutorMachineRoom {
	
	private String tutorID;
	private String machineRoomID;
	private MachineRoom machineRoom;
	private String machineUsedID;
	
	public String getTutorID() {
		return tutorID;
	}
	public void setTutorID(String tutorID) {
		this.tutorID = tutorID;
	}
	public String getMachineRoomID() {
		return machineRoomID;
	}
	public void setMachineRoomID(String machineRoomID) {
		this.machineRoomID = machineRoomID;
	}
	public MachineRoom getMachineRoom() {
		return machineRoom;
	}
	public void setMachineRoom(MachineRoom machineRoom) {
		this.machineRoom = machineRoom;
	}
	public String getMachineUsedID() {
		return machineUsedID;
	}
	public void setMachineUsedID(String machineUsedID) {
		this.machineUsedID = machineUsedID;
	}
	
}
