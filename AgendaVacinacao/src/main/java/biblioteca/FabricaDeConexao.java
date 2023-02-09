package biblioteca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaDeConexao {
	
	
	public static EntityManager Obterconexao() {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("usando-jpa");
		EntityManager em = fabrica.createEntityManager();
		return em;
		
	}
		
	public static void fecharConexao(EntityManager em) {
		em.close();
	}
}
