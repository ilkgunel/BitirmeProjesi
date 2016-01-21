/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bitirmeprojesi.dao;

import java.util.List;
import org.bitirmeprojesi.dto.DTO;
import org.bitirmeprojesi.entity.Student;

/**
 *
 * @author Batuhan
 */
public interface StudentOperationsDAO {
    DTO addStudent(Student student);
    List<Student> getStudents();
    Student findStudentByLoginNumber(Long loginNumber);
}
