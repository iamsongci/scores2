package cn.edu.zzti.soft.scores.entity.tools;

public class StudentInfo {
	private String studentID;
	private String studentName;
	private Boolean studentSex;
	private String studentPhone;
	private String studentClass;
	private String studentReportAdress;
	
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
	public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	public String getStudentReportAdress() {
		return studentReportAdress;
	}
	public void setStudentReportAdress(String studentReportAdress) {
		this.studentReportAdress = studentReportAdress;
	}
	@Override
	public String toString() {
		return "StudentInfo [studentID=" + studentID + ", studentName="
				+ studentName + ", studentSex=" + studentSex
				+ ", studentPhone=" + studentPhone + ", studentClass="
				+ studentClass + ", studentReportAdress=" + studentReportAdress
				+ "]";
	}
	
}
