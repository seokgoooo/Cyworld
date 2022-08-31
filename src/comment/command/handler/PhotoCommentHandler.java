package comment.command.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import reply.dao.PhotoCommentDao;
import reply.model.PhotoComment;

public class PhotoCommentHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
		return null;
		}
		else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception{
	    int comment_num = Integer.parseInt(req.getParameter("comment_num"));
	    int user_num = Integer.parseInt(req.getParameter("user_num"));
	    String comment = req.getParameter("content");
	    
	    PhotoComment pc = new PhotoComment(); //객체생성
	    
	    pc.setComment_num(comment_num); //댓글번호저장
	    pc.setUser_num(user_num);//유저넘 저장
	    pc.setComment(comment);//코멘트 저장
	    
	    PhotoCommentDao pcd = PhotoCommentDao.getInstance();
	    pcd.insertReply(pc);
	    res.sendRedirect("/WEB-INF/view/listPhoto.jsp");
		return null;
	}

}
