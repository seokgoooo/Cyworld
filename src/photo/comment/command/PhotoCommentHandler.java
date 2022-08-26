package photo.comment.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import photo.comment.dao.PhotoCommentDao;
import photo.model.PhotoComment;

public class PhotoCommentHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return null;
		} else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int comnum = Integer.parseInt(req.getParameter("comment_num"));
		
		String userid = req.getParameter("user_id");
		String comment = req.getParameter("comment");
		
		PhotoComment pc = new PhotoComment();
		pc.setCommentNum(comnum);
		pc.setUserId(userid);
		pc.setComment(comment);
		
		PhotoCommentDao pcDao = new PhotoCommentDao();
		pcDao.insertComment(pc);//댓글등록
		res.sendRedirect("/WEB-INF/view/photocontent.jsp");
		
		return null;
		

		
	}

}
