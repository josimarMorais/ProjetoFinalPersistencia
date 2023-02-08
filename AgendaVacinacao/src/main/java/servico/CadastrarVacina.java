package servico;

import biblioteca.VacinaDAO;
import negocio.Vacina;

public class CadastrarVacina {
	
public int cadastrarNovaVacina(Vacina vacina) {
		
		int doses = vacina.getDoses();
		int periodicidade = vacina.getPeriocidade();
		int intervalo = vacina.getIntervalo();
		
		if(doses <= 0) {
			//Valor da dose inválido
			System.out.println("Valor da dose inválido!!!");
			return 0;
		}
		
		
		if(doses == 1 && periodicidade != 0) {
			System.out.println("Valor da periodicidade inválido!!!");
			return 1;
		}
		
		
		if(periodicidade <= 0 && doses > 1 ) {
			//valor da periodicidade inválido
			System.out.println("Valor da periodicidade inválido!!!");
			return 2;
		}
		
		
		if(doses == 1 && intervalo != 1) {
			System.out.println("Valor do intervalo inválido!!!");
			return 3;
		}
		
		
		if(intervalo <= 0){
			//valor do intervalo inválido
			System.out.println("Valor do intervalo inválido!!!");
			return 4;
			
		}
		
		VacinaDAO vdao = new VacinaDAO();
		vdao.incluirNovaVacina(vacina);
		return 5;
		
	}

}
