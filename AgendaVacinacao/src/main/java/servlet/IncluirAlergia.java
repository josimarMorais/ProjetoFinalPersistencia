package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.AlergiaDAO;
import negocio.Alergia;


public class IncluirAlergia extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("txtNome");
		
		System.out.println(nome);
		
		Alergia ale = new Alergia(nome);
		
		AlergiaDAO aleDao = new AlergiaDAO();
		
		aleDao.incluirNovaAlergia(ale);
		
		response.sendRedirect("ListarAlergias");
		
	}

}
