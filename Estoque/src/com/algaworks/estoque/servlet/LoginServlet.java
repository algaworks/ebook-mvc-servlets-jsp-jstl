package com.algaworks.estoque.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/WEB-INF/paginas/login.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		if ("admin".equals(usuario) && "123".equals(senha)) {
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario);
			session.setAttribute("dataLogin", new Date());
			
			response.sendRedirect("consulta-produtos");
		} else {
			request.setAttribute("mensagem", "Usuário/senha inválidos.");
			doGet(request, response);
		}
	}
	
}