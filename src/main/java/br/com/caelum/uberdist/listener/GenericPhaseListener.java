package br.com.caelum.uberdist.listener;

import br.com.caelum.uberdist.listener.annotations.After;
import br.com.caelum.uberdist.listener.annotations.Before;
import br.com.caelum.uberdist.listener.annotations.PhasesLiteral;

import javax.enterprise.event.Event;
import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;
import java.lang.annotation.Annotation;

/**
 * Created by nando on 21/02/17.
 */
public class GenericPhaseListener implements PhaseListener{

    @Inject
    private Event<PhaseEvent> event;
    private Annotation before = new AnnotationLiteral<Before>() {};
    private Annotation after = new AnnotationLiteral<After>() {};

    @Override
    public void afterPhase(PhaseEvent phaseEvent) {
        event
           .select(after)
           .select(new PhasesLiteral(phaseEvent.getPhaseId()))
           .fire(phaseEvent);
    }

    @Override
    public void beforePhase(PhaseEvent phaseEvent) {
        event
            .select(before)
            .select(new PhasesLiteral(phaseEvent.getPhaseId()))
            .fire(phaseEvent);
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
}
