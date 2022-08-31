package visitor.service;

import visitor.model.Visitor;
import visitor.model.Writer;

public class VisitorRequest {
	private Writer writer;
	private Visitor visitor;
	
	public VisitorRequest(Writer writer, Visitor visitor) {
		this.writer = writer;
		this.visitor = visitor;
	}

	public Writer getWriter() {
		return writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}

	public Visitor getVisitor() {
		return visitor;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}
	
	
}
