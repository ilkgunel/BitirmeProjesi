/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bitirmeprojesi.daoImpl;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import org.bitirmeprojesi.dao.SchoolOperationsDAO;
import org.bitirmeprojesi.dto.DTO;
import org.bitirmeprojesi.entity.School;

/**
 *
 * @author Batuhan
 */
@Named("schoolOperationsDAO")
public class SchoolOperationsDAOImpl extends JPAService<School, Serializable> implements SchoolOperationsDAO{

    @Override
    public DTO insertSchool(School school) {
        this.create(school);
        return new DTO("Succes",true);
    }

    @Override
    public List<School> getSchoolList() {
        List<School> schoolList = this.readAll();
        if(schoolList!=null){
            return schoolList;
        }else{
            return schoolList;
        }
    }
    
    
}
