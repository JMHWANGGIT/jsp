package jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FB17DAO {
	
	public FB17DAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}//constructor(생성자): oracle driver 로딩 
	
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "C##scott";
	private final String PASSWORD = "tiger";
	
	private Connection con;
	private PreparedStatement psmt;
	private ResultSet rs;
	private String sql;
	
	public ArrayList<BoardDTO> list() throws SQLException{
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		sql = "select bno, btitle, bwriter, bcnts, bdate from freeboard order by bno desc";
		con = DriverManager.getConnection(URL, USER, PASSWORD);
		psmt = con.prepareStatement(sql);
		rs = psmt.executeQuery();
		while(rs.next()) {
			BoardDTO dto = new BoardDTO();
			dto.setBno(rs.getString("bno"));
			dto.setBtitle(rs.getString("btitle"));
			dto.setBwriter(rs.getString("bwriter"));
			dto.setBcnts(rs.getString("bcnts"));
			dto.setBdate(rs.getString("bdate"));
			list.add(dto);
		}//whlie
		rs.close();
		psmt.close();
		con.close();
		
		return list;
	}//list
	
	//게시판 글쓰기 ()
	public int write( BoardDTO dto) throws SQLException{
		int successCount = 0;
		con = DriverManager.getConnection(URL, USER, PASSWORD);
		String sql = "insert into freeboard (bno, btitle, bwriter, bcnts"
				+ ", bdate) values (mno_seq.nextval, ?, ?, ?, sysdate)";
		psmt = con.prepareStatement(sql);
		psmt.setString(1, dto.getBtitle());
		psmt.setString(2, dto.getBwriter());
		psmt.setString(3, dto.getBcnts());
		successCount = psmt.executeUpdate();
		psmt.close();
		con.close();
		
		return successCount;
	}//write
	
	public BoardDTO detail( String no ) throws SQLException{
		BoardDTO dto = new BoardDTO();
		con = DriverManager.getConnection(URL, USER, PASSWORD);
		String sql = "select bno, btitle, bwriter, bcnts"
				+ ", bdate from freeboard where bno=?";
		psmt = con.prepareStatement(sql);
		psmt.setString(1, no);
		rs = psmt.executeQuery();
		rs.next();
		dto.setBno(rs.getString("bno"));
		dto.setBtitle(rs.getString("btitle"));
		dto.setBwriter(rs.getString("bwriter"));
		dto.setBcnts(rs.getString("bcnts"));
		dto.setBdate(rs.getString("bdate"));
		
		rs.close();
		psmt.close();
		con.close();
		
		return dto;
	}

	public int delete(String no) throws SQLException{
		int successCount = 0;
		con = DriverManager.getConnection(URL, USER, PASSWORD);
		String sql = "delete from freeboard where bno=?";
		psmt = con.prepareStatement(sql);
		psmt.setString(1, no);
		successCount = psmt.executeUpdate();
		
		psmt.close();
		con.close();
		
		return successCount;
	}
	
	public int update(String no, String title, String writer, String cnts) throws SQLException{
		int successCount = 0;
		con = DriverManager.getConnection(URL, USER, PASSWORD);
		String sql = "update freeboard set btitle = ?, bwriter = ?, bcnts = ? where bno = ?";
		psmt = con.prepareStatement(sql);
		psmt.setString(1, title);
		psmt.setString(2, writer);
		psmt.setString(3, cnts);
		psmt.setString(4, no);
		successCount = psmt.executeUpdate();
		
		psmt.close();
		con.close();
		
		
		return successCount;
	}
	
}//class
