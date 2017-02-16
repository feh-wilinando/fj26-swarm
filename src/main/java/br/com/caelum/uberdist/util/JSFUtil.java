package br.com.caelum.uberdist.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;

/**
 * Created by nando on 16/02/17.
 */
@ApplicationScoped
public class JSFUtil {

    @Produces
    @RequestScoped
    public FacesContext getFacesContext(){
        return FacesContext.getCurrentInstance();
    }


    @Produces
    @RequestScoped
    public NavigationHandler getNavigationHandler(FacesContext context){
        return context.getApplication().getNavigationHandler();
    }

}
