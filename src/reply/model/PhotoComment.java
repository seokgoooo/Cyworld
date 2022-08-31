package reply.model;

import java.util.Date;

public class PhotoComment {
	private int comment_num; // pk
	private String comment;
	private Date comment_regDate;
	private Date comment_modDate;
	private int user_num;
	private int photo_num;
	
	public PhotoComment() {
	}
	

	public PhotoComment(int comment_num, String comment, Date comment_regDate, Date comment_modDate, int user_num,
			int photo_num) {
		super();
		this.comment_num = comment_num;
		this.comment = comment;
		this.comment_regDate = comment_regDate;
		this.comment_modDate = comment_modDate;
		this.user_num = user_num;
		this.photo_num = photo_num;
	}


	public int getComment_num() {
		return comment_num;
	}

	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getComment_regDate() {
		return comment_regDate;
	}

	public void setComment_regDate(Date comment_regDate) {
		this.comment_regDate = comment_regDate;
	}

	public Date getComment_modDate() {
		return comment_modDate;
	}

	public void setComment_modDate(Date comment_modDate) {
		this.comment_modDate = comment_modDate;
	}

	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

	public int getPhoto_num() {
		return photo_num;
	}

	public void setPhoto_num(int photo_num) {
		this.photo_num = photo_num;
	}
	
}
