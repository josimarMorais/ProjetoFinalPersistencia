package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.AgendaDAO;
import negocio.Agenda;

public class ListarAgendas extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AgendaDAO adao = new AgendaDAO();
		
		List<Agenda> agendas = adao.listar();
		
		request.setAttribute("agendas", agendas);
		RequestDispatcher rd = request.getRequestDispatcher("listaragendas.jsp");
		rd.forward(request, response);
	}

}
