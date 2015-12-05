/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bitirmeprojesi.dao;

import java.util.List;
import org.bitirmeprojesi.dto.DTO;
import org.bitirmeprojesi.entity.Test;

/**
 *
 * @author Batuhan
 */
public interface TestOperationsDAO {
    DTO insertTest(Test test);
    List<Test> getTestList();
    Test findTestById(int id);
}
