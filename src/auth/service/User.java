package auth.service;

public class User {
	private Integer num;
	private String id;
	private String name;
	private String gender;
	private String img_path;

	public User() {

	}

	public User(Integer num, String id, String name, String gender, String img_path) {
		this.num = num;
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.img_path = img_path;
	}

	public Integer setNum(Integer num) {
		return this.num = num;
	}

	public Integer getNum() {
		return num;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getImg() {
		return img_path;
	}
}