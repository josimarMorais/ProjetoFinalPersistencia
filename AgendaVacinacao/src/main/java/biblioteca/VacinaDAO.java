package biblioteca;

import java.util.List;

import javax.persistence.EntityManager;

import negocio.Vacina;

public class VacinaDAO {
	
	EntityManager em = FabricaDeConexao.Obterconexao();
	
	public void incluirNovaVacina(Vacina novaVacina) {
		
		em.getTransaction().begin();
		em.persist(novaVacina);
		em.getTransaction().commit();
		
		System.out.println("ID criado: " + novaVacina.getId());
		
		FabricaDeConexao.fecharConexao(em);
	}
	
	
	public List<Vacina> listar(){
		
		String jpql = "SELECT v FROM Vacina v";
		return em.createQuery(jpql, Vacina.class).getResultList();
	}

}
