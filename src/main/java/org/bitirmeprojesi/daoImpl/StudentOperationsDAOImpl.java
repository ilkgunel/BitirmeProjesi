/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitirmeprojesi.daoImpl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.persistence.Query;
import org.bitirmeprojesi.dao.StudentOperationsDAO;
import org.bitirmeprojesi.dto.DTO;
import org.bitirmeprojesi.entity.Student;

/**
 *
 * @author Batuhan
 */
@Named("studentOperationsDAO")
public class StudentOperationsDAOImpl extends JPAService<Student, Serializable> implements StudentOperationsDAO {

    @Override
    public DTO addStudent(Student student) {
        try {
            this.create(student);
            return new DTO("Success", true);
        } catch (Exception e) {
            System.out.println("Error from StudentOperationsDAOImpl:" + e.getLocalizedMessage());
            return new DTO("Fail", false);
        } 
    }

    @Override
    public List<Student> getStudents() {
        List<Student> studentList = new ArrayList<>();
        try {
            studentList = this.readAll();
            if (studentList != null) {
                return studentList;
            } else {
                return studentList;
            }
        } catch (Exception e) {
            System.out.println("Error from StudentOperationsDAOImpl:" + e.getLocalizedMessage());
            return studentList;
        } 
    }

    @Override
    public Student findStudentByLoginNumber(BigInteger loginNumber) {
        Student student = null;
        Query query = this.entityManager.createNamedQuery("Student.findByStudentLoginnumber");
        try {
            query.setParameter("studentLoginnumber", loginNumber);
            student = (Student) query.getSingleResult();
            if (student != null) {
                return student;
            } else {
                System.out.println("İnfo from StudentOperationsDAOImpl: Öğrenci giriş numarası mevcut değil,eklenebilir.");
                return student;
            }
        } catch (Exception e) {
            System.out.println("Error from StudentOperationsDAOImpl:" + e.getLocalizedMessage());
            return student;
        } 
    }

}
