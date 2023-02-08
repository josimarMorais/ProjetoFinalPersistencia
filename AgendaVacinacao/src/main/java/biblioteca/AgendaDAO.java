package biblioteca;

import java.util.List;

import javax.persistence.EntityManager;

import negocio.Agenda;
import negocio.EnumTipo;

public class AgendaDAO {
	
	private Agenda agenda;
	
	EntityManager em = FabricaDeConexao.Obterconexao();

	public void incluirNovaAgenda( Agenda novaAgenda) {
		
		em.getTransaction().begin();
		em.persist(novaAgenda);
		em.getTransaction().commit();
		
		System.out.println("ID criado: " + novaAgenda.getId());
		
	}
	
	
	
	public void excluirAgendaById(int id) {	
		agenda = em.find(Agenda.class, id);
		
		em.getTransaction().begin();
		em.remove(agenda);
		em.getTransaction().commit();
		
		System.out.println("ID Excluido: " + agenda.getId());
	}	
	
	
	
	public List<Agenda> listar(){
		String jpql = "SELECT a FROM Agenda a";
		return em.createQuery(jpql, Agenda.class).getResultList();
	}
	
	
	
	public void AtualizarAgenda(Agenda agenda) {
		em.getTransaction().begin();
		em.merge(agenda);
		em.getTransaction().commit();
	}
	
	
	
	public Agenda buscarPorID(Integer id) {
		return em.find(Agenda.class, id);
	}
	
	
	
	public List<Agenda> buscarPorEnumTipo(String filtro) {
		EnumTipo tipo = EnumTipo.valueOf(filtro);
		String jpql = "SELECT a FROM Agenda a WHERE a.situacao = :tipo";
		
		return em.createQuery(jpql, Agenda.class).setParameter("tipo", tipo).getResultList();
	}
	
}
