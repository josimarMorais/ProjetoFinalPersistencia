package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.AgendaDAO;
import negocio.Agenda;

public class BuscarAgenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String buscar = request.getParameter("btnBuscar");
			
			AgendaDAO agdao = new AgendaDAO();
			List<Agenda> agendas = new ArrayList<>();
			
			
			switch (buscar) {
			case "CARREGAR":
				agendas = agdao.listar();
				break;
			
			case "REALIZADA":
				agendas = agdao.buscarPorEnumTipo(buscar);
				break;
				
			case "CANCELADA":
				agendas = agdao.buscarPorEnumTipo(buscar);
				break;
				
			case "DATA":
				
				break;
			case "USUARIO":
				
				break;

			default:
				
				break;
			}
			
			request.setAttribute("agendas", agendas);

			RequestDispatcher rd = request.getRequestDispatcher("listarbuscaagenda.jsp");
			rd.forward(request, response);
			
			
			response.sendRedirect("ListarAgendas");

		
	}

}
