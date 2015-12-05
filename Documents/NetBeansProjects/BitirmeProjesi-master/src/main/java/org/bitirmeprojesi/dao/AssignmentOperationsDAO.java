package org.bitirmeprojesi.dao;

import java.util.List;

import org.bitirmeprojesi.entity.Assignment;


/**
 *
 * @author İlkay Günel
 */

public interface AssignmentOperationsDAO {
    void addAssignment(Assignment assignment);
    List<Assignment> getAssignments();
}
