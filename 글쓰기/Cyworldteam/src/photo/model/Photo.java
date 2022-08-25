package photo.model;

import java.util.Date;

public class Photo {

	private Integer photoNum;
	private String title;
	private Date regDate;
	private Date modDate;
	private String userId;

	public Photo(Integer photoNum, String title, Date regDate, Date modDate, String userId) {
		this.photoNum = photoNum;
		this.title = title;
		this.regDate = regDate;
		this.modDate = modDate;
		this.userId = userId;
	}

	public Integer getPhotoNum() {
		return photoNum;
	}

	public void setPhotoNum(Integer photoNum) {
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

}