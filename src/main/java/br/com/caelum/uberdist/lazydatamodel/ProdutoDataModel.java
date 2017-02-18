package br.com.caelum.uberdist.lazydatamodel;

import br.com.caelum.uberdist.dao.Dao;
import br.com.caelum.uberdist.modelo.Produto;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Vetoed;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Created by nando on 17/02/17.
 */
@Vetoed
public class ProdutoDataModel extends LazyDataModel<Produto> {

    @Inject
    private Dao<Produto> dao;

    @PostConstruct
    public void postConstruct(){
        super.setRowCount(dao.contaTodos());
    }

    @Override
    public List<Produto> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        return dao.listaTodosPaginada(first, pageSize);
    }
}
