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

@WebServlet("/board/detail") //웹브라우저 주소를 의미
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sno = request.getParameter("no");
		int no = Integer.parseInt(sno);
		String url ="/board_detail.jsp";
		
		BoardDao dao = new BoardDaoImpl();
		try {
			BoardDto dto = dao.findById(no);
			request.setAttribute("dto", dto);
		} catch (SQLException e) {
			e.printStackTrace();
			url = "/board_error.jsp";
			request.setAttribute("err_msg", e.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
