/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bitirmeprojesi.dao;

import java.util.List;
import javax.ejb.Local;
import org.bitirmeprojesi.dto.DTO;
import org.bitirmeprojesi.entity.Teacher;

/**
 *
 * @author Batuhan And İlkay
 */
@Local
public interface TeacherOperationsDAO {
	DTO addTeacher(Teacher teacher);
        List<Teacher> getTeachers();
        Teacher findTeacherByLoginNumber(String loginNumber);
}
