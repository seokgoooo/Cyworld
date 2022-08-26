package photo.service;

import photo.model.Photo;
import photo.model.PhotoContent;

public class ContentData {
	private Photo photo;
	private PhotoContent content;
	public ContentData(Photo photo, PhotoContent content) {
		super();
		this.photo = photo;
		this.content = content;
	}
	public Photo getPhoto() {
		return photo;
	}
	
	public PhotoContent getContent() {
		return content;
	}
	
	

}
