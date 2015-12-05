/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitirmeprojesi.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import org.bitirmeprojesi.dao.SchoolInsertDAO;
import org.bitirmeprojesi.dto.DTO;
import org.bitirmeprojesi.entity.School;

/**
 *
 * @author Batuhan
 */
@Stateless
public class SchoolInsertDAOImplService {

    @Inject
    private @Named("schoolInsertDAO")
    transient SchoolInsertDAO schoolInsertDAO;

    public DTO insertSchoolFromService(School school) {
        DTO dto = schoolInsertDAO.insertSchool(school);
        if(dto.isSuccess()){
            return dto;
        }else{
            dto.setMessage("Fail");
            dto.setSuccess(false);
            return dto;
        }
    }
    
    public List<School> getSchoolListFromService(){
        List<School> schoolList = new ArrayList<School>();
        schoolList = schoolInsertDAO.getSchoolList();
        if(schoolList!=null){
            return schoolList;
        }else{
            return schoolList;
        }
    }
}
