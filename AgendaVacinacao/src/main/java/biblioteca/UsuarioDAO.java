package biblioteca;

import java.util.List;

import javax.persistence.EntityManager;

import negocio.Usuario;

public class UsuarioDAO {
		
	EntityManager em = FabricaDeConexao.Obterconexao();
	
	public void incluirNovoUsuario(Usuario novoUsuario) {
		em.getTransaction().begin();
		em.persist(novoUsuario);
		em.getTransaction().commit();
		
		System.out.println("ID criado: " + novoUsuario.getId());
		
	}
	
	
	public void excluirUsuarioById(int id) {
		
		try {
			em.getTransaction().begin();
			Usuario user = em.find(Usuario.class, id);
			em.remove(user);
			em.getTransaction().commit();
			System.out.println("ID Excluido: " + user.getId());		
		} catch (Exception e) {
			System.out.println("Nâo pode deletar pois tem dependência com outro objeto.");
		}

		
	}
	
	
	public List<Usuario> listar(){
		String jpql = "SELECT u FROM Usuario u ORDER BY u.nome";
		return em.createQuery(jpql, Usuario.class).getResultList();
	}
	
	public Usuario buscarPorID(int id) {
		return em.find(Usuario.class, id);
		
	}
	
	public List<Usuario> buscarPorNome(String nome){
		
		String jpql = "SELECT u FROM Usuario u WHERE u.nome = :nome";
		
		return em.createQuery(jpql, Usuario.class)
				.setParameter("nome", nome)
				.getResultList();
	}
}
