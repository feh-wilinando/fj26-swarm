package br.com.caelum.uberdist.beans;

import br.com.caelum.uberdist.dao.ProdutoDao;
import br.com.caelum.uberdist.modelo.Produto;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;


/**
 * Created by nando on 13/02/17.
 */
@Named
@RequestScoped
public class ProdutoBean {

    @Inject
    private ProdutoDao dao;
    private Produto produto = new Produto();
    private List<Produto> produtos;

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

    public void remove(Produto produto) {
        produtos.remove(produto);
        dao.remove(produto);
    }

    public void cancelar() {
        produto = new Produto();
    }
}
