/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitirmeprojesi.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import org.bitirmeprojesi.dao.TeacherRoleDefinitionsDAO;
import org.bitirmeprojesi.dto.DTO;
import org.bitirmeprojesi.entity.Teacherroles;

/**
 *
 * @author Batuhan
 */
@Stateless
public class TeacherRoleDefinitionsDAOImplService {

    @Inject
    private @Named("teacherRoleDefinitionsDAO")
    transient TeacherRoleDefinitionsDAO teacherRoleDefinitionsDAO;

    public DTO addTeacherRoleFromService(Teacherroles teacherroles) {
        DTO dto = teacherRoleDefinitionsDAO.addTeacherRole(teacherroles);
        if (dto.isSuccess()) {
            return dto;
        } else {
            return dto;
        }
    }

    public DTO updateTeacherRoleFromService(Teacherroles teacherroles) {
        DTO dto = teacherRoleDefinitionsDAO.updateTeacherRole(teacherroles);
        if (dto.isSuccess()) {
            return dto;
        } else {
            return dto;
        }
    }

    public DTO deleteTeacherRoleFromService(Teacherroles teacherroles) {
        DTO dto = teacherRoleDefinitionsDAO.deleteTeacherRole(teacherroles);
        if (dto.isSuccess()) {
            return dto;
        } else {
            return dto;
        }
    }

    public List<Teacherroles> getTeacherRoleListFromService() {
        List<Teacherroles> teacherRoleList = new ArrayList<Teacherroles>();
        try {
            teacherRoleList = teacherRoleDefinitionsDAO.getTeacherRoleList();
            if (teacherRoleList != null) {
                return teacherRoleList;
            } else {
                return teacherRoleList;
            }
        } catch (Exception e) {
            System.out.println("Error from TeacherRoleDefinitionsDAOImplService:" + e.getLocalizedMessage());
            return teacherRoleList;
        }
    }

    public Teacherroles findTeacherRolesByLoginNumberFromService(String loginNumber) {
        Teacherroles teacherroles = null;
        try {
            teacherroles = (Teacherroles) teacherRoleDefinitionsDAO.findTeacherRolesByLoginNumber(loginNumber);
            if (teacherroles != null) {
                return teacherroles;
            } else {
                return teacherroles;
            }
        } catch (Exception e) {
            System.out.println("Error from TeacherRoleDefinitionsDAOImpl:" + e.getLocalizedMessage());
            return teacherroles;
        }
    }
}
