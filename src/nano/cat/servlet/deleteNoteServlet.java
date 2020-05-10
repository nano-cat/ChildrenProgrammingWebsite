package nano.cat.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nano.cat.dao.notesdao;

@WebServlet("/deleteNoteServlet")
public class deleteNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public deleteNoteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String noteid = request.getParameter("Delete");
		//验证管理员登陆身份
		if(request.getSession().getAttribute("username").equals("nanocat")) {
			Boolean delete = new notesdao().deleteNotes(noteid);
			if(delete == true) {
				request.setAttribute("msg", "删除 "+noteid+" 号笔记成功!");
				request.getRequestDispatcher("/manager_note.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "出现错误! 删除失败! ");
				request.getRequestDispatcher("/manager_note.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("msg", "验证管理员身份失败! ");
			request.getRequestDispatcher("/manager_note.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
