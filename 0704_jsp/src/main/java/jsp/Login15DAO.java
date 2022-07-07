package jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login15DAO {
	
	public Login15DAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}//생성자
	
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "C##scott";
	private final String PASSWORD = "tiger";
	
	private Connection con;
	private PreparedStatement psmt;
	private ResultSet rs;
	private String sql;
	
	public int loginCheck(String id, String pwd) throws SQLException{
		int loginYN = 0;
		con = DriverManager.getConnection(URL, USER, PASSWORD);
		sql = "select count(mno) cnt from member where mid=? and mpwd=?";
		psmt = con.prepareStatement(sql);
		psmt.setString(1, id);
		psmt.setString(2, pwd);
		rs = psmt.executeQuery();
		rs.next();
		loginYN = rs.getInt("cnt");
		
		rs.close();
		psmt.close();
		con.close();
		
		return loginYN;
	}//loginCheck
	
}//class
