package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.AlergiaDAO;
import negocio.Alergia;


public class BuscarAlergia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("txtNome");
		
		AlergiaDAO aldao = new AlergiaDAO();
		
		List<Alergia> alergias = aldao.buscarPorNome(nome);
		
		request.setAttribute("alergias", alergias);
		RequestDispatcher rd = request.getRequestDispatcher("listarbuscaalergia.jsp");
		rd.forward(request, response);
		
	}

}
