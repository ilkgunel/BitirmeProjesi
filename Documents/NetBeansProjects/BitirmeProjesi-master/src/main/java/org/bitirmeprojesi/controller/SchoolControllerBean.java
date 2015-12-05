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
import org.bitirmeprojesi.entity.School;
import org.bitirmeprojesi.service.SchoolInsertDAOImplService;

/**
 *
 * @author Batuhan
 */
@ManagedBean(name = "schoolControllerBean")
@SessionScoped
public class SchoolControllerBean implements Serializable {

    private School school = new School();
    private List<School> schoolList = new ArrayList<School>();
    List<SelectItem> schoolDistrictList = new ArrayList<SelectItem>();
    List<SelectItem> schoolNameList = new ArrayList<SelectItem>();
    @EJB
    SchoolInsertDAOImplService schoolInsertDAOImplService;

    @PostConstruct
    public void init() {
        schoolList = schoolInsertDAOImplService.getSchoolListFromService();
    }

    public String insertSchoolFromBean() {
        DTO dto = schoolInsertDAOImplService.insertSchoolFromService(school);
        if (dto.isSuccess()) {
            school = new School();
            setSchool(school);
            schoolList = schoolInsertDAOImplService.getSchoolListFromService();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, dto.getMessage(), null));
            return "/schoolWorks/schoolList.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, dto.getMessage(), null));
            return "";
        }
    }

    public List<SelectItem> getSchoolCityList() {
        List<SelectItem> schoolCityList = new ArrayList<SelectItem>();
        schoolCityList.add(new SelectItem("İstanbul", "İstanbul"));
        schoolCityList.add(new SelectItem("Ankara", "Ankara"));

        return schoolCityList;
    }

    public List<SelectItem> refreshSchoolDistrictList() {
        schoolDistrictList = new ArrayList<SelectItem>();
        if (school.getSchoolCity().equals("İstanbul")) {
            schoolDistrictList.add(new SelectItem("Avcılar", "Avcılar"));
            schoolDistrictList.add(new SelectItem("Beylikdüzü", "Beylikdüzü"));
        } else if (school.getSchoolCity().equals("Ankara")) {
            schoolDistrictList.add(new SelectItem("Kızılay", "Kızılay"));
            schoolDistrictList.add(new SelectItem("Keçiören", "Keçiören"));
        }
        return schoolDistrictList;
    }

    public List<SelectItem> refreshSchoolNameList() {
       schoolNameList = new ArrayList<SelectItem>();
        if (school.getSchoolDistrict().equals("Avcılar")) {
            schoolNameList.add(new SelectItem("Avcılar", "Avcılar Lisesi"));
            schoolNameList.add(new SelectItem("Avcılar", "Avcılar Anadolu Lisesi"));
        } else if (school.getSchoolDistrict().equals("Beylikdüzü")) {
            schoolNameList.add(new SelectItem("Beylikdüzü", "Beylikdüzü Lisesi"));
            schoolNameList.add(new SelectItem("Beylikdüzü", "Beylikdüzü Anadolu Lisesi"));
        } else if (school.getSchoolDistrict().equals("Kızılay")) {
            schoolNameList.add(new SelectItem("Kızılay", "Kızılay Lisesi"));
            schoolNameList.add(new SelectItem("Kızılay", "Kızılay Anadolu Lisesi"));
        }
        else if (school.getSchoolDistrict().equals("Keçiören")) {
            schoolNameList.add(new SelectItem("Keçiören", "Keçiören Lisesi"));
            schoolNameList.add(new SelectItem("Keçiören", "Keçiören Anadolu Lisesi"));
        }
        return schoolNameList;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<School> getSchoolList() {
        return schoolList;
    }

    public void setSchoolList(List<School> schoolList) {
        this.schoolList = schoolList;
    }

    public List<SelectItem> getSchoolDistrictList() {
        return schoolDistrictList;
    }

    public void setSchoolDistrictList(List<SelectItem> schoolDistrictList) {
        this.schoolDistrictList = schoolDistrictList;
    }

    public List<SelectItem> getSchoolNameList() {
        return schoolNameList;
    }

    public void setSchoolNameList(List<SelectItem> schoolNameList) {
        this.schoolNameList = schoolNameList;
    }
    
    

}
