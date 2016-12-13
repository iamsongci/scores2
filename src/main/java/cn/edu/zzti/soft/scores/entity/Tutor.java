package cn.edu.zzti.soft.scores.entity;

public class Tutor {
	private String tutorID;
	private String tutorName;
	private Boolean tutorSex;
	private String tutorPhone;
	private String tutorEmail;
	private String tutorPower1;//导师分配权限
	private String tutorPower2;//导师成绩统计
	private String tutorPassword;
	
	public String getTutorID() {
		return tutorID;
	}
	public void setTutorID(String tutorID) {
		this.tutorID = tutorID;
	}
	public String getTutorName() {
		return tutorName;
	}
	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}
	public Boolean getTutorSex() {
		return tutorSex;
	}
	public void setTutorSex(Boolean tutorSex) {
		this.tutorSex = tutorSex;
	}
	
	public String getTutorPhone() {
		return tutorPhone;
	}
	public void setTutorPhone(String tutorPhone) {
		this.tutorPhone = tutorPhone;
	}
	public String getTutorEmail() {
		return tutorEmail;
	}
	public void setTutorEmail(String tutorEmail) {
		this.tutorEmail = tutorEmail;
	}
	public String getTutorPower1() {
		return tutorPower1;
	}
	public void setTutorPower1(String tutorPower1) {
		this.tutorPower1 = tutorPower1;
	}
	public String getTutorPower2() {
		return tutorPower2;
	}
	public void setTutorPower2(String tutorPower2) {
		this.tutorPower2 = tutorPower2;
	}
	public String getTutorPassword() {
		return tutorPassword;
	}
	public void setTutorPassword(String tutorPassword) {
		this.tutorPassword = tutorPassword;
	}
	@Override
	public String toString() {
		return "Tutor [tutorID=" + tutorID + ", tutorName=" + tutorName + ", tutorSex=" + tutorSex + ", tutorPhone="
				+ tutorPhone + ", tutorEmail=" + tutorEmail + ", tutorPower1=" + tutorPower1 + ", tutorPower2="
				+ tutorPower2 + ", tutorPassword=" + tutorPassword + "]";
	}
	
	
	
}
