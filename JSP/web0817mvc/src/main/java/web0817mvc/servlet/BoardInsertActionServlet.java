package web0817mvc.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web0817mvc.dao.BoardDao;
import web0817mvc.dao.BoardDaoImpl;
import web0817mvc.dto.BoardDto;
import web0817mvc.exception.DuplicatedIdException;

@WebServlet("/board/insert_action")
public class BoardInsertActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		BoardDto dto = new BoardDto();
		dto.setTitle(request.getParameter("title"));
		dto.setWriter(request.getParameter("writer"));
		dto.setContent(request.getParameter("content"));
		
		String url = "/board_ok.jsp"; // 앞에 /가 붙였기 때문에 webapp이라는 의미
		try {
			BoardDao dao = new BoardDaoImpl();
			dao.add(dto);
			request.setAttribute("msg", "게시물 등록 성공"); //request에 속성 저장
		} catch (Exception e) {
			e.printStackTrace();
			url = "/board_error.jsp";
			request.setAttribute("err_msg", e.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
