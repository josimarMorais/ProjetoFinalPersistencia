package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.UsuarioDAO;
import negocio.Usuario;

public class ListarUsuarios extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UsuarioDAO udao = new UsuarioDAO();
		
		List<Usuario> usuarios = udao.listar();
		
		request.setAttribute("usuarios", usuarios);
		RequestDispatcher rd = request.getRequestDispatcher("listarusuarios.jsp");
		rd.forward(request, response);
		
	}

}
