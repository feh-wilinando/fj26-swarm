package br.com.caelum.uberdist.tx;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by nando on 17/02/17.
 */

@Interceptor
@Transactional
public class GerenciadorDeTransacao implements Serializable {


    @Inject
    private EntityManager manager;

    @AroundInvoke
    public Object aroundInvoke(InvocationContext context) throws Exception{

        manager.getTransaction().begin();

        Object result = context.proceed();

        manager.getTransaction().commit();

        return result;
    }

}
