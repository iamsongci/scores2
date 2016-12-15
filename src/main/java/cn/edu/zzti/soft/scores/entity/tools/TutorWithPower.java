package cn.edu.zzti.soft.scores.entity.tools;

import java.util.Arrays;

public class TutorWithPower {

	private String tutorID;
	private String tutorName;
	private String power1;
	private String power2;

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

	@Override
	public String toString() {
		return "TutorWithPower [tutorID=" + tutorID + ", tutorName=" + tutorName + ", power1=" + power1 + ", power2="
				+ power2 + "]";
	}

}
