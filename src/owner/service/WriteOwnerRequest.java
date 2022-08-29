package owner.service;

import java.util.Map;

import visitor.model.Writer;

public class WriteOwnerRequest {
	private Writer writer;
	private String comment;
	



	public WriteOwnerRequest(Writer writer, String comment) {
		this.writer = writer;
		this.comment = comment;
	}


	public Writer getWriter() {
		return writer;
	}


	public String getComment() {
		return comment;
	}
	

	public void validate(Map<String, Boolean> errors) {
		if(comment == null || comment.trim().isEmpty()) {
			errors.put("comment", Boolean.TRUE);
		}
	}
}
