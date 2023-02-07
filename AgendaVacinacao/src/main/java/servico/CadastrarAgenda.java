package servico;

import biblioteca.AgendaDAO;
import negocio.Agenda;

public class CadastrarAgenda {
	
	Agenda agenda   = new Agenda();
	AgendaDAO agdao = new AgendaDAO();
	
	
	public void criarAgendas(Agenda agenda) {
		
		int doses = agenda.getVacina().getDoses();
		
		for(int i = 0; i < doses; i++) {
			
			System.out.println("VALOR DO I: " + i);
		}
		

		
		

		
		
		
		
	}
}
