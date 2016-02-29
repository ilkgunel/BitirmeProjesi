/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bitirmeprojesi.dao;

import java.util.List;
import javax.ejb.Local;
import org.bitirmeprojesi.dto.DTO;
import org.bitirmeprojesi.entity.Teacherroles;

/**
 *
 * @author Batuhan
 */
@Local
public interface TeacherRoleDefinitionsDAO {
    DTO addTeacherRole(Teacherroles teacherroles);
    DTO updateTeacherRole(Teacherroles teacherroles);
    DTO deleteTeacherRole(Teacherroles teacherroles);
    List<Teacherroles> getTeacherRoleList();
    Teacherroles findTeacherRolesByLoginNumber(String loginNumber);
}
