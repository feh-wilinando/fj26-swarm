package br.com.caelum.uberdist.beans;

import br.com.caelum.uberdist.dao.UsuarioDao;
import br.com.caelum.uberdist.modelo.Usuario;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by nando on 15/02/17.
 */
@Named
@SessionScoped
public class LoginBean implements Serializable {

    @Inject
    private UsuarioDao dao;

    private Usuario usuario = new Usuario();


    public String efetuaLogin(){

        if (dao.existe(usuario)){
            return "produto?faces-redirect=true";
        }else {
            return "login";
        }

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
