package biblioteca;

import java.util.List;

import javax.persistence.EntityManager;

import negocio.Agenda;

public class AgendaDAO {
	
	EntityManager em = FabricaDeConexao.Obterconexao();

	public void incluirNovaAgenda( Agenda novaAgenda) {
		
		em.getTransaction().begin();
		em.persist(novaAgenda);
		em.getTransaction().commit();
		
		System.out.println("ID criado: " + novaAgenda.getId());
		
		FabricaDeConexao.fecharConexao(em);
	}
	
	
	public List<Agenda> listar(){
		
		String jpql = "SELECT a FROM Agenda a";
		return em.createQuery(jpql, Agenda.class).getResultList();
	}
	
}
