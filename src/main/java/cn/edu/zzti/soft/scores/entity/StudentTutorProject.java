package cn.edu.zzti.soft.scores.entity;

public class StudentTutorProject {

	private String  studentID;
	private String  studentTutorID;
	private String  studentProjectID;
	private Integer studentUsualScore;
	private Integer studentProjectScore;
	private Integer studentReportScore;
	private Integer studentTotalScore;
	private String  trueName;
	
	public StudentTutorProject() {
	}
	
	public StudentTutorProject(String studentID, String studentTutorID,
			String studentProjectID, Integer studentUsualScore,
			Integer studentProjectScore, Integer studentReportScore,
			Integer studentTotalScore) {
		this.studentID = studentID;
		this.studentTutorID = studentTutorID;
		this.studentProjectID = studentProjectID;
		this.studentUsualScore = studentUsualScore;
		this.studentProjectScore = studentProjectScore;
		this.studentReportScore = studentReportScore;
		this.studentTotalScore = studentTotalScore;
	}
	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getStudentTutorID() {
		return studentTutorID;
	}
	public void setStudentTutorID(String studentTutorID) {
		this.studentTutorID = studentTutorID;
	}

	public String getStudentProjectID() {
		return studentProjectID;
	}
	public void setStudentProjectID(String studentProjectID) {
		this.studentProjectID = studentProjectID;
	}
	public Integer getStudentUsualScore() {
		return studentUsualScore;
	}
	public void setStudentUsualScore(Integer studentUsualScore) {
		this.studentUsualScore = studentUsualScore;
	}
	public Integer getStudentProjectScore() {
		return studentProjectScore;
	}
	public void setStudentProjectScore(Integer studentProjectScore) {
		this.studentProjectScore = studentProjectScore;
	}
	public Integer getStudentReportScore() {
		return studentReportScore;
	}
	public void setStudentReportScore(Integer studentReportScore) {
		this.studentReportScore = studentReportScore;
	}
	public Integer getStudentTotalScore() {
		return studentTotalScore;
	}
	public void setStudentTotalScore(Integer studentTotalScore) {
		this.studentTotalScore = studentTotalScore;
	}
	
}
