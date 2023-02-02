package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.VacinaDAO;
import negocio.Vacina;

public class ListarVacinas extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		VacinaDAO vdao = new VacinaDAO();
		
		List<Vacina> vacinas = vdao.listar();
		
		request.setAttribute("vacinas", vacinas);
		RequestDispatcher rd = request.getRequestDispatcher("listarvacinas.jsp");
		rd.forward(request, response);
	}

}
