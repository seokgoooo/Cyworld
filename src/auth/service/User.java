package auth.service;

public class User {
	private String id;
	private String name;
	private String gender;
	private String img_path;

	public User(String id, String name, String gender, String img_path) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.img_path = img_path;
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