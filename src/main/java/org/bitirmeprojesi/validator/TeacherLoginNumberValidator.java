/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bitirmeprojesi.validator;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.bitirmeprojesi.entity.Teacher;
import org.bitirmeprojesi.service.TeacherOperationsDAOImplService;

/**
 *
 * @author Batuhan
 */
@FacesValidator("teacherLoginNumberValidator")
public class TeacherLoginNumberValidator implements Validator{

    @EJB
    TeacherOperationsDAOImplService teacherOperationsDAOImplService;
   
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Teacher teacher = (Teacher) teacherOperationsDAOImplService.findTeacherByLoginNumberFromService((String)value);
        if(teacher!=null){
             FacesMessage msg = 
				new FacesMessage(teacher.getTeacherLoginNumber()+"'e sahip Öğretmen"
                                        + " sistemde bulunmaktadır,lütfen başka bir Login Number deneyiniz"
					);
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                        throw new ValidatorException(msg);
        }
    }
    
    
}
