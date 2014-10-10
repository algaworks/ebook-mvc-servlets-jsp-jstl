package com.algaworks.estoque.form;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import com.algaworks.estoque.model.Produto;
import com.algaworks.estoque.service.ServiceException;

public class ProdutoForm {

	private static final DecimalFormat DECIMAL_FORMAT;
	
	static {
		DECIMAL_FORMAT = (DecimalFormat) NumberFormat.getInstance(new Locale("pt", "BR"));
		DECIMAL_FORMAT.applyPattern("#0.00");
	}
	
	private String nome;
	private String preco;
	private String quantidade;
	
	public static ProdutoForm fromRequest(HttpServletRequest request) {
		ProdutoForm form = new ProdutoForm();
		form.setNome(request.getParameter("nome"));
		form.setPreco(request.getParameter("preco"));
		form.setQuantidade(request.getParameter("quantidade"));
		return form;
	}
	
	public Produto toProduto() throws ServiceException {
		Produto produto = new Produto();
		produto.setNome(this.getNome());
		
		try {
			if (this.getPreco() != null && !this.getPreco().equals("")) {
				produto.setPrecoCusto(new BigDecimal(DECIMAL_FORMAT.parse(
						this.getPreco()).doubleValue()));
			}
		} catch (ParseException e) {
			throw new ServiceException("Informe o preço de custo corretamente.");
		}
		
		try {
			if (this.getQuantidade() != null && !this.getQuantidade().equals("")) {
				produto.setQuantidadeEstoque(Integer.parseInt(this.getQuantidade()));
			}
		} catch (NumberFormatException e) {
			throw new ServiceException("Informe a quantidade em estoque corretamente.");
		}
		
		return produto;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	
}