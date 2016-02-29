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
import org.bitirmeprojesi.dao.StudentOperationsDAO;
import org.bitirmeprojesi.dto.DTO;
import org.bitirmeprojesi.entity.Student;

/**
 *
 * @author Batuhan And İlkay
 */
@Stateless
public class StudentOperationsDAOImplService {

    @Inject
    private @Named("studentOperationsDAO")
    transient StudentOperationsDAO studentOperationsDAO;

    public DTO insertStudentFromService(Student student) {
        try 
        {
           DTO dto = studentOperationsDAO.addStudent(student);
           if(dto.isSuccess()){
               return dto;
           }else{
               return dto;
           }
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
    
    public Student findStudentByLoginNumberFromService(Long loginNumber) {
        Student student = null;
        try {
            student = (Student) studentOperationsDAO.findStudentByLoginNumber(loginNumber);
            if (student != null) {
                return student;
            } else {
                return student;
            }
        } catch (Exception e) {
            System.out.println("Error from StudentOperationsDAOImpl:" + e.getLocalizedMessage());
            return student;
        }
    }

}
