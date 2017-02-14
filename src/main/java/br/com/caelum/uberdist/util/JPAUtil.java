package br.com.caelum.uberdist.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by nando on 13/02/17.
 */
public class JPAUtil {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("notas");


    public EntityManager getEntityManager(){
        return factory.createEntityManager();
    }

}
