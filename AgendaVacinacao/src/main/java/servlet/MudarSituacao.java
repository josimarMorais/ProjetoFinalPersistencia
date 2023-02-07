package servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.AgendaDAO;
import negocio.Agenda;
import negocio.EnumTipo;

public class MudarSituacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String situacao = request.getParameter("txtRealizada");
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		EnumTipo EnumSituacao  = EnumTipo.valueOf(situacao);
		
		
		AgendaDAO agdao = new AgendaDAO();
		Agenda   agenda = new Agenda();
		
		agenda = agdao.buscarPorID(id);
		
		agenda.setSituacao(EnumSituacao);
		agenda.setDataSituacao(LocalDate.now());
		
		agdao.AtualizarAgenda(agenda);
		
		response.sendRedirect("ListarAgendas");
	}

}
