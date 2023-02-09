package biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import negocio.Agenda;
import negocio.EnumTipo;

public class AgendaDAO {
	
	private Agenda agenda;
	
	List<Agenda> agendas = new ArrayList<>();
	
	static EntityManager em = FabricaDeConexao.Obterconexao();
	
	public void incluirNovaAgenda( Agenda novaAgenda) {
		em.getTransaction().begin();
		em.persist(novaAgenda);
		em.getTransaction().commit();
	
		System.out.println("ID criado: " + novaAgenda.getId());
		
	}
	
	
	
	public void excluirAgendaById(int id) {
		
		em.getTransaction().begin();
		agenda = em.find(Agenda.class, id);
		em.remove(agenda);
		em.getTransaction().commit();
		System.out.println("ID Excluido: " + agenda.getId());
	}	
	
	
	
	public List<Agenda> listar(){
		String jpql = "SELECT a FROM Agenda a";
		agendas =  em.createQuery(jpql, Agenda.class).getResultList();
		return agendas;
	}
	
	
	
	public void AtualizarAgenda(Agenda agenda) {
		em.getTransaction().begin();
		em.merge(agenda);
		em.getTransaction().commit();
	}
	
	
	
	public Agenda buscarPorID(Integer id) {
		agenda = em.find(Agenda.class, id);	
		return agenda;
		
	}
	
	
	
	public List<Agenda> buscarPorEnumTipo(String filtro) {
		EnumTipo tipo = EnumTipo.valueOf(filtro);
		String jpql = "SELECT a FROM Agenda a WHERE a.situacao = :tipo";
		agendas = em.createQuery(jpql, Agenda.class).setParameter("tipo", tipo).getResultList();
		return agendas;
	}
	
	
	
	public List<Agenda> buscarPorData( LocalDate data){
		String jpql = "SELECT a FROM Agenda a WHERE a.data = :data";
		agendas = em.createQuery(jpql, Agenda.class).setParameter("data", data).getResultList();
		return agendas;
	}
}
