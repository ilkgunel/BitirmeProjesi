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

import org.bitirmeprojesi.dao.TeacherOperationsDAO;
import org.bitirmeprojesi.dto.DTO;
import org.bitirmeprojesi.entity.Teacher;

/**
 *
 * @author Batuhan
 */
@Stateless
public class TeacherOperationsDAOImplService implements Serializable {

    @Inject
    private @Named("teacherOperationsDAO")
    transient TeacherOperationsDAO teacherOperationsDAO;

    public DTO insertTeacherFromService(Teacher teacher)
    {
    	try {
			teacherOperationsDAO.addTeacher(teacher);
			return new DTO("Teacher insert from service is successful",true);
		} catch (Exception e) {
			System.err.println("An error is occured while inserting the teacher!\nError is:"+e);
			return new DTO("An error is occured while inserting the teacher!",false);
		}
    }
    
    public List<Teacher> getTeachersFromService() 
    {
        List<Teacher> teacherList = new ArrayList<>();
        try {
            teacherList = teacherOperationsDAO.getTeachers();
            return teacherList;
        } catch (Exception e) {
            System.out.println("Error from TeacherOperationsDAOImplService:" + e.getLocalizedMessage());
        }
        return teacherList;
    }
    
    public Teacher findTeacherByLoginNumberFromService(String loginNumber){
        Teacher teacher = null;
        try{
            teacher = teacherOperationsDAO.findTeacherByLoginNumber(loginNumber);
            if(teacher != null){
                return teacher;
            }else{
                return teacher;
            }
        }catch(Exception e){
             System.out.println("Error from TeacherOperationsDAOImplService:" + e.getLocalizedMessage());
             return teacher;
        }
    }
}
