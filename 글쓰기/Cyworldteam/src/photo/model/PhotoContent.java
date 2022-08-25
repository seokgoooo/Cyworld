package photo.model;

import com.mysql.cj.jdbc.Blob;

public class PhotoContent {
	private Integer contentNum;
	private String content;

	public PhotoContent(Integer contentNum, String content) {
		super();
		this.contentNum = contentNum;
		this.content = content;
	}

	public Integer getContentNum() {
		return contentNum;
	}

	public void setContentNum(Integer contentNum) {
		this.contentNum = contentNum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}