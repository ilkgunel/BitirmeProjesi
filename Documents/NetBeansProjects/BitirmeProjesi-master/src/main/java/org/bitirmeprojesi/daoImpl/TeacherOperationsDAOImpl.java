/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitirmeprojesi.daoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import org.bitirmeprojesi.dao.TeacherOperationsDAO;
import org.bitirmeprojesi.entity.Teacher;

/**
 *
 * @author Batuhan
 */
@Named("teacherOperationsDAO")
public class TeacherOperationsDAOImpl extends GenericJPADAOImpl<Teacher, Serializable> implements TeacherOperationsDAO {

    @Override
    public List<Teacher> getTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        try {
            teachers = this.readAll();
            return teachers;
        } catch (Exception e) {
            System.out.println("Error from TeacherDAOImpl:" + e.getLocalizedMessage());
        }
        return teachers;
    }

}
