package nano.cat.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nano.cat.dao.Userdao;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegistServlet() {
        super();
    }

	public void destroy() {
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("UserName");
		String password = request.getParameter("Password");
		
		String pwd = new Userdao().findUserName(username);
		if( pwd == null) {
			Boolean regist = new Userdao().Regist(username,password);
			if(regist == false) {
				request.setAttribute("msg", "出现未知异常, 无法注册!");
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
				return;
			}else {
				request.setAttribute("msg", "注册成功! 请登陆");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			
		}else {
			request.setAttribute("msg", "用户名 " + username + " 已存在! 请输入新的用户名");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
