package photo.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import photo.dao.PhotoDao;
import photo.model.Photo;
//페이지 설정
public class ListPhotoService {
	private PhotoDao photoDao = PhotoDao.getInstance();
	private int size = 10;
	
	public PhotoPage getPhotoPage(int pageNum) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = photoDao.getInstance().selectCount(conn);
			List<Photo> list = photoDao.select(conn, (pageNum - 1) * size, size);
			return new PhotoPage(total, pageNum, size, list);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}