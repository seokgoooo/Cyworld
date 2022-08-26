package photo.model;

<<<<<<< HEAD
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
=======
import com.mysql.cj.jdbc.Blob;

public class PhotoContent {
	private int contentNum;
	private String content;
	private Blob contentImg;
	private int photoNum;
	
	public PhotoContent () {
		
	}
	public PhotoContent(String content, Blob contentImg, int photoNum) {
		
		this.content = content;
		this.contentImg = contentImg;
		this.photoNum = photoNum;
	}
	public int getContentNum() {
		return contentNum;
	}
	public void setContentNum(int contentNum) {
		this.contentNum = contentNum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Blob getContentImg() {
		return contentImg;
	}
	public void setContentImg(Blob contentImg) {
		this.contentImg = contentImg;
	}
	public int getPhotoNum() {
		return photoNum;
	}
	public void setPhotoNum(int photoNum) {
		this.photoNum = photoNum;
	}
	@Override
	public String toString() {
		return "PhotoContent [contentNum=" + contentNum + ", content=" + content + ", contentImg=" + contentImg
				+ ", photoNum=" + photoNum + "]";
	}

}
>>>>>>> refs/remotes/origin/JinSeong
