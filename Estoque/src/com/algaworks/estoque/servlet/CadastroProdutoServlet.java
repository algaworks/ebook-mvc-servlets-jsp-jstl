package com.algaworks.estoque.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algaworks.estoque.form.ProdutoForm;
import com.algaworks.estoque.model.Produto;
import com.algaworks.estoque.repository.Produtos;
import com.algaworks.estoque.service.CadastroProdutoService;
import com.algaworks.estoque.service.ServiceException;
import com.algaworks.estoque.util.JpaUtil;

@WebServlet("/cadastro-produto")
public class CadastroProdutoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/WEB-INF/paginas/cadastro-produto.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		
		ProdutoForm form = null;
		String mensagem = null;
		
		try {
			trx.begin();
			
			form = ProdutoForm.fromRequest(request);
			Produto produto = form.toProduto();
			
			CadastroProdutoService servico = new CadastroProdutoService(new Produtos(manager));
			servico.cadastrar(produto);
			
			form = null;
			mensagem = "Produto cadastrado com sucesso!";
			
			trx.commit();
		} catch (ServiceException e) {
			mensagem = e.getMessage();
		} finally {
			if (trx.isActive()) trx.rollback();
			manager.close();
		}
		
		request.setAttribute("mensagem", mensagem);
		request.setAttribute("form", form);
		
		doGet(request, response);
	}
	
}