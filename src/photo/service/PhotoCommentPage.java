package photo.service;
//폼에 보여줄 코멘트 서비스 클래스

import java.util.List;

import reply.model.PhotoComment;

public class PhotoCommentPage {
	private List<PhotoComment> comment;

	public PhotoCommentPage(List<PhotoComment> comment) {
		super();
		this.comment = comment;
	}

	public List<PhotoComment> getComment() {
		return comment;
	}

	public void setComment(List<PhotoComment> comment) {
		this.comment = comment;
	}

}
