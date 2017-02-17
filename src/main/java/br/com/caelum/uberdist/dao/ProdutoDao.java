package br.com.caelum.uberdist.dao;

import br.com.caelum.uberdist.modelo.Produto;
import br.com.caelum.uberdist.util.JPAUtil;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;



public class ProdutoDao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public void adiciona(Produto produto) {
		//persiste o objeto
		manager.persist(produto);
	}


	public void remove(Produto produto) {

		manager.remove(manager.merge(produto));

	}

	public void atualiza(Produto produto) {

		manager.merge(produto);
		
	}

	public List<Produto> buscaPorNome(String nome) {


		String jpql = "select p from Produto p where "
				+ " lower(p.nome) like :nome order by p.nome";

		List<Produto> lista = manager.createQuery(jpql, Produto.class)
				.setParameter("nome", nome + "%").getResultList();


		return lista; 
	}

	public List<Produto> listaTodos() {

		CriteriaQuery<Produto> query = manager.getCriteriaBuilder().createQuery(Produto.class);
		query.select(query.from(Produto.class));

		List<Produto> lista = manager.createQuery(query).getResultList();


		return lista; 
	}
	
	public Produto buscaPorId(Long id) {

		Produto produto = manager.find(Produto.class, id);

		return produto;
	}
}