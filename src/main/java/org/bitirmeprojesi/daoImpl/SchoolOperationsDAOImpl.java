/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitirmeprojesi.daoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import org.bitirmeprojesi.dao.SchoolOperationsDAO;
import org.bitirmeprojesi.dto.DTO;
import org.bitirmeprojesi.entity.School;

/**
 *
 * @author Batuhan
 */
@Named("schoolOperationsDAO")
public class SchoolOperationsDAOImpl extends JPAService<School, Serializable> implements SchoolOperationsDAO {

    @Override
    public DTO insertSchool(School school) {
        try {
            this.create(school);
        } catch (Exception ex) {
            Logger.getLogger(SchoolOperationsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return new DTO("Succes", true);
    }

    @Override
    public List<School> getSchoolList() {
        List<School> schoolList = new ArrayList<>();
        try {
            if (schoolList != null) {
                this.readAll();
                return schoolList;
            } else {
                return schoolList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return schoolList;
    }

}
