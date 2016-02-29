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
import org.bitirmeprojesi.dao.TestOperationsDAO;
import org.bitirmeprojesi.dto.DTO;
import org.bitirmeprojesi.entity.Test;

/**
 *
 * @author Batuhan
 */
@Stateless
public class TestOperationsDAOImplService {

    @Inject
    private @Named("testOperationsDAO")
    transient TestOperationsDAO testOperationsDAO;

    public DTO insertTestFromService(Test test) {
        DTO dto = testOperationsDAO.insertTest(test);
        if (dto.isSuccess()) {
            return dto;
        }
        return dto;
    }

    public List<Test> getTestListFromService() {
        List<Test> testList = new ArrayList<Test>();
        testList = testOperationsDAO.getTestList();
        if (testList != null) {
            return testList;
        }
        return testList;
    }

    public Test findTestByIdFromService(int id) {
        Test test = testOperationsDAO.findTestById(id);
        if (test != null) {
            return test;
        } else {
            return test;
        }
    }
}
