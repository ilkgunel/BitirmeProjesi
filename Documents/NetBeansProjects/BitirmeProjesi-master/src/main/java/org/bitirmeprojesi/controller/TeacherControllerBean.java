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

import org.bitirmeprojesi.dto.DTO;
import org.bitirmeprojesi.entity.Teacher;
import org.bitirmeprojesi.service.TeacherOperationsDAOImplService;


/**
 *
 * @author İlkay
 */

@ManagedBean
@SessionScoped
public class TeacherControllerBean implements Serializable{
    @EJB
    private TeacherOperationsDAOImplService teacherOperationsDAOImplService;

    private List<Teacher> teacherList = new ArrayList<>();
    
    private Teacher teacher = new Teacher();

    public Teacher getTeacher() {
            return teacher;
    }

    public void setTeacher(Teacher teacher) {
            this.teacher = teacher;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }
    
    @PostConstruct
    public void init()
    {
        teacherList=teacherOperationsDAOImplService.getTeachersFromService();
    }
    
    public String insertTeacherFromBean()
    {
        teacher.setEnabled(true);
        DTO dto = teacherOperationsDAOImplService.insertTeacherFromService(teacher);

        if(dto.isSuccess())
        {
            teacher = new Teacher();
            setTeacher(teacher);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, dto.getMessage(), null));
            return "";
        } 

        else 
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, dto.getMessage(), null));
            return "";
        }
    }
}
