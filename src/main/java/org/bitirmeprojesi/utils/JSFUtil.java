/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitirmeprojesi.utils;

import com.sun.faces.component.visit.FullVisitContext;
import com.sun.faces.context.ApplicationMap;
import com.sun.faces.context.RequestMap;
import com.sun.faces.context.SessionMap;
import java.io.IOException;
import java.util.Map;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.component.visit.VisitCallback;
import javax.faces.component.visit.VisitContext;
import javax.faces.component.visit.VisitResult;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Batuhan
 */
public class JSFUtil {

    public static Object getBeanFromSession(String beanName) {
        Object o = null;
        if (!StringUtil.isNullOrEmpty(beanName)) {
            SessionMap sessionMap = getSessionMap();
            if (sessionMap != null && sessionMap.size() > 0) {
                o = sessionMap.get(beanName);
            }
            return o;
        }
        return o;
    }

    public static Object getBeanFromView(String beanName) {
        Object o = null;
        if (!StringUtil.isNullOrEmpty(beanName)) {
            Map<String, Object> viewMap = getViewMap();
            if (viewMap != null && viewMap.size() > 0) {
                o = viewMap.get(beanName);
            }
            return o;
        }
        return o;
    }

    public static Object getBeanFromApplication(String beanName) {
        Object o = null;
        if (!StringUtil.isNullOrEmpty(beanName)) {
            ApplicationMap applicationMap = getApplicationMap();
            if (applicationMap != null && applicationMap.size() > 0) {
                o = applicationMap.get(beanName);
            }
            return o;
        }
        return o;
    }

    public static Object getBeanFromRequest(String beanName) {
        Object o = null;
        if (!StringUtil.isNullOrEmpty(beanName)) {
            RequestMap requestMap = getRequestMap();
            if (requestMap != null && requestMap.size() > 0) {
                o = requestMap.get(beanName);
            }
            return o;
        }
        return o;
    }

    public static String getPageViewId() {
        String viewId = getFacesContext().getViewRoot().getViewId();
        if (!StringUtil.isNullOrEmpty(viewId)) {
            return viewId;
        }
        return viewId;
    }

    public static void redirectUsingNavigationHandler(String redirectPage) {
        try {
            if (!StringUtil.isNullOrEmpty(redirectPage)) {
                NavigationHandler navigationHandler = getFacesContext().getApplication().
                        getNavigationHandler();
                navigationHandler.handleNavigation(getFacesContext(), null, redirectPage + ".xhtml");
            }
        } catch (Exception e) {

        }

    }

    public static void redirectUsingHttpServletResponse(String redirectPage) {
        try {
            if (!StringUtil.isNullOrEmpty(redirectPage)) {
                HttpServletResponse response = (HttpServletResponse) getExternalContext().getResponse();
                response.sendRedirect(redirectPage + ".xhtml");
            }
        } catch (Exception e) {

        }
    }

    public static void redirectWithExternalContext(String redirectPage) {
        try {
            if (!StringUtil.isNullOrEmpty(redirectPage)) {
                ExternalContext context = getExternalContext();
                String actionUrl = context.encodeActionURL(getActionURL());
                context.redirect(actionUrl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String getActionURL() {
        String viewId = getPageViewId();
        String actionURL = "";
        if (!StringUtil.isNullOrEmpty(viewId)) {
            FacesContext context = getFacesContext();
            actionURL = context.getApplication().getViewHandler().getActionURL(context, viewId);
            if (!StringUtil.isNullOrEmpty(actionURL)) {
                return actionURL;
            }
        }
        return actionURL;
    }

    public static Object getAndRemoveFromSession(Object key) {
        SessionMap sessionMap = getSessionMap();
        Object o = null;
        if (sessionMap != null && sessionMap.size() > 0 && key != null) {
            o = sessionMap.get(key);
            if (o != null) {
                sessionMap.remove(o);
            }
        }
        return sessionMap.get(o);
    }

    public static Object getAndRemoveFromViewMap(Object key) {
        Map<String, Object> viewMap = getSessionMap();
        Object o = null;
        if (viewMap != null && viewMap.size() > 0 && key != null) {
            o = viewMap.get(key);
            if (o != null) {
                viewMap.remove(o);
            }
        }
        return viewMap.get(o);
    }

    public static Object getAndRemoveFromRequest(Object key) {
        RequestMap requestMap = getRequestMap();
        Object o = null;
        if (requestMap != null && requestMap.size() > 0 && key != null) {
            o = requestMap.get(key);
            if (o != null) {
                requestMap.remove(o);
            }
        }

        return requestMap.get(o);
    }

    public static Object getAndRemoveFromFlash(Object key) {
        Flash flash = getFlash();
        Object o = null;
        if (flash != null && flash.size() > 0 && key != null) {
            o = flash.get(key);
            if (o != null) {
                flash.remove(o);
            }
        }
        return flash.get(o);
    }

    public static Object getAndRemoveFromApplicationMap(Object key) {
        ApplicationMap applicationMap = getApplicationMap();
        Object o = null;
        if (applicationMap != null && applicationMap.size() > 0 && key != null) {
            o = applicationMap.get(key);
            if (o != null) {
                applicationMap.remove(o);
            }
        }
        return applicationMap.get(o);
    }

    public static UIComponent findComponentById(String id) {
        UIViewRoot root = getFacesContext().getViewRoot();
        final UIComponent[] component = new UIComponent[1];
        root.visitTree(new FullVisitContext(getFacesContext()), new VisitCallback() {

            @Override
            public VisitResult visit(VisitContext context, UIComponent target) {
                if (target.getId().equals(id)) {
                    component[0] = target;
                    return VisitResult.COMPLETE;
                }
                return VisitResult.ACCEPT;
            }
        });
        return component[0];
    }

    public static NavigationHandler getNavigationHandler() {
        return getApplication().getNavigationHandler();
    }

    public static SessionMap getSessionMap() {
        return (SessionMap) getFacesContext().getExternalContext().getSessionMap();
    }

    public static RequestMap getRequestMap() {
        return (RequestMap) getFacesContext().getExternalContext().getRequestMap();
    }

    public static ApplicationMap getApplicationMap() {
        return (ApplicationMap) getFacesContext().getExternalContext().getApplicationMap();
    }

    public static Map<String, Object> getViewMap() {
        return (Map<String, Object>) getFacesContext().getViewRoot().getViewMap();
    }

    public static Flash getFlash() {
        return getFacesContext().getExternalContext().getFlash();
    }

    public static void addInfoMessage(String message) {
        if (!StringUtil.isNullOrEmpty(message)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, message, null);
            getFacesContext().addMessage(null, msg);
        }
    }

    public static void addErrorMessage(String message) {
        if (!StringUtil.isNullOrEmpty(message)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null);
            getFacesContext().addMessage(null, msg);
        }
    }

    public static void addWarningMessage(String message) {
        if (!StringUtil.isNullOrEmpty(message)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, message, null);
            getFacesContext().addMessage(null, msg);
        }

    }

    public static Application getApplication() {
        return getFacesContext().getApplication();
    }

    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    public static ExternalContext getExternalContext() {
        return FacesContext.getCurrentInstance().getExternalContext();
    }

}
