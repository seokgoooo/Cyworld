package photo.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import photo.dao.PhotoContentDao;
import photo.dao.PhotoDao;
import photo.model.Photo;
import photo.model.PhotoContent;

public class ReadPhotoContentService {
	private PhotoDao photoDao = new PhotoDao();
	private PhotoContentDao contentDao = new PhotoContentDao();

	public ContentData getContent(int photo_Num, boolean increaseReadCount) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			Photo photo = photoDao.selectById(conn, photo_Num);

			if (photo == null) {
				throw new PhotoNotFoundException();
			}
			PhotoContent content = contentDao.selectById(conn, photo_Num);
			if (content == null) {
				throw new PhotoContentNotFoundException();
			}
			if (increaseReadCount) {
				photoDao.increaseReadCount(conn, photo_Num);
			}
			return new ContentData(photo, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}