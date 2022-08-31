package owner.model;

import java.util.Date;

public class Owner {
	private Integer comment_num;
	private String comment;
	private Date comment_regdate;
	private Date comment_moddate;
	private Integer content_num;
	
	
	public Owner() {
	}

	public Owner(Integer comment_num, String comment, Date comment_regdate, Date comment_moddate, Integer content_num) {
		this.comment_num = comment_num;
		this.comment = comment;
		this.comment_regdate = comment_regdate;
		this.comment_moddate = comment_moddate;
		this.content_num = content_num;
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

	public Date getComment_regdate() {
		return comment_regdate;
	}

	public void setComment_regdate(Date comment_regdate) {
		this.comment_regdate = comment_regdate;
	}

	public Date getComment_moddate() {
		return comment_moddate;
	}

	public void setComment_moddate(Date comment_moddate) {
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
