package controller;


import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="todoSaveServlet", urlPatterns = "/save")
public class AddTodoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String viewPath  = "WEB-INF/view/add_todo.jsp";
		String name = req.getParameter("name");
		RequestDispatcher dispather= req.getRequestDispatcher(viewPath);
		dispather.forward(req, resp);
	}
}
