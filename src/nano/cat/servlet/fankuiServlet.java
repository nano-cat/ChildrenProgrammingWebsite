package nano.cat.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nano.cat.dao.fankuidao;

@WebServlet("/fankuiServlet")
public class fankuiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public fankuiServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username = request.getSession().getAttribute("username").toString();
		String email = request.getParameter("Email");
		String title = request.getParameter("Title");
		String content = request.getParameter("Content");
		
		Boolean result = new fankuidao().setFankui(username, email, title, content);
		if (result == true) {
			request.setAttribute("msg", "反馈成功!");
			request.getRequestDispatcher("/fankui.jsp").forward(request, response);
			return;
		}else {
			request.setAttribute("msg", "发生错误,反馈失败!");
			request.getRequestDispatcher("/fankui.jsp").forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
