package org.bitirmeprojesi.dao;

import java.util.List;
import javax.ejb.Local;
import org.bitirmeprojesi.dto.DTO;

import org.bitirmeprojesi.entity.Assignment;


/**
 *
 * @author İlkay Günel
 */
@Local
public interface AssignmentOperationsDAO {
    DTO addAssignment(Assignment assignment);
    List<Assignment> getAssignments();
    Assignment findAssignmentByName(String name);
}
