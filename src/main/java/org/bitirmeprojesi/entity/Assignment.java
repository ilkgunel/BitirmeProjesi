/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitirmeprojesi.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.ChangeTracking;
import org.eclipse.persistence.annotations.ExistenceChecking;
import org.eclipse.persistence.annotations.ExistenceType;
import org.eclipse.persistence.config.CacheIsolationType;

/**
 *
 * @author Batuhan
 */
@Entity
@Table(name = "assignment")
@Cache(
        type = CacheType.SOFT_WEAK,
        size = 32000,
        isolation = CacheIsolationType.SHARED,
        disableHits = true,
        alwaysRefresh = false,
        expiry = 36000000 //2 minutes
)
@ExistenceChecking(ExistenceType.CHECK_CACHE)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assignment.findAll", query = "SELECT a FROM Assignment a"),
    @NamedQuery(name = "Assignment.findByAssignmentContains", query = "SELECT a FROM Assignment a WHERE a.assignmentContains = :assignmentContains"),
    @NamedQuery(name = "Assignment.findByAssignmentName", query = "SELECT a FROM Assignment a WHERE a.assignmentName = :assignmentName")})
public class Assignment extends BasePersistenceObject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "Assignment_Contains")
    private String assignmentContains;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "Assignment_Name")
    private String assignmentName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sAAssignmentId")
    private List<StudentAssesment> studentAssesmentList;

    public Assignment() {
    }

    public Assignment(Integer assignmentId) {
        super(assignmentId);
    }

    public Assignment(String assignmentContains, String assignmentName) {
        this.assignmentContains = assignmentContains;
        this.assignmentName = assignmentName;
    }

    public String getAssignmentContains() {
        return assignmentContains;
    }

    public void setAssignmentContains(String assignmentContains) {
        this.assignmentContains = assignmentContains;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    @XmlTransient
    public List<StudentAssesment> getStudentAssesmentList() {
        return studentAssesmentList;
    }

    public void setStudentAssesmentList(List<StudentAssesment> studentAssesmentList) {
        this.studentAssesmentList = studentAssesmentList;
    }

}
