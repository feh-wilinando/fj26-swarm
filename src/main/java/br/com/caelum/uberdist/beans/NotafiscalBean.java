package br.com.caelum.uberdist.beans;

import br.com.caelum.uberdist.dao.Dao;
import br.com.caelum.uberdist.dao.NotaFiscalDao;
import br.com.caelum.uberdist.dao.ProdutoDao;
import br.com.caelum.uberdist.modelo.Item;
import br.com.caelum.uberdist.modelo.NotaFiscal;
import br.com.caelum.uberdist.modelo.Produto;
import br.com.caelum.uberdist.tx.Transactional;
import br.com.caelum.uberdist.util.ViewModel;

import javax.annotation.PostConstruct;
import javax.el.MethodExpression;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nando on 17/02/17.
 */
@ViewModel
public class NotafiscalBean implements Serializable{

    @Inject
    private Dao<NotaFiscal> notaFiscalDao;

    @Inject
    private Dao<Produto> produtoDao;

    private Item item = new Item();
    private NotaFiscal notafiscal = new NotaFiscal();
    private Long idProdutoSelecionado;
    private List<Produto> produtos;
    private MethodExpression completeProduto;

    @PostConstruct
    public void postConstruct() {
        this.produtos = produtoDao.listaTodos();
    }

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


    public void adicionarItem() {

        Produto produto = produtoDao.buscaPorId(idProdutoSelecionado);

        item.setNotaFiscal(notafiscal);
        item.setProduto(produto);
        item.setValorUnitario(produto.getPreco());

        notafiscal.getItens().add(item);

        idProdutoSelecionado = null;
        item = new Item();

    }

    @Transactional
    public String  gravar() {
        notaFiscalDao.adiciona(notafiscal);

        return "notafiscal?faces-redirect=true";
    }

    public List<Produto> autoCompletar(String nome) {
        return produtos
                .stream()
                    .filter(p -> p.getNome().toLowerCase().contains(nome.toLowerCase()))
                        .collect(Collectors.toList());
    }
}
