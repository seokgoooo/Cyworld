package photo.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import photo.model.Uploader;
import photo.service.UploadPhotoRequest;
import photo.service.UploadPhotoService;

public class UploadPhotoHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/photouploadform.jsp";
	private UploadPhotoService uploadphotoservice = new UploadPhotoService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		if (req.getMethod().equalsIgnoreCase("GET")) { // get방식으로 요청
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {// post방식으로 요청
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); // 요청되지 못했을 때
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) { // 요청 성공 -> form.jsp
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		User user = (User) req.getSession(false).getAttribute("User");
		UploadPhotoRequest photouploadReq = createUploadRequest(user, req);
		photouploadReq.validate(errors);

		if (!errors.isEmpty()) {
			return FORM_VIEW; // 요청 성공 -> form.jsp
		}

		int newPhotoNo = uploadphotoservice.upload(photouploadReq);
		req.setAttribute("newPhotoNo", newPhotoNo);

		return "./photouploadsuccess.jsp";
	}

	private UploadPhotoRequest createUploadRequest(User user, HttpServletRequest req) {
		return new UploadPhotoRequest(new Uploader("id", "name"), req.getParameter("title"),
				req.getParameter("content"));
	}
}