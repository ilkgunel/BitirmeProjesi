package org.bitirmeprojesi.daoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.Query;

import org.bitirmeprojesi.dao.AssignmentOperationsDAO;
import org.bitirmeprojesi.dto.DTO;
import org.bitirmeprojesi.entity.Assignment;

/**
 *
 * @author İlkay Günel
 */
@Named(value = "assignmentOperationsDAO")
public class AssignmentOperationsDAOImpl extends JPAService<Assignment, Serializable> implements AssignmentOperationsDAO {

    @Override
    public DTO addAssignment(Assignment assignment) {
        try {
            this.create(assignment);
            return new DTO("Success", true);
        } catch (Exception e) {
            System.out.println("Error from AssignmentOperationsDAOImpl:" + e.getLocalizedMessage());
            return new DTO("Fail", false);
        }
    }

    @Override
    public List<Assignment> getAssignments() {
        List<Assignment> assignments = new ArrayList<Assignment>();
        try {
            assignments = this.readAll();
            this.close();
            return assignments;
        } catch (Exception e) {
            System.out.println("Error from AssignmentOperationsDAOImpl:" + e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Assignment findAssignmentByName(String name) {
        Assignment assignment = null;
        Query query = this.entityManager.createNamedQuery("Assignment.findByAssignmentName");
        try {
            query.setParameter("assignmentName", name);
            assignment = (Assignment) query.getSingleResult();
            if (assignment != null) {
                return assignment;
            } else {
                System.out.println("İnfo from AssignmentOperationsDAOImpl:Ödev adı mevcut değil,eklenebilir");
                return assignment;
            }
        } catch (Exception e) {
            System.out.println("Error from AssignmentOperationsDAOImpl:" + e.getLocalizedMessage());
            return assignment;
        }
    }

}
