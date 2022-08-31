package owner.service;

import java.util.Map;

public class WriteOwnerRequest {
	private Integer content_num;
	private String comment;
	


	public WriteOwnerRequest(Integer content_num, String comment) {
		this.content_num = content_num;
		this.comment = comment;
	}


	public Integer getContent_num() {
		return content_num;
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
