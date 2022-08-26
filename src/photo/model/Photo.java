package photo.model;

import java.util.Date;

public class Photo {
	
	private int photoNum;
	private String title;
	private Date regDate;
	private Date modDate;
	private String userId;
	private int readCount;
	
	public Photo() {
		
	}
	public Photo(String title, Date regDate, Date modDate, String userId, int readCount) {
		
		this.title = title;
		this.regDate = regDate;
		this.modDate = modDate;
		this.userId = userId;
		this.readCount = readCount;
	}
	public int getPhotoNum() {
		return photoNum;
	}
	public void setPhotoNum(int photoNum) {
		this.photoNum = photoNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getModDate() {
		return modDate;
	}
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	@Override
	public String toString() {
		return "Photo [photoNum=" + photoNum + ", title=" + title + ", regDate=" + regDate + ", modDate=" + modDate
				+ ", userId=" + userId + ", readCount=" + readCount + "]";
	}
	
	
	

}
