package nano.cat.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nano.cat.dao.notesdao;

/**
 * Servlet implementation class takenotesServlet
 */
@WebServlet("/takenotesServlet")
public class takenotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public takenotesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username = request.getSession().getAttribute("username").toString();
		String title = request.getParameter("Title");
		String content = request.getParameter("Content");
		
		Boolean result = new notesdao().setNotes(username, title, content);
		
		if (result == true) {
			request.setAttribute("msg", "添加笔记成功!");
			request.getRequestDispatcher("/takenotes.jsp").forward(request, response);
			return;
		}else {
			request.setAttribute("msg", "发生错误,添加笔记失败!");
			request.getRequestDispatcher("/takenotes.jsp").forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
