/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitirmeprojesi.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bitirmeprojesi.entity.Teacher;
import org.bitirmeprojesi.service.TeacherOperationsDAOImplService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;

/**
 *
 * @author Batuhan
 */
@ManagedBean(name = "loginController")
@SessionScoped
public class LoginControllerBean implements Serializable {

    private Teacher teacher = new Teacher();
    private Teacher willFindTeacher = new Teacher();

    @EJB
    TeacherOperationsDAOImplService teacherOperationsDAOImplService;

    public String doLogin() {
        try {

            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
                    .getRequestDispatcher("/j_spring_security_check");

            willFindTeacher = teacherOperationsDAOImplService.
                    findTeacherByLoginNumberFromService(teacher.getTeacherLoginNumber());

            dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
            FacesContext.getCurrentInstance().responseComplete();
            return null;

        } catch (ServletException | IOException ex) {
            System.out.println("Hata:" + ex.getMessage());

        }
        return null;
    }

    //Eğer kullanıcı henüz yetkilendirilmediyse anonymousUser'dır ve yönlendirileceği sayfayı veriyoruz.
    public void authorizedUserControl() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if (roles.contains("ROLE_ADMIN")) {
            NavigationHandler nh = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
            nh.handleNavigation(FacesContext.getCurrentInstance(), null, "/template/admin_template.xhtml?faces-redirect=true");

        } else if (roles.contains("ROLE_TEACHER")) {
            NavigationHandler nh = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
            nh.handleNavigation(FacesContext.getCurrentInstance(), null, "/template/main_template.xhtml?faces-redirect=true");
        }
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getWillFindTeacher() {
        return willFindTeacher;
    }

    public void setWillFindTeacher(Teacher willFindTeacher) {
        this.willFindTeacher = willFindTeacher;
    }

}
