package owner.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import mvc.command.CommandHandler;
import owner.service.WriteOwnerRequest;
import owner.service.WriteOwnerService;
import visitor.model.Writer;

public class WriteOwnerHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/listVisitor.jsp";
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
		
		User user = (User) req.getSession(false).getAttribute("authUser");
		WriteOwnerRequest writeReq = createWriteRequest(user, req);
		System.out.println(writeReq.getContent_num());
		writeReq.validate(errors);
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		int newOwnerNo = writeService.write(writeReq);
		req.setAttribute("newOwnerNo", newOwnerNo);
		
		return "/visitor/list.do";
		
	}
	
	private WriteOwnerRequest createWriteRequest(User user, HttpServletRequest req) {
		return new WriteOwnerRequest(
				new Writer(user.getNum(), user.getName()),
				req.getParameter("comment"), Integer.valueOf(req.getParameter("content_num")));
	}
}
