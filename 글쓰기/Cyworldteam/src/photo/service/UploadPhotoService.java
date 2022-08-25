package photo.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import photo.dao.PhotoContentDao;
import photo.dao.PhotoDao;
import photo.model.Photo;
import photo.model.PhotoContent;

public class UploadPhotoService {

	private PhotoDao photoDao = new PhotoDao();
	private PhotoContentDao contentDao = new PhotoContentDao();

	public int Upload(UploadPhotoRequest req) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			Photo photo = toPhoto(req);
			Photo savedPhoto = photoDao.insert(conn, photo);

			if (savedPhoto == null) {
				throw new RuntimeException("fail to insert article");
			}
			PhotoContent content = new PhotoContent(new Integer(0), req.getContent());
			PhotoContent savedContent = contentDao.insert(conn, content);
			if (savedContent == null) {
				throw new RuntimeException("fail to insert article_content");
			}

			conn.commit();

			return savedPhoto.getPhotoNum();

		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}

	private Photo toPhoto(UploadPhotoRequest req) {
		Date now = new Date();
		return new Photo(null, req.getTitle(), now, now, "id");
	}

}
