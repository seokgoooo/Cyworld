package photo.command;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mvc.command.CommandHandler;
import photo.dao.PhotoDao;
import photo.model.Photo;

public class PhotoUpdateHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {// get방식으로 오면 실행
			return processForm(req, res);

		} else if (req.getMethod().equalsIgnoreCase("POST")) {// post방식으로 오면 실행
			return processSubmit(req, res);

		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String url = "WEB_INF/view/photoUpdate.jsp";// 생성해야함 포토업데이트제이에스피
		Integer photo_num = Integer.parseInt(req.getParameter("photo_num"));
		PhotoDao pDao = PhotoDao.getInstance();
		Photo photo = pDao.selectProductPhotoNum(photo_num);
		req.setAttribute("photo", photo);
		return url;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		req.setCharacterEncoding("UTF-8");
		ServletContext context = req.getServletContext();
		String path = context.getRealPath("upload");// 경로설정
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;// 사진크기제한
		MultipartRequest multi = new MultipartRequest(req, path, sizeLimit, encType, new DefaultFileRenamePolicy());
        int photo_num = Integer.parseInt(multi.getParameter("photo_num"));
        String title = multi.getParameter("photo_title");
        String url = multi.getFilesystemName("url");
        String content = multi.getParameter("content");
        
        if(url == null) { // 사진이없으면 실행
        	url = multi.getParameter("url");
        }
        Photo photo = new Photo();
        photo.setNumber(photo_num);
        photo.setTitle(title);
        photo.setContent(content);
        photo.setUrl(url);
        PhotoDao pDao = PhotoDao.getInstance();
        pDao.updatePhoto(photo);
        res.sendRedirect("../photo/list.do");
        return null;
        
	}

}
