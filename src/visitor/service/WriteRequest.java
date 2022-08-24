package visitor.service;

import java.util.Date;
import java.util.Map;


public class WriteRequest {
	private String user_id;
	private String content;
	
	public WriteRequest(String user_id, String content) {
		this.user_id = user_id;
		this.content = content;
	}

	public String getUser_id() {
		return user_id;
	}

	public String getContent() {
		return content;
	}
	
	
//	public Integer getContent_num() {
//		return content_num;
//	}
//
//	public Date getContent_regdate() {
//		return content_regdate;
//	}
//
//	public Date getContent_moddate() {
//		return content_moddate;
//	}

	public void validate(Map<String, Boolean> errors) {
		if(content == null || content.trim().isEmpty()) {
			errors.put("title", Boolean.TRUE);
		}
	}

}
