package br.com.caelum.uberdist.listener;

import br.com.caelum.uberdist.modelo.Usuario;

import javax.enterprise.event.Observes;

/**
 * Created by nando on 17/02/17.
 */
public class LoginListener {

    public void onLogin(@Observes Usuario usuario){
        System.out.println("\n[EVENT] - LOGIN: " + usuario.getLogin() + " entrou no sistema!\n");
    }
}
