package br.com.caelum.uberdist.dao;

import br.com.caelum.uberdist.modelo.Usuario;
import br.com.caelum.uberdist.util.JPAUtil;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class UsuarioDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public boolean existe(Usuario usuario) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Query query = manager.createQuery("select u from Usuario u where u.login = :pLogin and u.senha = :pSenha")
						.setParameter("pLogin", usuario.getLogin())
						.setParameter("pSenha", usuario.getSenha());

		boolean encontrado = !query.getResultList().isEmpty();

		return encontrado;
	}
}