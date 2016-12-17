package cn.edu.zzti.soft.scores.entity.tools;

public class TutorHasPower {
	private String tutorID;
	private String tutorName;
	private Boolean power1;
	private Boolean power2;
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
	public Boolean getPower1() {
		return power1;
	}
	public void setPower1(Boolean power1) {
		this.power1 = power1;
	}
	public Boolean getPower2() {
		return power2;
	}
	public void setPower2(Boolean power2) {
		this.power2 = power2;
	}
	@Override
	public String toString() {
		return "TutorHasPower [tutorID=" + tutorID + ", tutorName=" + tutorName + ", power1=" + power1 + ", power2="
				+ power2 + "]";
	}
	
	
}
