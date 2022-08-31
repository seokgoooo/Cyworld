package visitor.model;

import java.util.Date;
import java.util.Map;

import owner.model.Owner;

public class Visitor {
	private Integer content_num;
	private Integer user_num;
	private String content;
	private String content_regdate;
	private String content_moddate;
	private String name;
	private Owner owner;
		
	public Visitor() {
	}


	public Visitor(Integer content_num, Integer user_num, String content, String content_regdate, String content_moddate) {
		this.content_num = content_num;
		this.user_num = user_num;
		this.content = content;
		this.content_regdate = content_regdate;
		this.content_moddate = content_moddate;
	}



	public Visitor(Integer content_num, Integer user_num, String content, String content_regdate, String content_moddate,
			String name, Owner owner) {
		this.content_num = content_num;
		this.user_num = user_num;
		this.content = content;
		this.content_regdate = content_regdate;
		this.content_moddate = content_moddate;
		this.name = name;
		this.owner = owner;
	}


	public String getName() {
		return name;
	}


	public Owner getOwner() {
		return owner;
	}


	public void setOwner(Owner owner) {
		this.owner = owner;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getUser_num() {
		return user_num;
	}


	public void setUser_num(Integer user_num) {
		this.user_num = user_num;
	}


	public int getContent_num() {
		return content_num;
	}

	public void setContent_num(int content_num) {
		this.content_num = content_num;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent_regdate() {
		return content_regdate;
	}

	public void setContent_regdate(String content_regdate) {
		this.content_regdate = content_regdate;
	}

	public String getContent_moddate() {
		return content_moddate;
	}

	public void setContent_moddate(String content_moddate) {
		this.content_moddate = content_moddate;
	}


	@Override
	public String toString() {
		return "Visitor [content_num=" + content_num + ", user_num=" + user_num + ", content=" + content
				+ ", content_regdate=" + content_regdate + ", content_moddate=" + content_moddate + "]";
	}

	
}
