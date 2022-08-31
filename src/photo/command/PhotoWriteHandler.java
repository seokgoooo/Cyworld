package photo.command;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import auth.service.User;
import mvc.command.CommandHandler;
import photo.dao.PhotoDao;
import photo.model.Photo;

public class PhotoWriteHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return "/WEB-INF/view/writePhoto.jsp";
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		req.setCharacterEncoding("UTF-8");
		ServletContext context = req.getServletContext();
		String path = context.getRealPath("image"); // 경로설정
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(req, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		//String photo_regDate = multi.getParameter("photo_regDate");
		String url = multi.getFilesystemName("url");
		req.getParameter("user_num");
		//System.out.println(req.getParameter("user_num"));
		Photo photo = new Photo();
//		User user = (User) req.getSession().getAttribute("user_num");
		System.out.println(req.getParameter("user_num"));
		Object user_num = (User) req.getSession().getAttribute("user_num"); 
		
		User user = (User) req.getSession().getAttribute("authUser");
		Integer num = user.getNum();
		
		
		photo.setTitle(title);
		//photo.setRegDate(new Timestamp(System.currentTimeMillis()));
		
		photo.setUrl(url);
		photo.setContent(content);
		//photo.setUser_num(Integer.valueOf(user_num));
		PhotoDao photoDao = PhotoDao.getInstance();
		photoDao.insertPhoto(photo, num);
		res.sendRedirect("../photo/list.do");
		return null;
	}
	
	

}
