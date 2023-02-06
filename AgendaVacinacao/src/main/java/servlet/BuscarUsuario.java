package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.UsuarioDAO;
import negocio.Alergia;
import negocio.Usuario;

public class BuscarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("txtNome");
		
		UsuarioDAO asdao = new UsuarioDAO();
		
		List<Usuario> usuarios = asdao.buscarPorNome(nome);
		
		List<Alergia> alergias = new ArrayList<>();
		
		for(Usuario u : usuarios) {
			alergias = u.getAlergias();
		}
		
		request.setAttribute("usuarios", usuarios);
		request.setAttribute("alergias", alergias);
		RequestDispatcher rd = request.getRequestDispatcher("listarbuscausuario.jsp");
		rd.forward(request, response);		

		
	}

}
