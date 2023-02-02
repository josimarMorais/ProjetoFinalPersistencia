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
		
		FabricaDeConexao.fecharConexao(em);
	}
	
	
	public List<Usuario> listar(){
		
		String jpql = "SELECT u FROM Usuario u";
		return em.createQuery(jpql, Usuario.class).getResultList();
	}

}
