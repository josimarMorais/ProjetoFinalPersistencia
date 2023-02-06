package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.AlergiaDAO;


public class ExcluirAlergia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id	=  Integer.parseInt(request.getParameter("id"));
		
		AlergiaDAO adao = new AlergiaDAO();
		
		adao.excluirAlergiaById(id);
		
		response.sendRedirect("ListarAlergias");
	}

}
