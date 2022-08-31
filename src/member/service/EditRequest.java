package member.service;

import java.util.Map;

public class EditRequest {
	private String id;
	private String img_path;
	private String title;
	private String profile;
	private Integer menu;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	public String getTitle() {
		if (title == null) {
			return " ";
		}
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProfile() {
		if (profile == null) {
			return " ";
		}
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public Integer getMenu() {
		if (menu == null) {
			return 0;
		}
		return menu;
	}

	public void setMenu(Integer menu) {
		this.menu = menu;
	}

	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, id, "id");
		checkEmpty(errors, String.valueOf(menu), "menu");
	}

	private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
		if (value == null || value.isEmpty()) {
			errors.put(fieldName, Boolean.TRUE);
		}
	}
}
