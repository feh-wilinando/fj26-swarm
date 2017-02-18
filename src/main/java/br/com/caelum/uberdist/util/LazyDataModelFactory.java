package br.com.caelum.uberdist.util;

import br.com.caelum.uberdist.dao.Dao;
import br.com.caelum.uberdist.lazydatamodel.LazyDataModelGenerico;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;

/**
 * Created by nando on 17/02/17.
 */
@ApplicationScoped
public class LazyDataModelFactory {


    @Produces
    public <T> LazyDataModelGenerico<T> factory(InjectionPoint point, EntityManager manager){

        ParameterizedType type = (ParameterizedType) point.getType();
        Class<T> classe = (Class<T>) type.getActualTypeArguments()[0];

        Dao<T> dao = new Dao<T>(classe, manager);

        return new LazyDataModelGenerico<>(dao);
    }

}
