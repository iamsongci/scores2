package cn.edu.zzti.soft.scores.entity;

public class Student {

	private String studentID;
	private String studentName;
	private Boolean studentSex;
	private String studentPhone;
	private String studentPassword;
	private String studentClassID;
	private Boolean hasPro;

	public Boolean getHasPro() {
		return hasPro;
	}
	public void setHasPro(Boolean hasPro) {
		this.hasPro = hasPro;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Boolean getStudentSex() {
		return studentSex;
	}
	public void setStudentSex(Boolean studentSex) {
		this.studentSex = studentSex;
	}
	public String getStudentPhone() {
		return studentPhone;
	}
	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}
	public String getStudentPassword() {
		return studentPassword;
	}
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	public String getStudentClassID() {
		return studentClassID;
	}
	public void setStudentClassID(String studentClassID) {
		this.studentClassID = studentClassID;
	}
	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", studentName=" + studentName + ", studentSex=" + studentSex
				+ ", studentPhone=" + studentPhone + ", studentPassword=" + studentPassword + ", studentClassID="
				+ studentClassID + ", hasPro=" + hasPro + "]";
	}


	
}
