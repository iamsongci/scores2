package cn.edu.zzti.soft.scores.entity.tools;

public class StudentAssignInfo {

	private String studentID;
	private String studentName;
	private Boolean studentSex;
	private String studentPhone;
	private String studentTutorName;
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
	public String getStudentTutorName() {
		return studentTutorName;
	}
	public void setStudentTutorName(String studentTutorName) {
		this.studentTutorName = studentTutorName;
	}
	@Override
	public String toString() {
		return "StudentAssignInfo [studentID=" + studentID + ", studentName="
				+ studentName + ", studentSex=" + studentSex
				+ ", studentPhone=" + studentPhone + ", studentTutorName="
				+ studentTutorName + "]";
	}
	
	
}
