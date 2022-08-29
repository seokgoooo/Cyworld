package visitor.service;

import java.util.Date;
import java.util.Map;

import auth.service.User;
import visitor.model.Writer;


public class WriteVisitorRequest {
	private Writer writer;
	private String content;
	
	public WriteVisitorRequest(Writer writer, String content) {
		this.writer = writer;
		this.content = content;
	}

	public Writer getWriter() {
		return writer;
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
			errors.put("content", Boolean.TRUE);
		}
	}

}
