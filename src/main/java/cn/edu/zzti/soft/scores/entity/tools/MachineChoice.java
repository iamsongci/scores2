package cn.edu.zzti.soft.scores.entity.tools;

public class MachineChoice {

	private String tutorID;
	private String machineRoomID;
	private String machineUsedID;
	
	public MachineChoice() {
	}
	
	public MachineChoice(String tutorID, String machineRoomID,
			String machineUsedID) {
		this.tutorID = tutorID;
		this.machineRoomID = machineRoomID;
		this.machineUsedID = machineUsedID;
	}
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
	public String getMachineUsedID() {
		return machineUsedID;
	}
	public void setMachineUsedID(String machineUsedID) {
		this.machineUsedID = machineUsedID;
	}

	@Override
	public String toString() {
		return "MachineChoice [tutorID=" + tutorID + ", machineRoomID="
				+ machineRoomID + ", machineUsedID=" + machineUsedID + "]";
	}
	
}
