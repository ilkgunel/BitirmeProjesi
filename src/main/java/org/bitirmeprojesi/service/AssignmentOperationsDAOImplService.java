package org.bitirmeprojesi.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.inject.Inject;
import org.bitirmeprojesi.dao.AssignmentOperationsDAO;
import org.bitirmeprojesi.dto.DTO;
import org.bitirmeprojesi.entity.Assignment;

/**
 *
 * @author İlkay Günel
 */
@Stateless
public class AssignmentOperationsDAOImplService {

    @Inject
    private @Named("assignmentOperationsDAO")
    transient AssignmentOperationsDAO assignmentOperationsDAO;

    public DTO insertAssignmentFromService(Assignment assignment) {
        try {
            DTO dto = assignmentOperationsDAO.addAssignment(assignment);
            if (dto.isSuccess()) {
                return dto;
            } else {
                return dto;
            }
        } catch (Exception e) {
            System.out.println("Error from AssignmentOperationsDAOImplService:" + e.getLocalizedMessage() + " " + e);
            return new DTO("Assignment insert fail from service", false);
        }
    }

    public List<Assignment> getAssignmentsFromService() {
        List<Assignment> assignmentList = new ArrayList<Assignment>();
        try {
            assignmentList = assignmentOperationsDAO.getAssignments();
            return assignmentList;
        } catch (Exception e) {
            System.out.println("Error from AssignmentOperationDAOImplService:" + e.getLocalizedMessage());
            return null;
        }
    }

    public Assignment findAssignmentByNameFromService(String name) {
        Assignment assignment = null;
        try {
            assignment = (Assignment) assignmentOperationsDAO.findAssignmentByName(name);
            if (assignment != null) {
                return assignment;
            } else {
                return assignment;
            }
        } catch (Exception e) {
            System.out.println("Error from StudentOperationsDAOImpl:" + e.getLocalizedMessage());
            return assignment;
        }
    }
}
