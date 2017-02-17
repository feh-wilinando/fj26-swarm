package br.com.caelum.uberdist.beans;

import br.com.caelum.uberdist.dao.UsuarioDao;
import br.com.caelum.uberdist.modelo.Usuario;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.stream.Stream;

/**
 * Created by nando on 15/02/17.
 */
@Named
@RequestScoped
public class LoginBean {

    @Inject
    private UsuarioDao dao;

    @Inject
    private Event<Usuario> event;

    @Inject
    private UsuarioLogadoBean usuairoLogado;

    private Usuario usuario = new Usuario();

    @Inject @Any
    private Instance<String> emails;


    public String efetuaLogin(){

        if (dao.existe(usuario)){
            event.fire(usuario);
            usuairoLogado.logar(usuario);

            emails.forEach(System.out::println);

            return "produto?faces-redirect=true";
        }else {
            return "login";
        }

    }

    public String logout(){
        usuairoLogado.deslogar();
        return "login?faces-redirect=true";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
