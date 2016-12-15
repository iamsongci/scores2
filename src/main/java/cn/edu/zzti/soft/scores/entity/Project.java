package cn.edu.zzti.soft.scores.entity;

public class Project {
	
	private String projectID;
	private String projectName;
	private String power1;
	private String power2;
	
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
