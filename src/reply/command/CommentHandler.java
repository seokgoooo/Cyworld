package reply.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import reply.dao.PhotoCommentDao;
import reply.model.PhotoComment;

public class CommentHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return null;
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int comment_num = Integer.parseInt(req.getParameter("comment_num"));
		int user_num = Integer.parseInt(req.getParameter("user_num"));
		String comment = req.getParameter("comment");
		
		PhotoComment pc = new PhotoComment();
		pc.setComment_num(comment_num);
		pc.setUser_num(user_num);
		pc.setComment(comment);
		
		PhotoCommentDao pcd = PhotoCommentDao.getInstance();
		pcd.insertReply(pc);
		res.sendRedirect("../photo/list.do");
		
		return null;
		
	}

}
