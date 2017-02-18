package br.com.caelum.uberdist.lazydatamodel;

import br.com.caelum.uberdist.dao.Dao;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import java.util.List;
import java.util.Map;

/**
 * Created by nando on 17/02/17.
 */
public class LazyDataModelGenerico<T> extends LazyDataModel<T> {


    private Dao<T> dao;
    private DataTable dataTable;



    public LazyDataModelGenerico(Dao<T> dao){
        this.dao = dao;

        super.setRowCount(dao.contaTodos());
    }

    @Override
    public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        return dao.listaTodosPaginada(first, pageSize);
    }

    public DataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(DataTable dataTable) {
        this.dataTable = dataTable;
    }

    public void refresh(){
        dataTable.loadLazyData();
    }
}
