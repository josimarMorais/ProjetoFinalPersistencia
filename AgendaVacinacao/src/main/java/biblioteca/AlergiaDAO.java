package biblioteca;

import java.util.List;

import javax.persistence.EntityManager;

import negocio.Alergia;

public class AlergiaDAO {
	
	EntityManager em = FabricaDeConexao.Obterconexao();
	
	
	public void incluirNovaAlergia(Alergia novaAlergia) {
	
		em.getTransaction().begin();
		em.persist(novaAlergia);
		em.getTransaction().commit();
		
		System.out.println("ID criado: " + novaAlergia.getId());
		
		FabricaDeConexao.fecharConexao(em);
		
	}
	
	public List<Alergia> listar(){
		
		String jpql = "SELECT a FROM Alergia a";
		return em.createQuery(jpql, Alergia.class).getResultList();
		
	}
	
}