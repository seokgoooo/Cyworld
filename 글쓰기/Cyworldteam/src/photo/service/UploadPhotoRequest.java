package photo.service;

import java.util.Map;

import com.mysql.cj.jdbc.Blob;

import photo.model.Uploader;

public class UploadPhotoRequest {

	private Uploader uploader;
	private String title;
	private String content;

	public UploadPhotoRequest(Uploader uploader, String title, String content) {
		this.uploader = uploader;
		this.title = title;
		this.content = content;
	}

	public Uploader getUploader() {
		return uploader;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public void validate(Map<String, Boolean> errors) {
		if (title == null || title.trim().isEmpty()) {
			errors.put("title", Boolean.TRUE);
		}
	}
}