package cn.edu.zzti.soft.scores.entity.tools;

public class ClassAssignInfo {

	private String classID;
	private String className;
	private Integer totalNums;
	private Integer assignNums;
	public String getClassID() {
		return classID;
	}
	public void setClassID(String classID) {
		this.classID = classID;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Integer getTotalNums() {
		return totalNums;
	}
	public void setTotalNums(Integer totalNums) {
		this.totalNums = totalNums;
	}
	public Integer getAssignNums() {
		return assignNums;
	}
	public void setAssignNums(Integer assignNums) {
		this.assignNums = assignNums;
	}
	@Override
	public String toString() {
		return "ClassAssignInfo [classID=" + classID + ", className="
				+ className + ", totalNums=" + totalNums + ", assignNums="
				+ assignNums + "]";
	}
	
	
}
