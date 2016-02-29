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
import org.bitirmeprojesi.entity.Assignment;
import org.bitirmeprojesi.service.AssignmentOperationsDAOImplService;

/**
 *
 * @author Batuhan
 */
@FacesValidator("assignmentNameValidator")
public class AssignmentNameValidator implements Validator {

    @EJB
    AssignmentOperationsDAOImplService assignmentOperationsDAOImplService;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Assignment assignment = (Assignment) assignmentOperationsDAOImplService.findAssignmentByNameFromService((String)value);
        if(assignment!=null){
            FacesMessage msg = new FacesMessage(assignment.getAssignmentName()+" adlı Ödev sistemde bulunmaktadır,"
                    + "Lütfen başka bir ödev adı giriniz.");
            throw new ValidatorException(msg);
        }
    }

}
