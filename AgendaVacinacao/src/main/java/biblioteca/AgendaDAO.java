package biblioteca;

import java.util.List;

import javax.persistence.EntityManager;

import negocio.Agenda;

public class AgendaDAO {
	
	private Agenda agenda;
	EntityManager em = FabricaDeConexao.Obterconexao();

	public void incluirNovaAgenda( Agenda novaAgenda) {
		
		em.getTransaction().begin();
		em.persist(novaAgenda);
		em.getTransaction().commit();
		
		System.out.println("ID criado: " + novaAgenda.getId());
		
		FabricaDeConexao.fecharConexao(em);
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
	
	
}
