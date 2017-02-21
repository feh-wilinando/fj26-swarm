package br.com.caelum.uberdist.listener;

import br.com.caelum.uberdist.listener.annotations.After;

import javax.enterprise.event.Observes;
import javax.faces.event.PhaseEvent;

/**
 * Created by nando on 21/02/17.
 */
public class LogListener {

    public void log(@Observes @After PhaseEvent event){

        System.out.println("-------------["+event.getPhaseId()+"]-------------");

    }

}
