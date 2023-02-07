package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.AgendaDAO;
import biblioteca.UsuarioDAO;
import biblioteca.VacinaDAO;
import negocio.Agenda;
import negocio.EnumTipo;
import negocio.Usuario;
import negocio.Vacina;
import servico.CadastrarAgenda;

public class IncluirAgenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CadastrarAgenda cadastrar = new CadastrarAgenda();
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer idUsuario      = Integer.parseInt(request.getParameter("selUsuario"));
		Integer idVacina       = Integer.parseInt(request.getParameter("selVacina"));
		String  txtData   	   = request.getParameter("dateData");
		String  txtHora		   = request.getParameter("timeHora");
		String  observacoes    = request.getParameter("TextObservacoes");
		
		
		String  situacao       = "AGENDADA";
		LocalDate data         = LocalDate.parse(txtData);
		LocalTime hora         = LocalTime.parse(txtHora);
		EnumTipo EnumSituacao  = EnumTipo.valueOf(situacao);
		LocalDate dataSituação = null;
		
		
		
		UsuarioDAO usdao = new UsuarioDAO();
		VacinaDAO  vadao = new VacinaDAO();
		AgendaDAO  agdao = new AgendaDAO();
		
		Usuario usuario = usdao.buscarPorID(idUsuario);
		Vacina  vacina  = vadao.buscarPorID(idVacina);
		
		
		Agenda agenda = new Agenda(data, hora, EnumSituacao, dataSituação, observacoes);
		agenda.setUsuario(usuario);
		agenda.setVacina(vacina);
		
		cadastrar.criarAgendas(agenda);
		
		agdao.incluirNovaAgenda(agenda);
		
		response.sendRedirect("ListarAgendas");
	}

}
