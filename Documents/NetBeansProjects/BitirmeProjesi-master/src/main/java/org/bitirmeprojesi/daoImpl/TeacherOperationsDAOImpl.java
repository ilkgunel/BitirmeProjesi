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
import org.bitirmeprojesi.dto.DTO;
import org.bitirmeprojesi.entity.Teacher;

/**
 *
 * @author Batuhan And İlkay
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
    
    @Override
    public DTO addTeacher(Teacher teacher)
    {
    	try {
		this.create(teacher);
                return new DTO("Success",true);
		} 
    	catch (Exception e) 
    	{
			System.err.println("An Error Occured!");
			System.err.println("The Error Is:"+e);
                        return new DTO("Failed",false);
		}
    }

}
