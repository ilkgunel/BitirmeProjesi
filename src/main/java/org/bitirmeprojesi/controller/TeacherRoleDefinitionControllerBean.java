/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitirmeprojesi.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.bitirmeprojesi.dto.DTO;
import org.bitirmeprojesi.entity.Teacher;
import org.bitirmeprojesi.entity.Teacherroles;
import org.bitirmeprojesi.service.TeacherOperationsDAOImplService;
import org.bitirmeprojesi.service.TeacherRoleDefinitionsDAOImplService;

/**
 *
 * @author Batuhan
 */
@ManagedBean(name = "teacherRoleDefinitionControllerBean")
@SessionScoped
public class TeacherRoleDefinitionControllerBean implements Serializable {

    private Teacherroles teacherroles = new Teacherroles();
    private List<Teacherroles> teacherRoleList = new ArrayList<Teacherroles>();
    public List<Teacher> teacherList = new ArrayList<Teacher>();

    @EJB
    TeacherOperationsDAOImplService teacherOperationsDAOImplService;

    @EJB
    TeacherRoleDefinitionsDAOImplService teacherRoleDefinitionsDAOImplService;

    @PostConstruct
    public void init() {
        teacherList = teacherOperationsDAOImplService.getTeachersFromService();
        teacherRoleList = teacherRoleDefinitionsDAOImplService.getTeacherRoleListFromService();
    }

    public String addTeacherRoleFromBean() {
        DTO dto = teacherRoleDefinitionsDAOImplService.addTeacherRoleFromService(teacherroles);
        try {
            if (dto.isSuccess()) {
                teacherroles = new Teacherroles();
                setTeacherroles(teacherroles);
                teacherRoleList = teacherRoleDefinitionsDAOImplService.getTeacherRoleListFromService();
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, dto.getMessage(), null));
                return "";
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, dto.getMessage(), null));
                return "";
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getLocalizedMessage(), null));
            return "";
        }
    }

    public List<SelectItem> getRoleList() {
        List<SelectItem> roleList = new ArrayList<SelectItem>();
        roleList.add(new SelectItem("ROLE_ADMIN", "ADMIN"));
        roleList.add(new SelectItem("ROLE_TEACHER", "TEACHER"));

        return roleList;
    }

    public Teacherroles getTeacherroles() {
        return teacherroles;
    }

    public void setTeacherroles(Teacherroles teacherroles) {
        this.teacherroles = teacherroles;
    }

    public List<Teacherroles> getTeacherRoleList() {
        return teacherRoleList;
    }

    public void setTeacherRoleList(List<Teacherroles> teacherRoleList) {
        this.teacherRoleList = teacherRoleList;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

}
