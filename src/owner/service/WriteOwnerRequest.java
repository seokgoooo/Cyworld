package owner.service;

import java.util.Map;

import visitor.model.Writer;

public class WriteOwnerRequest {
	private Writer writer;
	private String comment;
	private Integer content_num;
	



	public WriteOwnerRequest(Writer writer, String comment, Integer content_num) {
		this.writer = writer;
		this.comment = comment;
		this.content_num = content_num;
	}


	
	public Integer getContent_num() {
		return content_num;
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
