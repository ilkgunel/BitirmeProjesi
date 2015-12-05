/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bitirmeprojesi.dao;

import java.util.List;
import org.bitirmeprojesi.entity.Teacher;

/**
 *
 * @author Batuhan
 */
public interface TeacherOperationsDAO {
    List<Teacher> getTeachers();
}
