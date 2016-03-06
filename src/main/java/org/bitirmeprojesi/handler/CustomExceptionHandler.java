/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitirmeprojesi.handler;

import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import org.bitirmeprojesi.log.Logger;
import org.bitirmeprojesi.log.LoggerFactory;
import org.bitirmeprojesi.utils.JSFUtil;
import org.slf4j.Marker;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class CustomExceptionHandler extends ExceptionHandlerWrapper {

    private ExceptionHandler wrapped;
    private Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    public CustomExceptionHandler(ExceptionHandler exception) {
        this.wrapped = exception;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return wrapped;
    }

    @Override
    public void handle() throws FacesException {
        final Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents().iterator();

        while (i.hasNext()) {
            ExceptionQueuedEvent event = i.next();
            ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getContext();

            Throwable t = context.getException();

            final FacesContext fc = FacesContext.getCurrentInstance();
            final Map<String, Object> flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
            final ExternalContext ex = fc.getExternalContext();
            String actionUrl = "";
            String page = "";
            String message = "";
            try {
                logger.error("Exception catched in " + this.getClass().getSimpleName());

                if (t.getMessage() != null && t.getMessage().toString().startsWith("com.sun.faces.context.FacesFileNotFoundException")) {

                    page = "/error/404.xhtml?faces-redirect=true";
                    actionUrl = fc.getApplication().getViewHandler().getActionURL(fc, page);
                    message = t.getCause().toString();
                }

                if (t.getMessage() != null && t.getMessage().toString().startsWith("javax.faces.application.ViewExpiredException")) {
                    page = "../error/error.xhtml?faces-redirect=true";
                    actionUrl = fc.getApplication().getViewHandler().getActionURL(fc, page);
                    message = t.getCause().toString();
                }

                if (t.getMessage() != null && t.getMessage().toString().startsWith("java.lang.NullPointerException")) {
                    page = "../error/error.xhtml?faces-redirect=true";
                    actionUrl = fc.getApplication().getViewHandler().getActionURL(fc, page);
                    message = t.getCause().toString();
                }

                logger.info("Redirect page : " + page + " Error message : " + message);

                flash.put("errorMessage", message);
                ex.redirect(actionUrl);
                fc.renderResponse();
            } catch (Exception e) {
                logger.error("An error occured in " + this.getClass().getSimpleName() + ". Error :" + e);
            }
        }
        getWrapped().handle();
    }

}
