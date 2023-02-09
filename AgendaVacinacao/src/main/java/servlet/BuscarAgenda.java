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
import biblioteca.UsuarioDAO;
import negocio.Agenda;
import negocio.Usuario;
import servico.BuscarAgendaService;

public class BuscarAgenda extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String buscar = request.getParameter("btnBuscar");
		
		String txtId = request.getParameter("selUsuario");
		
		List<Agenda> agendas = new ArrayList<>();
		List<Usuario> usuarios = new ArrayList<>();
		AgendaDAO agdao = new AgendaDAO();
		UsuarioDAO usdao = new UsuarioDAO();
		BuscarAgendaService agendaService = new BuscarAgendaService();
			
			
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
				agendas = agendaService.BuscarAgendasPorData();
				break;
			case "USUARIO":
				Integer id = Integer.parseInt(txtId);
				agendas = agendaService.BuscarAgendasPorUsuario(id);
				break;

			default:
				
				break;
			}
			
			usuarios = usdao.listar();
			request.setAttribute("agendas", agendas);
			request.setAttribute("usuarios", usuarios);

			RequestDispatcher rd = request.getRequestDispatcher("listarbuscaagenda.jsp");
			rd.forward(request, response);
	}

}
