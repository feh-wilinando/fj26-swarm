package br.com.caelum.uberdist.beans;

import br.com.caelum.uberdist.modelo.Usuario;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by nando on 15/02/17.
 */
@Named
@SessionScoped
public class UsuarioLogadoBean implements Serializable{

    private Usuario usuario;

    public void logar(Usuario usuario){
        this.usuario = usuario;
    }

    public void deslogar(){
        usuario = null;
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public boolean isLogado() {
        return usuario != null;
    }
}
