package photo.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import photo.service.ContentData;
import photo.service.PhotoContentNotFoundException;
import photo.service.PhotoNotFoundException;
import photo.service.ReadPhotoContentService;

public class ReadPhotoContentHandler implements CommandHandler {
	private ReadPhotoContentService readService = new ReadPhotoContentService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String noVal = req.getParameter("no");
		int photoNum = Integer.parseInt(noVal);

		try {
			ContentData contentData = readService.getContent(photoNum, true);
			req.setAttribute("contentData", contentData);
			return "/WEB-INF/view/readContent.jsp";
		} catch (PhotoNotFoundException | PhotoContentNotFoundException e) {
			req.getServletContext().log("no photo", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
}