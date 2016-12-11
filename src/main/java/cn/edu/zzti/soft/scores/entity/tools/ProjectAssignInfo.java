package cn.edu.zzti.soft.scores.entity.tools;

public class ProjectAssignInfo {
	private Integer index;
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	private String projectName;
	private String tutorName;
	private String tutorEmail;
	private String tutorPhone;
	private Integer studentUsualScore;
	private Integer studentProjectScore;
	private Integer studentReportScore;
	private Integer studentTotalScore;
	private String trueName;
	
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getTutorName() {
		return tutorName;
	}
	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}
	public String getTutorEmail() {
		return tutorEmail;
	}
	public void setTutorEmail(String tutorEmail) {
		this.tutorEmail = tutorEmail;
	}
	public String getTutorPhone() {
		return tutorPhone;
	}
	public void setTutorPhone(String tutorPhone) {
		this.tutorPhone = tutorPhone;
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
	@Override
	public String toString() {
		return "ProjectAssignInfo [projectName=" + projectName + ", tutorName="
				+ tutorName + ", tutorEmail=" + tutorEmail + ", tutorPhone="
				+ tutorPhone + ", studentUsualScore=" + studentUsualScore
				+ ", studentProjectScore=" + studentProjectScore
				+ ", studentReportScore=" + studentReportScore
				+ ", studentTotalScore=" + studentTotalScore + "]";
	}
	
	
}
