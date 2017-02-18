package br.com.caelum.uberdist.beans;

import br.com.caelum.uberdist.modelo.NotaFiscal;
import org.primefaces.model.LazyDataModel;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 * Created by nando on 17/02/17.
 */
@Model
public class ListaNotaFiscalBean {


    @Inject
    private LazyDataModel<NotaFiscal> notasFiscais;

    public LazyDataModel<NotaFiscal> getNotasFiscais() {
        return notasFiscais;
    }
}
