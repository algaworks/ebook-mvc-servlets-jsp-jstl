package com.algaworks.estoque.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algaworks.estoque.model.Produto;
import com.algaworks.estoque.repository.Produtos;
import com.algaworks.estoque.util.JpaUtil;

@WebServlet("/consulta-produtos")
public class ConsultaProdutosServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		EntityManager manager = JpaUtil.getEntityManager();
		Produtos produtos = new Produtos(manager);
		
		String nome = request.getParameter("nome");
		
		try {
			List<Produto> todosProdutos = produtos.porNomeNaoExato(nome);
			
			request.setAttribute("produtos", todosProdutos);
			request.setAttribute("agora", new Date());

			RequestDispatcher dispatcher = request.getRequestDispatcher(
					"/WEB-INF/paginas/consulta-produtos.jsp");
			dispatcher.forward(request, response);
		} finally {
			manager.close();
		}
	}

}