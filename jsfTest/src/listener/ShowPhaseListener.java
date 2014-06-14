package listener;

import com.sun.faces.lifecycle.LifecycleImpl;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class ShowPhaseListener implements PhaseListener {
    @Override
    public void afterPhase(PhaseEvent phaseEvent) {
        String phaseName = phaseEvent.getPhaseId().toString();
        System.out.println("Before " + phaseName + " path=" + phaseEvent.getFacesContext().getExternalContext().getRequestServletPath());
    }

    @Override
    public void beforePhase(PhaseEvent phaseEvent) {
        String phaseName = phaseEvent.getPhaseId().toString();
        System.out.println("After " + phaseName + " path=" + phaseEvent.getFacesContext().getExternalContext().getRequestServletPath());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
}
