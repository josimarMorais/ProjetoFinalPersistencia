package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.AgendaDAO;
import negocio.Agenda;
import negocio.EnumTipo;

public class IncluirAgenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String txtData   	   = request.getParameter("dateData");
		String txtHora		   = request.getParameter("timeHora");
		String situacao	       = request.getParameter("SelSituacao");
		String observacoes     = request.getParameter("TextObservacoes");
		
		LocalDate data         = LocalDate.parse(txtData);
		LocalTime hora         = LocalTime.parse(txtHora);
		EnumTipo EnumSituacao  = EnumTipo.valueOf(situacao);
		
//		System.out.println("Data:          " + data);
//		System.out.println("Hora: 		   " + hora);
//		System.out.println("Situacao:      " + EnumSituacao);
//		System.out.println("Data Situacao: " + dataSituacao);
//		System.out.println("Observacoes:    " + observacoes);
		
		LocalDate dataSituação = null;
		
		
		Agenda agenda = new Agenda(data, hora, EnumSituacao, dataSituação, observacoes);
		AgendaDAO adao = new AgendaDAO();
				
		adao.incluirNovaAgenda(agenda);
		
		response.sendRedirect("ListarAgendas");
	}

}
