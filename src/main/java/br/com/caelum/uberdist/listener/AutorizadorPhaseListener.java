package br.com.caelum.uberdist.listener;

import br.com.caelum.uberdist.beans.UsuarioLogadoBean;

import javax.faces.application.ConfigurableNavigationHandlerWrapper;
import javax.faces.application.NavigationHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

/**
 * Created by nando on 16/02/17.
 */
public class AutorizadorPhaseListener implements PhaseListener {


    @Inject
    private UsuarioLogadoBean usuarioLogado;

    @Inject
    private FacesContext context;

    @Inject
    private NavigationHandler handler;

    @Override
    public void afterPhase(PhaseEvent phaseEvent) {


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

    @Override
    public void beforePhase(PhaseEvent phaseEvent) {

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}
