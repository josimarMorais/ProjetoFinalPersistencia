package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.VacinaDAO;
import negocio.Vacina;


public class IncluirVacina extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titulo    	 = request.getParameter("txtTitulo");
		String descricao 	 = request.getParameter("TextDescricao");
		int    doses 	 	 = Integer.parseInt(request.getParameter("txtDoses"));
		int	   periodicidade = Integer.parseInt(request.getParameter("SelPeriodicidade"));
		int	   intervalo 	 = Integer.parseInt(request.getParameter("txtIntervalo"));
		
		
		System.out.println("Titulo:    " + titulo);
		System.out.println("Descricao: " + descricao);
		System.out.println("Doses: " + doses);
		System.out.println("Periodicidade: " + periodicidade);
		System.out.println("Intervalo: " + intervalo);
		
		
		Vacina novaVacina = new Vacina(titulo, descricao, doses, periodicidade, intervalo);
		
		VacinaDAO vdao = new VacinaDAO();
		
		vdao.incluirNovaVacina(novaVacina);
		
		response.sendRedirect("ListarVacinas");
		
		
	}

}
