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
import org.bitirmeprojesi.dao.TestOperationsDAO;
import org.bitirmeprojesi.dto.DTO;
import org.bitirmeprojesi.entity.Test;

/**
 *
 * @author Batuhan
 */
@Named("testOperationsDAO")
public class TestOperationsDAOImpl extends JPAService<Test, Serializable> implements TestOperationsDAO {

    @Override
    public DTO insertTest(Test test) {
        try {
            this.create(test);
        } catch (Exception ex) {
            Logger.getLogger(TestOperationsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return new DTO("Success", true);
    }

    @Override
    public List<Test> getTestList() {
        List<Test> testList = new ArrayList<Test>();
        try {
            testList = this.readAll();
            if (testList != null) {
                return testList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testList;
    }

    @Override
    public Test findTestById(int id) {
        Test foundTest = this.read(id);
        if (foundTest != null) {
            return foundTest;
        } else {
            return foundTest;
        }

    }

}
