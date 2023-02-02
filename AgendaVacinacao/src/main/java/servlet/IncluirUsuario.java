package servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.UsuarioDAO;
import biblioteca.VacinaDAO;
import negocio.Usuario;
import negocio.Vacina;


public class IncluirUsuario extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome	    	     = request.getParameter("txtNome");
		String txtdataNascimento = request.getParameter("dateDataNascimento");
		String sexo 		     = request.getParameter("sexo");
		String Logradouro 	     = request.getParameter("txtLogradouro");
		Double numero	 	     = Double.parseDouble(request.getParameter("txtNumero"));
		String setor	 	     = request.getParameter("txtSetor");
		String cidade	 	     = request.getParameter("txtCidade");
		String estado	 	     = request.getParameter("selEstado");
		
		
		Character sexoC          = sexo.charAt(0);
		LocalDate dataNascimento  = LocalDate.parse(txtdataNascimento);
		
		
		System.out.println("Nome: " + nome);
		System.out.println("Data De Nascimento: " + dataNascimento);
		System.out.println("Sexo: " + sexoC);
		System.out.println("Logradouro: " + Logradouro);
		System.out.println("Número: " + numero);
		System.out.println("Setor: " + setor);
		System.out.println("Cidade: " + cidade);
		System.out.println("Estado: " + estado);
		
		Usuario novoUsuario = new Usuario(nome, dataNascimento, sexoC, Logradouro, numero, setor, cidade, estado);
		
		UsuarioDAO udao = new UsuarioDAO();
		
		udao.incluirNovoUsuario(novoUsuario);
		
		
		response.sendRedirect("ListarUsuarios");
		
		
	}

}
