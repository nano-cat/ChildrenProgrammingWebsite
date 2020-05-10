package nano.cat.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nano.cat.dao.Userdao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();    
    }
	public void destroy() {	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("UserName");
		String password = request.getParameter("Password");
		String usertype = request.getParameter("UserType");
		
		String pwd = new Userdao().findUserName(username);
		
		if(usertype.equals("admin")) {
			if(username.equals("nanocat")) {
				//pwd和password写反了竟然不行!明明大家都是String
				if(pwd.equals(password)) {
					HttpSession session = request.getSession();
		            session.setAttribute("username", username);
					request.getRequestDispatcher("/manager.jsp").forward(request, response);
					return;
				}else {
					request.setAttribute("msg", "管理员密码错误!");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					return;
				}
			}else {
				request.setAttribute("msg", "非管理员请选择普通用户登陆!");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			}
		}
		

		if(pwd == null ) {
			request.setAttribute("msg", "用户名 " + username + " 不存在!请检查输入的用户名..");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		if(pwd != null && !pwd.equals(password)) {
			request.setAttribute("msg", "密码输入错误!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		if(pwd.equals(password)) {
			
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
