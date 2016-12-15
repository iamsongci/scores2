package cn.edu.zzti.soft.scores.entity.tools;

public class StudentInfoWithScores {
	private Integer	index;
	private String  studentID;
	private String 	studentName;
	private String 	projectName;
	private String	trueName;
	private Integer	usualScore;
	private Integer	projectScore;
	private Integer	reportScore;
	private Integer	totalScore;
	private String 	reportAddress;
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
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
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public Integer getUsualScore() {
		return usualScore;
	}
	public void setUsualScore(Integer usualScore) {
		this.usualScore = usualScore;
	}
	public Integer getProjectScore() {
		return projectScore;
	}
	public void setProjectScore(Integer projectScore) {
		this.projectScore = projectScore;
	}
	public Integer getReportScore() {
		return reportScore;
	}
	public void setReportScore(Integer reportScore) {
		this.reportScore = reportScore;
	}
	public Integer getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}
	public String getReportAddress() {
		return reportAddress;
	}
	public void setReportAddress(String reportAddress) {
		this.reportAddress = reportAddress;
	}
	@Override
	public String toString() {
		return "StudentInfoWithScores [index=" + index + ", studentID=" + studentID + ", studentName=" + studentName
				+ ", projectName=" + projectName + ", trueName=" + trueName + ", usualScore=" + usualScore
				+ ", projectScore=" + projectScore + ", reportScore=" + reportScore + ", totalScore=" + totalScore
				+ ", reportAddress=" + reportAddress + "]";
	}
	
	
}
