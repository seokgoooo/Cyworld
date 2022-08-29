package owner.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import owner.service.WriteOwnerRequest;
import owner.service.WriteOwnerService;

public class WriteOwnerHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/newVisitorForm.jsp";
	private WriteOwnerService writeService = new WriteOwnerService();

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
		
		WriteOwnerRequest writeReq = createWriteRequest(req);
		writeReq.validate(errors);
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		int newOwnerNo = writeService.write(writeReq);
		req.setAttribute("newOwnerNo", newOwnerNo);
		
		return "/owner/owner.do";
		
	}
	
	private WriteOwnerRequest createWriteRequest(HttpServletRequest req) {
		return new WriteOwnerRequest(
				1,
				req.getParameter("comment"));
	}
}
