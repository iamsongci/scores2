package cn.edu.zzti.soft.scores.entity;

public class Notify {
	private String notifyID;
	private String title;
	private String content;
	private String owner;
	private String time;
	private Boolean toStudent;
	
	
	public Notify() {
	}

	public Notify(String notifyID, String title, String content, String owner,
			String time, Boolean toStudent) {
		super();
		this.notifyID = notifyID;
		this.title = title;
		this.content = content;
		this.owner = owner;
		this.time = time;
		this.toStudent = toStudent;
	}
	
	public String getNotifyID() {
		return notifyID;
	}
	public void setNotifyID(String notifyID) {
		this.notifyID = notifyID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Boolean getToStudent() {
		return toStudent;
	}
	public void setToStudent(Boolean toStudent) {
		this.toStudent = toStudent;
	}

	@Override
	public String toString() {
		return "Notify [notifyID=" + notifyID + ", title=" + title
				+ ", content=" + content + ", owner=" + owner + ", time="
				+ time + ", toStudent=" + toStudent + "]";
	}
	
	
	
}
