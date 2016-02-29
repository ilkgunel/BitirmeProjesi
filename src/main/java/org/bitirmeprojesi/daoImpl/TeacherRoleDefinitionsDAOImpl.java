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
import javax.persistence.Query;
import org.bitirmeprojesi.dao.TeacherRoleDefinitionsDAO;
import org.bitirmeprojesi.dto.DTO;
import org.bitirmeprojesi.entity.Teacherroles;

/**
 *
 * @author Batuhan
 */
@Named("teacherRoleDefinitionsDAO")
public class TeacherRoleDefinitionsDAOImpl extends JPAService<Teacherroles, Serializable> implements TeacherRoleDefinitionsDAO {

    @Override
    public DTO addTeacherRole(Teacherroles teacherroles) {
        try {
            this.create(teacherroles);
            return new DTO("Success", true);
        } catch (Exception e) {
            return new DTO("Fail", false);
        }
    }

    @Override
    public DTO updateTeacherRole(Teacherroles teacherroles) {
        try {
            this.update(teacherroles);
            return new DTO("Success", true);
        } catch (Exception e) {
            return new DTO("Fail", false);
        }
    }

    @Override
    public DTO deleteTeacherRole(Teacherroles teacherroles) {
        try {
            this.delete(teacherroles);
            return new DTO("Success", true);
        } catch (Exception e) {
            return new DTO("Fail", false);
        }
    }

    @Override
    public List<Teacherroles> getTeacherRoleList() {
        List<Teacherroles> teacherRoleList = new ArrayList<Teacherroles>();
        try {
            teacherRoleList = this.readAll();
            if (teacherRoleList != null) {
                return teacherRoleList;
            } else {
                return teacherRoleList;
            }
        } catch (Exception e) {
            System.out.println("Error from TeacherRoleDefinitionsDAOImpl:" + e.getLocalizedMessage());
            return teacherRoleList;
        }
    }

    @Override
    public Teacherroles findTeacherRolesByLoginNumber(String loginNumber) {
        Teacherroles teacherroles = null;
        Query query = this.entityManager.createNamedQuery("Teacherroles.findByLoginnumber");
        try {
            query.setParameter("loginnumber", loginNumber);
            teacherroles = (Teacherroles) query.getSingleResult();
            if (teacherroles != null) {
                return teacherroles;
            } else {
                System.out.println("İnfo from TeacherRoleDefinitionsDAOImpl:Teacher Rolü Giriş Numarası mevcut değil,eklenebilir.");
                return teacherroles;
            }
        } catch (Exception e) {
            System.out.println("Error from TeacherRoleDefinitionsDAOImpl:" + e.getLocalizedMessage());
            return teacherroles;
        }
    }

}
