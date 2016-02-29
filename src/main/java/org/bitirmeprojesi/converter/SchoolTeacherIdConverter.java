package org.bitirmeprojesi.converter;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.bitirmeprojesi.entity.School;
import org.bitirmeprojesi.entity.Student;
import org.bitirmeprojesi.entity.Teacher;

/**
 *
 * @author İlkay Günel
 */
@FacesConverter(forClass = Teacher.class,value = "schoolTeacherIdConverter")
public class SchoolTeacherIdConverter implements Converter {
	 @Override
	    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
	        if (value.isEmpty() || value.equals("")) {
	            return null;
	        }

	        Integer id = new Integer(value);
	        School school = new School(id);
	        return school;

	    }

	    @Override
	    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
	        if (o == null) {
	            return null;
	        }

	        School school = (School) o;
	        String schoolId = school.getId().toString();
	        if (schoolId != null) {
	            return schoolId;
	        }
	        return schoolId;
	    }

}
