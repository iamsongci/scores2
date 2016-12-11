package cn.edu.zzti.soft.scores.entity.tools;

public class TutorAssignInfo {

	private String tutorID;
	private String tutorName;
	private Boolean tutorSex;
	private Integer number;
	public String getTutorID() {
		return tutorID;
	}
	public void setTutorID(String tutorID) {
		this.tutorID = tutorID;
	}
	public String getTutorName() {
		return tutorName;
	}
	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}
	public Boolean getTutorSex() {
		return tutorSex;
	}
	public void setTutorSex(Boolean tutorSex) {
		this.tutorSex = tutorSex;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "TutorAssignInfo [tutorID=" + tutorID + ", tutorName="
				+ tutorName + ", tutorSex=" + tutorSex + ", number=" + number
				+ "]";
	}
	
}
