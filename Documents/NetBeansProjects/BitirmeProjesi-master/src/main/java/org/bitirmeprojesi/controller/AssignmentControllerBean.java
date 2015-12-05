package org.bitirmeprojesi.controller;

/**
*
* @author İlkay Günel
*/

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.bitirmeprojesi.dto.DTO;
import org.bitirmeprojesi.entity.Assignment;
import org.bitirmeprojesi.service.AssignmentOperationsDAOImplService;

@ManagedBean(name="assignmentController")
@SessionScoped
public class AssignmentControllerBean implements Serializable {
	
	
	private Assignment assignmentObject = new Assignment();
	private List<Assignment> assignmentList = new ArrayList<Assignment>();
        
	public Assignment getAssignmentObject() {
		return assignmentObject;
	}
	
	public void setAssignmentObject(Assignment assignmentObject) {
		this.assignmentObject = assignmentObject;
	}
	
	public List<Assignment> getAssignmentList() {
		return assignmentList;
	}
	
	public void setAssignmentList(List<Assignment> assignmentList) {
		this.assignmentList = assignmentList;
	}
	
	@EJB
	AssignmentOperationsDAOImplService assignmentOperationsDAOImplService;
	
	@PostConstruct
	public void init()
	{
		assignmentList = assignmentOperationsDAOImplService.getAssignmentsFromService();
	}
	
	public String insertAssignmentFromBean()
	{
            try 
            {
                //assignmentObject.setAssignmentId(assignmentId);
                DTO control=assignmentOperationsDAOImplService.insertAssignmentFromService(assignmentObject);
                if(control.isSuccess())
                {
                    assignmentObject=new Assignment();
                    setAssignmentObject(assignmentObject);
                    //Assignment eklendiği anda listeyi güncelle.
                    assignmentList = assignmentOperationsDAOImplService.getAssignmentsFromService();
                    //
                    FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, control.getMessage(), null));  
                    return "";
                }
                else {
                        FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, control.getMessage(), null));
                        return "";
                }
            } 

            catch (Exception e) 
            {
                    FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_WARN, e.getLocalizedMessage(), null));
            }
            return "";
	}
}
