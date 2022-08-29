package auth.service;

public class User {
	private String id;
	private String name;
	private Integer num;
	public User(String id, String name, Integer num) {
		this.id = id;
		this.name = name;
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getNum() {
		return num;
	}
	
	
}
