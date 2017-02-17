package br.com.caelum.uberdist.beans;

import br.com.caelum.uberdist.dao.Dao;
import br.com.caelum.uberdist.modelo.Item;
import br.com.caelum.uberdist.modelo.NotaFiscal;
import br.com.caelum.uberdist.modelo.Produto;
import br.com.caelum.uberdist.tx.Transactional;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nando on 17/02/17.
 */
@Named
@ConversationScoped
public class WizardNotaFiscalBean implements Serializable {

    @Inject
    private Conversation conversation;

    @Inject
    private Dao<NotaFiscal> notaFiscalDao;

    @Inject
    private Dao<Produto> produtoDao;

    private NotaFiscal notaFiscal = new NotaFiscal();
    private Item item = new Item();
    private Long idProdutoSelecionado;
    private List<Produto> produtos = new ArrayList<>();


    @PostConstruct
    private void postConstruct(){
        this.produtos = produtoDao.listaTodos();
    }

    public String  goToDetail() {

        if (conversation.isTransient()) conversation.begin();

        return "detail-wizard?faces-redirect=true";
    }


    public String goToWizard(){
        return "wizard?faces-redirect=true";
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
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
        return produtos;
    }

    public void adicionarItem() {

        Produto produto = produtoDao.buscaPorId(idProdutoSelecionado);
        item.setProduto(produto);
        item.setValorUnitario(produto.getPreco());

        item.setNotaFiscal(notaFiscal);

        notaFiscal.getItens().add(item);

        idProdutoSelecionado = null;
        item = new Item();

    }

    @Transactional
    public String  gravar() {
        notaFiscalDao.adiciona(notaFiscal);
        conversation.end();
        return "wizard?faces-redirect=true";
    }
}
