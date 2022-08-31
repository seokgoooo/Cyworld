package owner.model;

import java.util.Date;

public class Owner {
	private Integer comment_num;
	private String comment;
	private String comment_regdate;
	private String comment_moddate;
	private Integer content_num;
	private String name;
	
	
	public Owner() {
	}

	public Owner(Integer comment_num, String comment, String comment_regdate, String comment_moddate, Integer content_num, String name) {
		this.comment_num = comment_num;
		this.comment = comment;
		this.comment_regdate = comment_regdate;
		this.comment_moddate = comment_moddate;
		this.content_num = content_num;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getComment_num() {
		return comment_num;
	}

	public void setComment_num(Integer comment_num) {
		this.comment_num = comment_num;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getComment_regdate() {
		return comment_regdate;
	}

	public void setComment_regdate(String comment_regdate) {
		this.comment_regdate = comment_regdate;
	}

	public String getComment_moddate() {
		return comment_moddate;
	}

	public void setComment_moddate(String comment_moddate) {
		this.comment_moddate = comment_moddate;
	}

	public Integer getContent_num() {
		return content_num;
	}

	public void setContent_num(Integer content_num) {
		this.content_num = content_num;
	}

	@Override
	public String toString() {
		return "Owner [comment_num=" + comment_num + ", comment=" + comment + ", comment_regdate=" + comment_regdate
				+ ", comment_moddate=" + comment_moddate + ", content_num=" + content_num + "]";
	}
	
	
	
}
