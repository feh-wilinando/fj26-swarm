package br.com.caelum.uberdist.beans;

import br.com.caelum.uberdist.dao.Dao;
import br.com.caelum.uberdist.modelo.Produto;
import br.com.caelum.uberdist.tx.Transactional;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;


/**
 * Created by nando on 13/02/17.
 */
@Model
public class ProdutoBean {

    @Inject
    private Dao<Produto> dao;
    private Produto produto = new Produto();
    private List<Produto> produtos;


    @Transactional
    public void gravar(){
        if (produto.getId() == null) {
            dao.adiciona(produto);
        } else {
            dao.atualiza(produto);
        }

        produtos = dao.listaTodos();
        produto = new Produto();
    }


    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos(){
        if (produtos == null){
            System.out.println("carregando produtos...");
            produtos = dao.listaTodos();
        }

        return produtos;
    }

    @Transactional
    public void remove(Produto produto) {
        produtos.remove(produto);
        dao.remove(produto);
    }

    public void cancelar() {
        produto = new Produto();
    }
}
