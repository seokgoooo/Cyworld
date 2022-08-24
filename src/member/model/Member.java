package member.model;

import java.util.Date;

public class Member {
	private String id;
	private String password;
	private String name;
	private String gender;
	private String img_path;
	private Date regdate;

	public Member(String id, String password, String name, String gender, Date regdate) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.regdate = regdate;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
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
		return password.equals(pwd);
	}

	public void changePassword(String newPwd) {
		this.password = newPwd;
	}

}
