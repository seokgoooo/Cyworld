package photo.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import mvc.command.CommandHandler;
import photo.dao.PhotoDao;

public class PhotoDeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {// get방식으로 오면 실행
			return null;

		} else if (req.getMethod().equalsIgnoreCase("POST")) {// post방식으로 오면 실행
			return processForm(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}

	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Integer photo_num = Integer.parseInt(req.getParameter("photo_num"));
		PhotoDao photoDao = PhotoDao.getInstance();
		photoDao.deletePhoto(photo_num);
		res.sendRedirect("../photo/photo.do");//사진첩으로 redirect
		return null;
	}
}
