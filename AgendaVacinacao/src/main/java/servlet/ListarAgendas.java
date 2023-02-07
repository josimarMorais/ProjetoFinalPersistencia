package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.AgendaDAO;
import biblioteca.UsuarioDAO;
import biblioteca.VacinaDAO;
import negocio.Agenda;
import negocio.Usuario;
import negocio.Vacina;

public class ListarAgendas extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioDAO usdao = new UsuarioDAO();
		VacinaDAO  vadao = new VacinaDAO();
		AgendaDAO  agdao = new AgendaDAO();
		
		List<Usuario> usuarios = usdao.listar();
		List<Vacina>  vacinas  = vadao.listar();
		List<Agenda>  agendas  = agdao.listar();
		
		request.setAttribute("usuarios", usuarios);
		request.setAttribute("vacinas", vacinas);
		request.setAttribute("agendas", agendas);
		RequestDispatcher rd = request.getRequestDispatcher("listaragendas.jsp");
		rd.forward(request, response);
	}

}
