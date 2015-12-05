package org.bitirmeprojesi.daoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.bitirmeprojesi.dao.AssignmentOperationsDAO;
import org.bitirmeprojesi.entity.Assignment;


/**
 *
 * @author İlkay Günel
 */

@Named(value = "assignmentOperationsDAO")
public class AssignmentOperationsDAOImpl extends GenericJPADAOImpl<Assignment, Serializable> implements AssignmentOperationsDAO {

	@Override
	public void addAssignment(Assignment assignment) 
        {
            try 
            {
                this.create(assignment);
            } 
            catch (Exception e) 
            {
                System.err.println("\nAn error occured when adding assignment to database!");                
                System.err.println("Error is:"+e);            
            }	
	}

	@Override
	public List<Assignment> getAssignments() {
		List<Assignment> assignments = new ArrayList<Assignment>();
		try {
			assignments = this.readAll();
			return assignments;
		} catch (Exception e) {
            System.out.println("Error from StudentOperationsDAOImpl:" + e.getLocalizedMessage());
            return null;
		}
	}
	
	
	
}
