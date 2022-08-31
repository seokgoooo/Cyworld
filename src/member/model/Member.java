package member.model;

import java.util.Date;

public class Member {
	private Integer num;
	private String id;
	private String pw;
	private String name;
	private String gender;
	private Date regdate;
	private String img_path;
	private String title;
	private String profile;
	private Integer menu;

	public Member(String id, String pw, String name, String gender, Date regdate) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.gender = gender;
		this.regdate = regdate;
	}

	public Member(String id, String img_path, String title, String profile, Integer menu) {
		this.id = id;
		this.img_path = img_path;
		this.title = title;
		this.profile = profile;
		this.menu = menu;
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

	public Date getRegdate() {
		return regdate;
	}

	public String getImg_path() {
		return img_path;
	}

	public String getTitle() {
		return title;
	}

	public String getProfile() {
		return profile;
	}

	public Integer getMenu() {
		return menu;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public void setMenu(Integer menu) {
		this.menu = menu;
	}

	public boolean matchPassword(String pwd) {
		return pw.equals(pwd);
	}

	public void changePassword(String newPwd) {
		this.pw = newPwd;
	}
}
