package jsp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FBList17")
public class FBList17 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private FB17DAO dao;
    public FBList17() {
        super();
        dao = new FB17DAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		if(cmd == null) cmd = "list";
		if(cmd.equals("uform")) {
			
			String no = request.getParameter("no");
			BoardDTO dto = null;
			try {
			dto = dao.detail(no);
			} catch(SQLException e) {
				e.printStackTrace();
				UtilMessage.setSessionFailMsg(request.getSession()
						, "DBMS 오류"
						, request.getContextPath() + "/FBList17?cmd=list"
						, "게시판 목록 바로가기");
				response.sendRedirect(request.getContextPath() + "/jsp/fail_page.jsp");
				return;
			}
			request.setAttribute("free_board_detail", dto);
			request.getRequestDispatcher("/jsp/17fb_update.jsp").forward(request, response);
		} else if(cmd.equals("delete") ) {
			String no = request.getParameter("no");
			int successCount = 0;
			try {
			successCount = dao.delete(no);
			} catch(SQLException e) {
				e.printStackTrace();
				UtilMessage.setSessionFailMsg(request.getSession()
						, "DBMS오류"
						, request.getContextPath() + "/FBList17?cmd=list"
						, "게시판으로 바로가기");  
				response.sendRedirect("./jsp/fail_page.jsp");
				return;
			}
			if(successCount == 0) {
				UtilMessage.setSessionFailMsg(request.getSession()
						, "DBMS오류"
						, request.getContextPath() + "/FBList17?cmd=list"
						, "게시판으로 바로가기");
				response.sendRedirect( request.getContextPath() + "/jsp/fail_page.jsp"); 
			} else if( successCount == 1 ) {
				response.sendRedirect(request.getContextPath() + "/FBList17?cmd=list");
			}
		} else if(cmd.equals("detail")) {
			
			String no = request.getParameter("no");
			BoardDTO dto = null; 
			try {
				dto = dao.detail(no);
			} catch (SQLException e) {
				e.printStackTrace();
				UtilMessage.setSessionFailMsg(request.getSession()
						, "DBMS오류"
						, request.getContextPath() + "/FBList17?cmd=list"
						, "게시판 목록으로 바로가기");
				response.sendRedirect(request.getContextPath() + "/jsp/fail_page.jsp");
				return;
			}
			request.setAttribute("free_board_detail", dto);
			RequestDispatcher disp = request.getRequestDispatcher("/jsp/17fb_detail.jsp");
			disp.forward(request, response);
			
			
		} else if(cmd.equals("list")){//list처리
			
			ArrayList<BoardDTO> list = new ArrayList<BoardDTO>(); 
			try {
				list = dao.list();
			} catch (SQLException e) {
				e.printStackTrace();//개발자의 에러 수정을 위해 콘솔 출력을 하는 것. 
				
				UtilMessage.setSessionFailMsg(request.getSession()
						, "DBMS오류"
						, request.getContextPath() + "/jsp/main.jsp"
						, "메인으로 바로가기");
				response.sendRedirect("./jsp/fail_page.jsp");
				
				return;
			}//catch
			//request.setAttribute 하는 경우는 RequestDispatcher 가 필요하다. 
			request.setAttribute("free_board_list", list);
			RequestDispatcher disp = request.getRequestDispatcher("./jsp/17fb_list.jsp");
			disp.forward(request, response);
			
		}//else
		
	}//doGet

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		//0. cmd에 따라 분기한다. 
		String cmd = request.getParameter("cmd");
		if(cmd.equals("write")) {
			//1. BoardDTO에 request.getParameter - 3개 
			BoardDTO dto = new BoardDTO();
			dto.setBtitle(request.getParameter("title"));
			dto.setBwriter(request.getParameter("writer"));
			dto.setBcnts(request.getParameter("cnts"));
			//2. int successCount = dao.write(dto);
			int successCount = 0;
			try {
				successCount = dao.write(dto);
			} catch (SQLException e) {
				e.printStackTrace();
				//3. exception 처리 -> 메시지 처리 
				UtilMessage.setSessionFailMsg(request.getSession()
						, "DBMS오류"
						, request.getContextPath() + "/jsp/main.jsp"
						, "메인으로 바로가기");
				response.sendRedirect("./jsp/fail_page.jsp");
				return;
			}
			if( successCount == 0 ) {
				//4. successCount = 0일때 0처리 -> 메시지 처리 
				UtilMessage.setSessionFailMsg(request.getSession()
						, "DBMS오류"
						, request.getContextPath() + "/FBList17"
						, "메인으로 바로가기");
				response.sendRedirect( request.getContextPath() + "/jsp/fail_page.jsp");
			}else if(successCount ==1 ) {
				//5. successCount = 1일때 0처리 -> list 호출 
				response.sendRedirect( request.getContextPath() + "/FBList17?cmd=list");//실행시점이 jsp패키지 내부 
			}
			
		} else if(cmd.equals("update")) {
			//update : 전제조건, select 결과를 수정. 
			//모듈이 2개 : select, update 
			//select for update
			String no = request.getParameter("no");
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String cnts = request.getParameter("cnts");
			int successCount = 0;
			try {
			successCount = dao.update( no, title, writer, cnts);
			} catch(SQLException e) {
				e.printStackTrace();
				UtilMessage.setSessionFailMsg(request.getSession()
						, "DBMS오류"
						, request.getContextPath() + "/FBList17?cmd=list"
						, "게시판 목록으로 바로가기");
				response.sendRedirect(request.getContextPath() + "/jsp/fail_page.jsp");
				return;
			}
			if( successCount == 0) {
				UtilMessage.setSessionFailMsg(request.getSession()
						, "게시판 수정을 실패하였습니다."
						, request.getContextPath() + "/FBList?cmd=list"
						, "게시판 목록으로 바로가기");
				response.sendRedirect(request.getContextPath() + "/jsp/fail_page.jsp");
				
			}else if( successCount == 1) {
				response.sendRedirect("./FBList17?cmd=list");
			}
			
		}
	}//doPost

}//class
