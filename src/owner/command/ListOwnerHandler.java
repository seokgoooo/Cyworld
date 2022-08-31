package owner.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import owner.service.ListOwnerService;
import visitor.service.VisitorPage;

public class ListOwnerHandler implements CommandHandler{
	private ListOwnerService listService = new ListOwnerService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		VisitorPage ownerPage = listService.getOwnerPage(pageNo);
		req.setAttribute("ownerPage", ownerPage);
		return "/WEB-INF/view/listVisitor.jsp";
	}
}
