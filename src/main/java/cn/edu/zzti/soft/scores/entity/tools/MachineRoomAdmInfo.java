package cn.edu.zzti.soft.scores.entity.tools;


public class MachineRoomAdmInfo {
	
	private String machRoomAdmName;
	private String machRoomAdmPhone;
	private String machRoomAdmEmail;
	private String machRoomList;
	private String machRoomSeatInfo;
	
	public String getMachRoomAdmName() {
		return machRoomAdmName;
	}
	public void setMachRoomAdmName(String machRoomAdmName) {
		this.machRoomAdmName = machRoomAdmName;
	}
	public String getMachRoomAdmPhone() {
		return machRoomAdmPhone;
	}
	public void setMachRoomAdmPhone(String machRoomAdmPhone) {
		this.machRoomAdmPhone = machRoomAdmPhone;
	}
	public String getMachRoomAdmEmail() {
		return machRoomAdmEmail;
	}
	public void setMachRoomAdmEmail(String machRoomAdmEmail) {
		this.machRoomAdmEmail = machRoomAdmEmail;
	}
	public String getMachRoomSeatInfo() {
		return machRoomSeatInfo;
	}
	public void setMachRoomSeatInfo(String machRoomSeatInfo) {
		this.machRoomSeatInfo = machRoomSeatInfo;
	}
	public String getMachRoomList() {
		return machRoomList;
	}
	public void setMachRoomList(String machRoomList) {
		this.machRoomList = machRoomList;
	}
	
	@Override
	public String toString() {
		return "MachineRoomAdmInfo [machRoomAdmName=" + machRoomAdmName
				+ ", machRoomAdmPhone=" + machRoomAdmPhone
				+ ", machRoomAdmEmail=" + machRoomAdmEmail + ", machRoomList="
				+ machRoomList + ", machRoomSeatInfo=" + machRoomSeatInfo + "]";
	}
	
	
}
