package photo.content.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Blob;

import jdbc.JdbcUtil;
import photo.model.PhotoContent;

public class PhotoContentDao {
	
	public PhotoContent selectById(Connection conn, int no) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select * from photo_content where photo_num=?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			PhotoContent content = null;
			
			if(rs.next()) {
				content = new PhotoContent(rs.getString("content"), 
						(Blob) rs.getBlob("content-img"), rs.getInt("photoNum"));
			}
			return content;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	

}
