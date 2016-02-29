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
import org.bitirmeprojesi.entity.Student;
import org.bitirmeprojesi.service.StudentOperationsDAOImplService;

/**
 *
 * @author Batuhan
 */
@FacesValidator("studentLoginNumberValidator")
public class StudentLoginNumberValidator implements Validator{

    @EJB
    StudentOperationsDAOImplService studentOperationsDAOImplService;
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Student student = (Student) studentOperationsDAOImplService.findStudentByLoginNumberFromService((Long)value);
        if(student!=null){
            FacesMessage msg = new FacesMessage(student.getStudentLoginnumber()+"'a sahip Öğrenci sistemde bulunmaktadır"
                    + ",Lütfen başka bir Giriş Numarası eklemeyi deneyin.");
            throw new ValidatorException(msg);
        }
    
    }
    
    
}
