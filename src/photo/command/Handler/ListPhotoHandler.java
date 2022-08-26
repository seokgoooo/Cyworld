package photo.command.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import photo.dao.PhotoDao;
import photo.service.ListPhotoService;
import photo.service.PhotoPage;

public class ListPhotoHandler implements CommandHandler {
	private ListPhotoService photoService = new ListPhotoService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
	    PhotoPage photoPage = photoService.getPhotoPage(pageNo);
	    req.setAttribute("photoPage", photoPage);
	    
		return "/WEB-INF/view/listPhoto.jsp";
	}

}
