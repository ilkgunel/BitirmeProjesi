package org.bitirmeprojesi.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
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
public class AssignmentOperationsDAOImplService implements Serializable {
	
    @Inject
    private @Named("assignmentOperationsDAO")
    transient AssignmentOperationsDAO assignmentOperationsDAO;
	
    public DTO insertAssignmentFromService(Assignment assignment) {
        try 
        {
            assignmentOperationsDAO.addAssignment(assignment);
            return new DTO("Assignment insert success from service", true);
        } 
        
        catch (Exception e) 
        {
            System.out.println("Error from AssignmentOperationsDAOImplService:" + e.getLocalizedMessage()+" "+e);
            return new DTO("Assignment insert fail from service", false);
        }
    }
    
    public List<Assignment> getAssignmentsFromService()
    {
    	List<Assignment> assignmentList=new ArrayList<Assignment>();
    	try {
			assignmentList = assignmentOperationsDAO.getAssignments();
			return assignmentList;
		} catch (Exception e) {
            System.out.println("Error from AssignmentOperationDAOImplService:" + e.getLocalizedMessage());
            return null;
		}
    }
}
