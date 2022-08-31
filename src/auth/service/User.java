package auth.service;

import java.util.Date;

public class User {
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

	public User(Integer num, String id, String name, String gender, Date regdate, String img_path, String title,
			String profile, Integer menu, String pw) {
		this.num = num;
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.regdate = regdate;
		this.img_path = img_path;
		this.title = title;
		this.profile = profile;
		this.menu = menu;
		this.pw = pw;
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

	public String getImg() {
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
}