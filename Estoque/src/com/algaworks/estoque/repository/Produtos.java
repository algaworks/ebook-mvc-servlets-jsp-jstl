package com.algaworks.estoque.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.algaworks.estoque.model.Produto;

public class Produtos {

	private EntityManager manager;
	
	public Produtos(EntityManager manager) {
		this.manager = manager;
	}
	
	public void adicionar(Produto produto) {
		this.manager.persist(produto);
	}
	
	public List<Produto> todos() {
		TypedQuery<Produto> query = manager.createQuery("from Produto", Produto.class);
		return query.getResultList();
	}
	
	public List<Produto> porNomeNaoExato(String nome) {
		TypedQuery<Produto> query = manager.createQuery(
				"from Produto where upper(nome) like upper(:nome)", Produto.class);
		query.setParameter("nome", "%" + (nome == null ? "" : nome) + "%");
		return query.getResultList();
	}
	
}