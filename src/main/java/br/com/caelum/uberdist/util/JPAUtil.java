package br.com.caelum.uberdist.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by nando on 13/02/17.
 */
@ApplicationScoped
public class JPAUtil {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("notas");


    @Produces
    public EntityManager getEntityManager(){
        return factory.createEntityManager();
    }

    public void close(@Disposes  EntityManager em){
        em.close();
    }

}
