package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.VacinaDAO;


public class ExcluirVacina extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id	=  Integer.parseInt(request.getParameter("id"));
		
		VacinaDAO vdao = new VacinaDAO();
		
		vdao.excluirVacinaById(id);
		
		response.sendRedirect("ListarVacinas");
	}
}