package br.com.caelum.uberdist.listener;

import br.com.caelum.uberdist.beans.UsuarioLogadoBean;
import br.com.caelum.uberdist.listener.annotations.After;
import br.com.caelum.uberdist.listener.annotations.Phase;

import javax.enterprise.event.Observes;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.inject.Inject;

/**
 * Created by nando on 16/02/17.
 */
public class AutorizadorListener {


    @Inject
    private UsuarioLogadoBean usuarioLogado;

    @Inject
    private FacesContext context;

    @Inject
    private NavigationHandler handler;

    public void avaliaLogin(@Observes @After @Phase(Phase.Phases.RESTORE_VIEW) PhaseEvent phaseEvent) {


        String pagina = context.getViewRoot().getViewId();

        if ("/login.xhtml".equals(pagina)){
            return;
        }

        if(usuarioLogado.isLogado()){
            return;
        }

        handler.handleNavigation(context, null, "login?faces-redirect=true");

        context.renderResponse();

    }


}
