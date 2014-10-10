package com.algaworks.estoque.service;

import java.math.BigDecimal;

import com.algaworks.estoque.model.Produto;
import com.algaworks.estoque.repository.Produtos;

public class CadastroProdutoService {

	private Produtos produtos;
	
	public CadastroProdutoService(Produtos produtos) {
		this.produtos = produtos;
	}
	
	public void cadastrar(Produto produto) throws ServiceException {
		validarProduto(produto);
		this.produtos.adicionar(produto);
	}

	private void validarProduto(Produto produto) throws ServiceException {
		if (produto.getNome() == null || produto.getNome().equals("")) {
			throw new ServiceException("Nome deve ser informado.");
		} else if (produto.getPrecoCusto() == null) {
			throw new ServiceException("Preço de custo deve ser informado.");
		} else if (produto.getQuantidadeEstoque() == null) {
			throw new ServiceException("Quantidade em estoque deve ser informada.");
		} else if (produto.getPrecoCusto().compareTo(BigDecimal.ZERO) < 0) {
			throw new ServiceException("Preço de custo deve ser maior que zero.");
		} else if (produto.getQuantidadeEstoque() < 0) {
			throw new ServiceException("Quantidade em estoque deve ser maior que zero.");
		}
	}
	
}