package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.VacinaDAO;
import negocio.Vacina;
import servico.CadastrarVacina;


public class IncluirVacina extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titulo    	 = request.getParameter("txtTitulo");
		String descricao 	 = request.getParameter("TextDescricao");
		int    doses 	 	 = Integer.parseInt(request.getParameter("txtDoses"));
		int	   periodicidade = Integer.parseInt(request.getParameter("SelPeriodicidade"));
		int	   intervalo 	 = Integer.parseInt(request.getParameter("txtIntervalo"));
		
		
//		System.out.println("Titulo:    " + titulo);
//		System.out.println("Descricao: " + descricao);
//		System.out.println("Doses: " + doses);
//		System.out.println("Periodicidade: " + periodicidade);
//		System.out.println("Intervalo: " + intervalo);
		
		
		Vacina novaVacina = new Vacina(titulo, descricao, doses, periodicidade, intervalo);
		
		CadastrarVacina cadastrarNovaVacina = new CadastrarVacina();
		
		int resultado = cadastrarNovaVacina.cadastrarNovaVacina(novaVacina);
		
		VacinaDAO vdao = new VacinaDAO();
		List<Vacina> vacinas = vdao.listar();
		
		request.setAttribute("vacinas", resultado);
		request.setAttribute("vacinas", vacinas);
		RequestDispatcher rd = request.getRequestDispatcher("listarvacinas.jsp");
		rd.forward(request, response);
	}

}
