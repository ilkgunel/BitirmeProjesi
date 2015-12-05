/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitirmeprojesi.utils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.bitirmeprojesi.entity.Student;
import org.bitirmeprojesi.entity.Teacher;

/**
 *
 * @author Batuhan
 */
@FacesConverter(forClass = Student.class,value = "studentTeacherIdConverter")
public class StudentTeacherIdConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String teacherIdString) {
        if (teacherIdString.isEmpty() || teacherIdString.equals("")) {
            return null;
        }
        Integer teacherId = new Integer(teacherIdString);
        Teacher teacher = new Teacher(teacherId);
        return teacher;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null) {
            return null;
        }

        Teacher teacher = (Teacher) o;
        String teacherId = teacher.getTeacherTeacherId().toString();
        if(teacherId != null){
        return teacherId;
        }
        return teacherId;
    }

}
