package photo.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Photo {
	private int number;// PK
	private String title;
	private Date regDate;
	private Date modDate;
	private String url;
	private String content;
	private int user_num;// FK

	public Photo() {

	}

	public Photo(int number, String title, Date regDate, Date modDate, String url, String content, int user_num) {
		super();
		this.number = number;
		this.title = title;
		this.regDate = regDate;
		this.modDate = modDate;
		this.url = url;
		this.content = content;
		this.user_num = user_num;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

	

}
