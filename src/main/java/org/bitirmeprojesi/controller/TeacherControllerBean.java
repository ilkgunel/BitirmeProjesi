package org.bitirmeprojesi.controller;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.bitirmeprojesi.dto.DTO;
import org.bitirmeprojesi.entity.School;
import org.bitirmeprojesi.entity.Teacher;
import org.bitirmeprojesi.service.SchoolOperationsDAOImplService;
import org.bitirmeprojesi.service.TeacherOperationsDAOImplService;

/**
 *
 * @author İlkay
 */
@ManagedBean(name = "teacherControllerBean")
@SessionScoped
public class TeacherControllerBean implements Serializable {

    private List<Teacher> teacherList = new ArrayList<Teacher>();

    private Teacher teacher = new Teacher();

    public List<School> schoolList = new ArrayList<School>();

    @ManagedProperty(value = "#{teacherRoleDefinitionControllerBean}")
    TeacherRoleDefinitionControllerBean teacherRoleDefinitionControllerBean;

    @EJB
    SchoolOperationsDAOImplService schoolOperationsDAOImplService;

    @EJB
    TeacherOperationsDAOImplService teacherOperationsDAOImplService;

    @PostConstruct
    public void init() {
        schoolList = schoolOperationsDAOImplService.getSchoolListFromService();
        teacherList = teacherOperationsDAOImplService.getTeachersFromService();
    }

    public void setTeacherRoleDefinitionControllerBean(TeacherRoleDefinitionControllerBean teacherRoleDefinitionControllerBean) {
        this.teacherRoleDefinitionControllerBean = teacherRoleDefinitionControllerBean;
    }

    public String insertTeacherFromBean() throws ParseException {
      
        if(teacher.getTeacherEndDate()==null){
            teacher.setTeacherEndDate(new Date(0));
        }
        if(teacher.getTeacherEndDate().toString().equals("Thu Jan 01 00:00:00 EET 1970")){
            teacher.setEnabled(true);
        }else{
            teacher.setEnabled(false);
        }
        DTO dto = teacherOperationsDAOImplService.insertTeacherFromService(teacher);
        try {
            if (dto.isSuccess()) {
                teacher = new Teacher();
                setTeacher(teacher);
                teacherList = teacherOperationsDAOImplService.getTeachersFromService();
                teacherRoleDefinitionControllerBean.teacherList = teacherOperationsDAOImplService.getTeachersFromService();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, dto.getMessage(), null));
                return "";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, dto.getMessage(), null));
                return "";
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getLocalizedMessage(), null));
            return "";
        }
    }
    
    public List<SelectItem> getTeacherBranchList(){
        List<SelectItem> branchList = new ArrayList<SelectItem>();
        branchList.add(new SelectItem("Matematik","Matematik"));
        branchList.add(new SelectItem("Türkçe","Türkçe"));
        branchList.add(new SelectItem("Sosyal Bilgiler","Sosyal Bilgiler"));
        
        return branchList;
    }

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

    public List<School> getSchoolList() {
        return schoolList;
    }

    public void setSchoolList(List<School> schoolList) {
        this.schoolList = schoolList;
    }

}
