package jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Join14")
public class Join14 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private Join14DAO dao;
    public Join14() {
        super();
        dao = new Join14DAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}//doGet

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.getParameter 수행 : 클라이언트에서 온 데이터를 받는다. 
		MemberDTO dto = new MemberDTO();
		dto.setMid(request.getParameter("mid"));
		dto.setMpwd(request.getParameter("mpwd"));
		dto.setTel1(request.getParameter("tel1"));
		dto.setTel2(request.getParameter("tel2"));
		dto.setTel3(request.getParameter("tel3"));
		dto.setEmail1(request.getParameter("email1"));
		dto.setEmail2(request.getParameter("email2"));
		
		//2. DAO에 클라이언트에서 보낸 데이터를 전달 -> 데이터는 인서트를 수행 
		int successCount = 0;// successCount : 인서트를 몇건 성공했는가 
		try {
			successCount = dao.insertMember(dto);
		} catch (SQLException e) {
			//3. DAO에 insert 수행 중에 오류 : exception 처리 (RE10.java 참조) + 오류메시지 출력 
			//session에 오류페이지를 넣은 후, 오류페이지 호출 -> 오류 페이지에서 세션 값 출력 
			e.printStackTrace();
			request.getSession().setAttribute("err_msg", "DBMS오류 - 잠시후 다시 시도해 주세요.");
			response.sendRedirect("./jsp/10RE_err_page.jsp");//특정 페이지로 보내자! 
			return;//프로그램 종료.
		}
		
		response.setCharacterEncoding("euc-kr");
		PrintWriter out = response.getWriter();
		
		//-> DAO
		if(successCount > 0) {
			//5. insert의 결과가 1일때 : 성공 페이지 로드 (0624 join13 참고)
			SuccessMsgDTO msgDTO = new SuccessMsgDTO();
			msgDTO.setMessage("회원가입에 성공하셨습니다.");
			msgDTO.setUrl("./15login.jsp");
			msgDTO.setUrlName("로그인 바로가기");
			request.getSession().setAttribute("success_msg_dto", msgDTO);
			response.sendRedirect("./jsp/success_page.jsp");
		} else {
			//4. insert의 결과가 0일때 : 오류 메시지 출력 
			request.getSession().setAttribute("err_msg", "회원가입실패 <br><br> 잠시후 다시 시도해 주세요.");
			response.sendRedirect("./jsp/10RE_err_page.jsp");//특정 페이지로 보내자! 
		}
		out.close();
	}//doPost

}
