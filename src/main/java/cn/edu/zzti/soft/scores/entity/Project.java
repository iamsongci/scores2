package cn.edu.zzti.soft.scores.entity;

public class Project {
	
	private String projectID;
	private String projectName;
	private String power1;
	private String power2;
	private String power1TutorID;
	private String power2TutorID;
	
	
	public String getPower1TutorID() {
		return power1TutorID;
	}
	public void setPower1TutorID(String power1TutorID) {
		this.power1TutorID = power1TutorID;
	}
	public String getPower2TutorID() {
		return power2TutorID;
	}
	public void setPower2TutorID(String power2TutorID) {
		this.power2TutorID = power2TutorID;
	}
	public String getPower1() {
		return power1;
	}
	public void setPower1(String power1) {
		this.power1 = power1;
	}
	public String getPower2() {
		return power2;
	}
	public void setPower2(String power2) {
		this.power2 = power2;
	}
	
	public String getProjectID() {
		return projectID;
	}
	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	@Override
	public String toString() {
		return "Project [projectID=" + projectID + ", projectName=" + projectName + ", power1=" + power1 + ", power2="
				+ power2 + "]";
	}

	
	
}
