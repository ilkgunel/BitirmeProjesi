/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitirmeprojesi.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import org.bitirmeprojesi.dao.StudentOperationsDAO;
import org.bitirmeprojesi.dto.DTO;
import org.bitirmeprojesi.entity.Student;

/**
 *
 * @author Batuhan And İlkay
 */
@Stateless
public class StudentOperationsDAOImplService implements Serializable {

    @Inject
    private @Named("studentOperationsDAO")
    transient StudentOperationsDAO studentOperationsDAO;

    public DTO insertStudentFromService(Student student) {
        try 
        {
            studentOperationsDAO.addStudent(student);
            return new DTO("Student insert success from service", true);
        } catch (Exception e) {
            System.out.println("Error from StudentOperationsDAOImplService:" + e.getLocalizedMessage());
            return new DTO("Student insert fail from service", false);
        }
    }

    public List<Student> getStudentsFromService() {
        List<Student> studentList = new ArrayList<>();
        try {
            studentList = studentOperationsDAO.getStudents();
            return studentList;
        } catch (Exception e) {
            System.out.println("Error from StudentOperationsDAOImplService:" + e.getLocalizedMessage());
        }
        return studentList;
    }

}
