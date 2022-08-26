package member.model;

import java.util.Date;

public class Member {
	private Integer num;
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String img_path;
	private Date regdate;

	public Member(String id, String pw, String name, String gender, Date regdate) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.gender = gender;
		this.regdate = regdate;
	}

	public Integer getNum() {
		return num;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	public Date getRegdate() {
		return regdate;
	}

	public boolean matchPassword(String pwd) {
		return pw.equals(pwd);
	}

	public void changePassword(String newPwd) {
		this.pw = newPwd;
	}

}
