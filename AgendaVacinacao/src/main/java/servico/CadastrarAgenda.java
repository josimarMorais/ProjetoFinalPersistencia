package servico;

import java.time.LocalDate;

import biblioteca.AgendaDAO;
import negocio.Agenda;

public class CadastrarAgenda {
	
	Agenda agenda   = new Agenda();
	AgendaDAO agdao = new AgendaDAO();
	
	
	
	public void criarAgendas(Agenda agenda) {
		
		int doses = agenda.getVacina().getDoses();
		int periodicidade = agenda.getVacina().getPeriocidade();
		int intervalo = agenda.getVacina().getIntervalo();
		LocalDate data = agenda.getData();
		
		int novoIntervalo = 0;
		
		agdao.incluirNovaAgenda(agenda);
		
		for(int i = 1; i < doses; i++) {
			
			System.out.println("DOSES: " + doses);
			
			novoIntervalo += intervalo;
			
			LocalDate novaData;
			novaData = calcularNovaData(data, novoIntervalo, periodicidade);
			
			Agenda agenda1 = new Agenda();
			
			agenda1.setData(novaData);
			agenda1.setHora(agenda.getHora());
			agenda1.setSituacao(agenda.getSituacao());
			agenda1.setDataSituacao(agenda.getDataSituacao());
			agenda1.setObservacoes(agenda.getObservacoes());
			agenda1.setUsuario(agenda.getUsuario());
			agenda1.setVacina(agenda.getVacina());
			
			
			agdao.incluirNovaAgenda(agenda1);
		}
	}
	

	public LocalDate calcularNovaData(LocalDate data, int novoIntervalo, int periodicidade) {
		
		LocalDate novaData;
		
		switch(periodicidade) {
			case 1: 
				novaData = data.plusDays(novoIntervalo);
				break;
			case 2: 
				novaData = data.plusWeeks(novoIntervalo);
				break;
			case 3:
				novaData = data.plusMonths(novoIntervalo);
				break;
			case 4:
				novaData = data.plusYears(novoIntervalo);
				break;
				
			default:
				novaData = data;
		}
		
		return novaData;
	}
}
