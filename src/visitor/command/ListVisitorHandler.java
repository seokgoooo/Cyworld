package visitor.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import visitor.service.ListVisitorService;
import visitor.service.VisitorPage;

public class ListVisitorHandler implements CommandHandler {
	private ListVisitorService listService = new ListVisitorService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		VisitorPage visitorPage = listService.getVisitorPage(pageNo);
		req.setAttribute("articlePage", visitorPage);
		return "/WEB-INF/view/listVisitor.jsp";
	}

}
