package biblioteca;

import java.util.List;

import javax.persistence.EntityManager;

import negocio.Alergia;

public class AlergiaDAO {
	
	private Alergia alergia;
	EntityManager em = FabricaDeConexao.Obterconexao();
	
	public void incluirNovaAlergia(Alergia novaAlergia) {
		em.getTransaction().begin();
		em.persist(novaAlergia);
		em.getTransaction().commit();
		
		System.out.println("ID criado: " + novaAlergia.getId());
		
		FabricaDeConexao.fecharConexao(em);
	}
	
	public void excluirAlergiaById(int id) {
		
		try {
			
			alergia = this.buscaPorId(id);
			em.getTransaction().begin();
			em.remove(alergia);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Nâo pode deletar pois tem dependência com outro objeto.");
		}

		
		System.out.println("ID Excluido: " + alergia.getId());
		
		
	}
	
	public List<Alergia> listar(){
		
		String jpql = "SELECT a FROM Alergia a";
		return em.createQuery(jpql, Alergia.class).getResultList();
		
	}
	
	public Alergia buscaPorId(int id) {
		
		return em.find(Alergia.class, id);
		
	}
	
	public List<Alergia> buscarPorNome(String nome) {
		
		String jpql = "SELECT a FROM Alergia a WHERE a.nome = :nome";
		
		return em.createQuery(jpql, Alergia.class)
				.setParameter("nome", nome)
				.getResultList();
	}
}