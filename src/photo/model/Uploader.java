package photo.model;

public class Uploader {
	private String id;
	private String name;

	public Uploader(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}