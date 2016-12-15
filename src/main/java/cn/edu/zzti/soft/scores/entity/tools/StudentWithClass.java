package cn.edu.zzti.soft.scores.entity.tools;

public class StudentWithClass {
	private String studentID;
	private String studentName;
	private String className;
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
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@Override
	public String toString() {
		return "StudentWithClass [studentID=" + studentID + ", studentName=" + studentName + ", className=" + className
				+ "]";
	}
	
	
	
	
}
