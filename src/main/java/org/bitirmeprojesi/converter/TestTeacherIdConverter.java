/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitirmeprojesi.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.bitirmeprojesi.entity.Teacher;

/**
 *
 * @author Batuhan
 */
@FacesConverter(forClass = Teacher.class, value = "testTeacherIdConverter")
public class TestTeacherIdConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value.isEmpty() || value.equals("")) {
            return null;
        }

        Integer id = new Integer(value);
        Teacher teacher = new Teacher(id);
        return teacher;

    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null) {
            return null;
        }

        Teacher teacher = (Teacher) o;
        String teacherId = teacher.getId().toString();
        if (teacherId != null) {
            return teacherId;
        }
        return teacherId;

    }

}
