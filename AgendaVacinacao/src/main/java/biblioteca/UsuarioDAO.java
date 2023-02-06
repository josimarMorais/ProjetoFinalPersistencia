package biblioteca;

import java.util.List;

import javax.persistence.EntityManager;

import negocio.Alergia;
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
	
	
	public void excluirUsuarioById(int id) {
		Usuario user = em.find(Usuario.class, id);
		em.getTransaction().begin();
		em.remove(user);
		em.getTransaction().commit();
		
		System.out.println("ID Excluido: " + user.getId());		
	}
	
	
	public List<Usuario> listar(){
		String jpql = "SELECT u FROM Usuario u";
		return em.createQuery(jpql, Usuario.class).getResultList();
	}
	
	
	public List<Usuario> buscarPorNome(String nome){
		
		String jpql = "SELECT u FROM Usuario u WHERE u.nome = :nome";
		
		return em.createQuery(jpql, Usuario.class)
				.setParameter("nome", nome)
				.getResultList();
				
		
	}
	
}
