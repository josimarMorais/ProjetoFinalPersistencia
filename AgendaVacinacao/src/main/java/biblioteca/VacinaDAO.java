package biblioteca;

import java.util.List;

import javax.persistence.EntityManager;

import negocio.Vacina;

public class VacinaDAO {
	
	private Vacina vacina;
	
	static EntityManager em = FabricaDeConexao.Obterconexao();
	
	public void incluirNovaVacina(Vacina novaVacina) {
		em.getTransaction().begin();
		em.persist(novaVacina);
		em.getTransaction().commit();
		System.out.println("ID criado: " + novaVacina.getId());
		
	}
	
	public void excluirVacinaById(int id) {
		try {
			em.getTransaction().begin();
			vacina = em.find(Vacina.class, id);
			em.remove(vacina);
			em.getTransaction().commit();
			System.out.println("ID Excluido: " + vacina.getId());		
			
		} catch (Exception e) {
			System.out.println("Nâo pode deletar pois tem dependência com outro objeto.");
		}

		
		
	}
	
	public List<Vacina> listar(){
		String jpql = "SELECT v FROM Vacina v ORDER BY v.titulo";
		return em.createQuery(jpql, Vacina.class).getResultList();
	}
	
	
	public Vacina buscarPorID(int id) {
		return em.find(Vacina.class, id);
	}
	
	
	public List<Vacina> buscarPorTitulo(String titulo){	
		String jpql = "SELECT v FROM Vacina v WHERE v.titulo = :titulo";
		return em.createQuery(jpql, Vacina.class).setParameter("titulo", titulo).getResultList();
	}

}
