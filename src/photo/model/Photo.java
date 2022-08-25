package photo.model;

import java.util.Date;

public class Photo {
	private Integer photoNum;
	private Uploader uploader;
	private String title;
	private Date regDate;
	private Date modDate;
	private String userId;
	private int readCount;

	public Photo(Integer photoNum, Uploader uploader, String title, Date regDate, Date modDate, int readCount) {
		this.photoNum = photoNum;
		this.uploader = uploader;
		this.title = title;
		this.regDate = regDate;
		this.modDate = modDate;
		this.readCount = readCount;
	}

	public Integer getPhotoNum() {
		return photoNum;
	}

	public Uploader getUploader() {
		return uploader;
	}

	public String getTitle() {
		return title;
	}

	public Date getRegDate() {
		return regDate;
	}

	public Date getModDate() {
		return modDate;
	}

	public String getUserId() {
		return userId;
	}

	public int getReadCount() {
		return readCount;
	}
}