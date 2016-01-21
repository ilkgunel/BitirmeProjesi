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
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.bitirmeprojesi.dto.DTO;
import org.bitirmeprojesi.entity.Student;
import org.bitirmeprojesi.entity.Teacher;
import org.bitirmeprojesi.service.StudentOperationsDAOImplService;
import org.bitirmeprojesi.service.TeacherOperationsDAOImplService;

/**
 *
 * @author Batuhan
 */
@ManagedBean(name = "studentControllerBean")
@ApplicationScoped
public class StudentControllerBean implements Serializable {

    private Student student = new Student();
    private List<Teacher> teacherList = new ArrayList<Teacher>();
    private List<Student> studentList = new ArrayList<Student>();

    @EJB
    StudentOperationsDAOImplService studentOperationsDAOImplService;

    @EJB    
    TeacherOperationsDAOImplService teacherOperationsDAOImplService;

    @PostConstruct
    public void init() {
        studentList = studentOperationsDAOImplService.getStudentsFromService();
        
        teacherList = teacherOperationsDAOImplService.getTeachersFromService();
    }

    public String insertStudentFromBean() {
        try {
            DTO control = studentOperationsDAOImplService.insertStudentFromService(student);
            if (control.isSuccess()) {
                student = new Student();
                setStudent(student);
                studentList = studentOperationsDAOImplService.getStudentsFromService();
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, control.getMessage(), null));
                return "";

            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, control.getMessage(), null));
                return "";
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getLocalizedMessage(), null));
        }
        return "";

    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

}
