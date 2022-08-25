package photo.model;

public class PhotoContent {
	private Integer contentNum;
	private String content;
	private String contentImg;
	private Integer photoNum;

	public PhotoContent(Integer contentNum, String content, String contentImg, Integer photoNum) {
		super();
		this.contentNum = contentNum;
		this.content = content;
		this.contentImg = contentImg;
		this.photoNum = photoNum;
	}

	public Integer getContentNum() {
		return contentNum;
	}

	public String getContent() {
		return content;
	}

	public String getContentImg() {
		return contentImg;
	}

	public Integer getPhotoNum() {
		return photoNum;
	}
}