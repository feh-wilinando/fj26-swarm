package br.com.caelum.uberdist.util;

import br.com.caelum.uberdist.dao.Dao;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;

/**
 * Created by nando on 17/02/17.
 */
@ApplicationScoped
public class DaoFactory{

    @Produces
    public <T> Dao<T> factory(InjectionPoint point, EntityManager manager){

        ParameterizedType type = (ParameterizedType) point.getType();

        Class<?> classe = (Class<?>) type.getActualTypeArguments()[0];
        return new Dao(classe, manager);
    }
}
