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
import org.bitirmeprojesi.entity.Teacherroles;
import org.bitirmeprojesi.service.TeacherRoleDefinitionsDAOImplService;

/**
 *
 * @author Batuhan
 */
@FacesValidator("teacherRoleLoginNumberValidator")
public class TeacherRoleLoginNumberValidator implements Validator {

    @EJB
    TeacherRoleDefinitionsDAOImplService teacherRoleDefinitionsDAOImplService;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Teacherroles teacherroles = (Teacherroles) teacherRoleDefinitionsDAOImplService.findTeacherRolesByLoginNumberFromService((String) value);
        if (teacherroles != null) {
            FacesMessage msg = new FacesMessage(teacherroles.getLoginnumber() + "'e sahip Öğretmen Rolü sistemde tanımlıdır,"
                    + "Lütfen başka bir öğretmen seçiniz");
            throw new ValidatorException(msg);
        }
    }

}
