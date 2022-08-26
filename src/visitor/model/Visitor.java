package visitor.model;

import java.util.Date;
import java.util.Map;

public class Visitor {
	private Integer content_num;
	private String user_id;
	private String content;
	private Date content_regdate;
	private Date content_moddate;
		
	public Visitor() {
	}

	public Visitor(Integer content_num, String user_id, String content, Date content_regdate, Date content_moddate) {
		this.content_num = content_num;
		this.user_id = user_id;
		this.content = content;
		this.content_regdate = content_regdate;
		this.content_moddate = content_moddate;
	}

	public int getContent_num() {
		return content_num;
	}

	public void setContent_num(int content_num) {
		this.content_num = content_num;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getContent_regdate() {
		return content_regdate;
	}

	public void setContent_regdate(Date content_regdate) {
		this.content_regdate = content_regdate;
	}

	public Date getContent_moddate() {
		return content_moddate;
	}

	public void setContent_moddate(Date content_moddate) {
		this.content_moddate = content_moddate;
	}

	@Override
	public String toString() {
		return "ContentVO [content_num=" + content_num + ", user_id=" + user_id + ", content=" + content
				+ ", content_regdate=" + content_regdate + ", content_moddate=" + content_moddate + "]";
	}
	
	
	
}
