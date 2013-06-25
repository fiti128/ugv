package rw.ugv.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.component.layout.LayoutUnit;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.ResizeEvent;
import org.primefaces.event.ToggleEvent;

@Named
@ApplicationScoped
public class LayoutBean {
                
        public void handleClose(CloseEvent event) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Unit Closed", "Position:'" + ((LayoutUnit)event.getComponent()).getPosition() + "'");
                
                addMessage(message);
        }
        
        public void handleToggle(ToggleEvent event) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, ((LayoutUnit)event.getComponent()).getPosition() + " toggled", "Status:" + event.getVisibility().name());
                
                addMessage(message);
        }
        
        public void handleResize(ResizeEvent event) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, ((LayoutUnit)event.getComponent()).getPosition() + " resized", "Width:" + event.getWidth() + ", Height:" + event.getHeight());
                
                addMessage(message);
        }
        
        private void addMessage(FacesMessage message) {
                FacesContext.getCurrentInstance().addMessage(null, message);
        }
}
