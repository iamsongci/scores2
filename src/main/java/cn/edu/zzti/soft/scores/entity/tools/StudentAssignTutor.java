package cn.edu.zzti.soft.scores.entity.tools;

public class StudentAssignTutor {

	private String studentID;
	private String projectID;
	private String tutorID;
	
	public StudentAssignTutor() {
	}

	public StudentAssignTutor(String studentID, String projectID, String tutorID) {
		super();
		this.studentID = studentID;
		this.projectID = projectID;
		this.tutorID = tutorID;
	}

	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getProjectID() {
		return projectID;
	}
	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}
	public String getTutorID() {
		return tutorID;
	}
	public void setTutorID(String tutorID) {
		this.tutorID = tutorID;
	}

	@Override
	public String toString() {
		return "StudentAssignTutor [studentID=" + studentID + ", projectID="
				+ projectID + ", tutorID=" + tutorID + "]";
	}
	
}
