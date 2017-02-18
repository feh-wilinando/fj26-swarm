package br.com.caelum.uberdist.beans;

import br.com.caelum.uberdist.dao.Dao;
import br.com.caelum.uberdist.lazydatamodel.LazyDataModelGenerico;
import br.com.caelum.uberdist.modelo.Produto;
import br.com.caelum.uberdist.tx.Transactional;
import org.primefaces.model.LazyDataModel;

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

    @Inject
    private LazyDataModelGenerico<Produto> produtos;


    @Transactional
    public void gravar(){
        if (produto.getId() == null) {
            dao.adiciona(produto);
        } else {
            dao.atualiza(produto);
        }

        produto = new Produto();
    }


    public Produto getProduto() {
        produtos.refresh();
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public LazyDataModelGenerico<Produto> getProdutos(){
        return produtos;
    }

    @Transactional
    public void remove(Produto produto) {

        dao.remove(produto);
    }

    public void cancelar() {
        produto = new Produto();
    }
}
