package member.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.LoginService;
import auth.service.User;
import member.dao.MemberDao;
import member.service.EditRequest;
import member.service.EditService;
import mvc.command.CommandHandler;

public class EditHandler implements CommandHandler {
	private static final String FORM_VIEW = "/edit.jsp";
	private EditService editService = new EditService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
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
		EditRequest editReq = new EditRequest();

		String img = req.getParameter("img_path");
		String title = req.getParameter("title");
		String profile = req.getParameter("profile");

		User user = (User) req.getSession().getAttribute("authUser");
		String id = user.getId();

		editReq.setId(id);
		editReq.setImg_path(img);
		editReq.setTitle(title);
		editReq.setProfile(profile);
		editReq.setMenu(0);

		if (img == null)
			editReq.setImg_path(user.getImg());

		if (title == null)
			editReq.setTitle(user.getTitle());

		if (profile == null)
			editReq.setProfile(user.getProfile());

		editService.edit(editReq);

		req.getSession().removeAttribute("authUser");

		try {
			User updateUser = editService.updateAuthUser(id);
			req.getSession().setAttribute("authUser", updateUser);
			res.sendRedirect(req.getContextPath() + "/main.jsp");
			return null;
		} catch (IOException e) {
			return FORM_VIEW;
		}
	}
}