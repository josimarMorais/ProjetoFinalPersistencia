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

public class IncluirAgenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer idUsuario      = Integer.parseInt(request.getParameter("selUsuario"));
		Integer idVacina       = Integer.parseInt(request.getParameter("selVacina"));
		String  txtData   	   = request.getParameter("dateData");
		String  txtHora		   = request.getParameter("timeHora");
		String  observacoes    = request.getParameter("TextObservacoes");
		
		
		String  situacao       = "AGENDADO";
		LocalDate data         = LocalDate.parse(txtData);
		LocalTime hora         = LocalTime.parse(txtHora);
		EnumTipo EnumSituacao  = EnumTipo.valueOf(situacao);
		LocalDate dataSituação = null;
		
		//System.out.println("Id usuario:          " + txtIdUsuario);
		//System.out.println("Id Vacina: 		   " + txtIdVacina);
		//System.out.println("Situacao:      " + EnumSituacao);
		
		UsuarioDAO usdao = new UsuarioDAO();
		VacinaDAO  vadao = new VacinaDAO();
		AgendaDAO  agdao = new AgendaDAO();
		
		Usuario usuario = usdao.buscarPorID(idUsuario);
		Vacina  vacina  = vadao.buscarPorID(idVacina);
		
		
		Agenda agenda = new Agenda(data, hora, EnumSituacao, dataSituação, observacoes);
		agenda.setUsuario(usuario);
		agenda.setVacina(vacina);
		
				
		agdao.incluirNovaAgenda(agenda);
		
		response.sendRedirect("ListarAgendas");
	}

}
