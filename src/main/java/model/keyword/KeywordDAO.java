package main.model.keyword;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import main.model.site.SiteVO;
import main.util.DBManager;
public class KeywordDAO {
	public KeywordDAO() {}
	private static KeywordDAO instance = new KeywordDAO();
	
	
	public static KeywordDAO getInstance() {
		return instance;
	}
	
	public int insertKeyword(String shortUri,int relId,String keyStr,String morphemeTypeCode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		int num=0;
		
		try {
			String query="INSERT INTO keyword(regDate,updateDate,memberId,relTypeCode,relId,keyStr,morphemeTypeCode) "
					+ "VALUES(now(),now(),0,?,?,?,?)";
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(query);

			pstmt.setString(1,shortUri);
			pstmt.setInt(2,relId);
			pstmt.setString(3,keyStr);
			pstmt.setString(4,morphemeTypeCode);
		
			num=pstmt.executeUpdate();
		}catch (Exception e) {
		e.printStackTrace();

		}finally {
			
			try {
				DBManager.close(conn, pstmt,rs);
			} catch (Exception ee) {
			}
		}
		return num;

	}
	
}





