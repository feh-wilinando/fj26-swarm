package br.com.caelum.uberdist.beans;

import br.com.caelum.uberdist.dao.NotaFiscalDao;
import br.com.caelum.uberdist.dao.ProdutoDao;
import br.com.caelum.uberdist.modelo.Item;
import br.com.caelum.uberdist.modelo.NotaFiscal;
import br.com.caelum.uberdist.modelo.Produto;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by nando on 17/02/17.
 */
@ViewScoped
@Named
public class NotafiscalBean implements Serializable{

    @Inject
    private NotaFiscalDao notaFiscalDao;

    @Inject
    private ProdutoDao produtoDao;

    private Item item = new Item();
    private NotaFiscal notafiscal = new NotaFiscal();
    private Long idProdutoSelecionado;
    private List<Produto> produtos;


    public NotaFiscal getNotafiscal() {
        return notafiscal;
    }

    public void setNotafiscal(NotaFiscal notafiscal) {
        this.notafiscal = notafiscal;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Long getIdProdutoSelecionado() {
        return idProdutoSelecionado;
    }

    public void setIdProdutoSelecionado(Long idProdutoSelecionado) {
        this.idProdutoSelecionado = idProdutoSelecionado;
    }

    public List<Produto> getProdutos() {

        if(produtos == null){
            produtos = produtoDao.listaTodos();
        }

        return produtos;
    }

    public void adicionarItem() {

        Produto produto = produtoDao.buscaPorId(idProdutoSelecionado);

        item.setNotaFiscal(notafiscal);
        item.setProduto(produto);
        item.setValorUnitario(produto.getPreco());

        notafiscal.getItens().add(item);

        idProdutoSelecionado = null;
        item = new Item();

    }

    public String  gravar() {
        notaFiscalDao.adiciona(notafiscal);

        return "notafiscal?faces-redirect=true";
    }
}
