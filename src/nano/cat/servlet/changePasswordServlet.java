package nano.cat.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nano.cat.dao.Userdao;

@WebServlet("/changePasswordServlet")
public class changePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public changePasswordServlet() {
        super();
    }

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");		//设置post字符编码
		
		if(request.getSession().getAttribute("username") == null ) {
			request.setAttribute("msg", "出现错误! 找不到您的用户信息");
			request.getRequestDispatcher("/changepassword.jsp").forward(request, response);
			return;
		}
		
		String username = request.getSession().getAttribute("username").toString();
		
		String oldpassword = request.getParameter("OldPassword");
		String newpassword = request.getParameter("NewPassword");
		
		String pwd = new Userdao().findUserName(username);
		if(pwd != null && !pwd.equals(oldpassword)) {
			request.setAttribute("msg", "您的原密码输入错误");
			request.getRequestDispatcher("/changepassword.jsp").forward(request, response);
			return;
		}
		if(pwd.equals(oldpassword)) {
			
			Boolean result = new Userdao().changePassword(username, newpassword);
			if (result == true) {
				request.setAttribute("msg", "密码更改成功!");
	            request.getRequestDispatcher("/changepassword.jsp").forward(request, response);
	            return;
			}else {
				request.setAttribute("msg", "发生错误! 密码更改失败!");
	            request.getRequestDispatcher("/changepassword.jsp").forward(request, response);
	            return;
			}	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
