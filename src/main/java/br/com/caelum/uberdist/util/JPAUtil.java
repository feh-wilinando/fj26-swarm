package br.com.caelum.uberdist.util;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nando on 13/02/17.
 */
@ApplicationScoped
public class JPAUtil {

    private static EntityManagerFactory factory;


    @PostConstruct
    public void onLoad(){

        Map<String, String> properties = new HashMap<>();
        Map<String, String> env = System.getenv();

        String dbHost = env.getOrDefault("DB_HOST", "localhost");
        String dbPort = env.getOrDefault("DB_PORT", "3306");
        String dbName = env.getOrDefault("DB_NAME", "fj26");
        String dbUser = env.getOrDefault("DB_USER", "root");
        String dbPassword = env.getOrDefault("DB_PASSWORD", "");


        String connectionString = String.format("jdbc:mysql://%s:%s/%s", dbHost, dbPort, dbName);

        properties.put("javax.persistence.jdbc.url", connectionString);
        properties.put("javax.persistence.jdbc.user", dbUser);
        properties.put("javax.persistence.jdbc.password", dbPassword);

        factory = Persistence.createEntityManagerFactory("notas", properties);

    }

    @Produces
    @RequestScoped
    public EntityManager getEntityManager(){
        return factory.createEntityManager();
    }

    public void close(@Disposes  EntityManager em){
        em.close();
    }

}
