package visitor.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import visitor.service.WriteRequest;
import visitor.service.WriteVisitorService;

public class WriteVisitorHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/newVisitorForm.jsp";
	private WriteVisitorService writeService = new WriteVisitorService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equals("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equals("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}


	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		WriteRequest writeReq = createWriteRequest(req);
		writeReq.validate(errors);
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		int newVisitorNo = writeService.write(writeReq);
		req.setAttribute("newVisitorNo", newVisitorNo);
		
		return "/WEB-INF/view/newVisitorSuccess.jsp";
		
	}
	
	private WriteRequest createWriteRequest(HttpServletRequest req) {
		return new WriteRequest(
				req.getParameter("user_id"),
				req.getParameter("content"));
	}
}
