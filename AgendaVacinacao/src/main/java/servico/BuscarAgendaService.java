package servico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import biblioteca.AgendaDAO;
import negocio.Agenda;
import negocio.EnumTipo;

public class BuscarAgendaService {


	private LocalDate dataAtual;

	private AgendaDAO  agdao = new AgendaDAO();
	
	EnumTipo agendada  = EnumTipo.AGENDADA;
	EnumTipo realizada = EnumTipo.REALIZADA;
	EnumTipo cancelada = EnumTipo.CANCELADA;
	
	private List<Agenda> agendas         = new ArrayList<>();
	private List<Agenda> agendasOrdenada = new ArrayList<>();

	
	
	public List<Agenda> BuscarAgendasPorData() {

		dataAtual = LocalDate.now();

		agendas = agdao.buscarPorData(dataAtual);

		for (Agenda a : agendas) {
			if (a.getSituacao().equals(agendada)) {
				agendasOrdenada.add(a);
			}
		}

		for (Agenda a : agendas) {
			if (a.getSituacao().equals(realizada)) {
				agendasOrdenada.add(a);
			}
		}

		for (Agenda a : agendas) {
			if (a.getSituacao().equals(cancelada)) {
				agendasOrdenada.add(a);
			}
		}

		return agendasOrdenada;
	}
	
	
	
	public List<Agenda> BuscarAgendasPorUsuario(Integer id){
		agendas = agdao.listar();
		
		for(Agenda a : agendas) {
			if(a.getUsuario().getId() == id) {
				agendasOrdenada.add(a);
			}
		}
		return agendasOrdenada;
	}
}



