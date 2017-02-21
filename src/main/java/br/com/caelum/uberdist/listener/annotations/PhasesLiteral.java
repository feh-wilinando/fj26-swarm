package br.com.caelum.uberdist.listener.annotations;

import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseId;
import java.lang.annotation.Annotation;

/**
 * Created by nando on 21/02/17.
 */
public class PhasesLiteral extends AnnotationLiteral<Phase> implements Phase {

    private final PhaseId id;

    public PhasesLiteral(PhaseId phaseId) {
        id = phaseId;
    }

    @Override
    public Phases value() {
        return Phases.valueOf(id.getName());
    }
}
