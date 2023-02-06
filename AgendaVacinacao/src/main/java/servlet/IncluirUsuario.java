package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.AlergiaDAO;
import biblioteca.UsuarioDAO;
import negocio.Alergia;
import negocio.Usuario;


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
		String alergia[]        = request.getParameterValues("checkAlergia");
		
		
		Character sexoC          = sexo.charAt(0);
		LocalDate dataNascimento  = LocalDate.parse(txtdataNascimento);
		
		
		Alergia ale = new Alergia();
		AlergiaDAO adao = new AlergiaDAO();
		List<Alergia> alergias = new ArrayList<>();
			
		Usuario novoUsuario = new Usuario(nome, dataNascimento, sexoC, Logradouro, numero, setor, cidade, estado);
		
		if(alergia != null) {
			for(int i = 0; i < alergia.length; i++) {
				int id = Integer.parseInt(alergia[i]);
				ale = adao.buscaPorId(id);
				alergias.add(ale);			
			}	
			novoUsuario.setAlergias(alergias);
		}
		
		UsuarioDAO udao = new UsuarioDAO();
		
		udao.incluirNovoUsuario(novoUsuario);

		response.sendRedirect("ListarUsuarios");

	}
}
