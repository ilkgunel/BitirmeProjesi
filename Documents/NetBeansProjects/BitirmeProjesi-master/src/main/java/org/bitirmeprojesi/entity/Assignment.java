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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Batuhan
 */
@Entity
@Table(name = "assignment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assignment.findAll", query = "SELECT a FROM Assignment a"),
    @NamedQuery(name = "Assignment.findByAssignmentId", query = "SELECT a FROM Assignment a WHERE a.assignmentId = :assignmentId"),
    @NamedQuery(name = "Assignment.findByAssignmentContains", query = "SELECT a FROM Assignment a WHERE a.assignmentContains = :assignmentContains"),
    @NamedQuery(name = "Assignment.findByAssignmentName", query = "SELECT a FROM Assignment a WHERE a.assignmentName = :assignmentName")})
public class Assignment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "Assignment_Id")
    private Integer assignmentId;
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
        this.assignmentId = assignmentId;
    }

    public Assignment(Integer assignmentId, String assignmentContains, String assignmentName) {
        this.assignmentId = assignmentId;
        this.assignmentContains = assignmentContains;
        this.assignmentName = assignmentName;
    }

    public Integer getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Integer assignmentId) {
        this.assignmentId = assignmentId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (assignmentId != null ? assignmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assignment)) {
            return false;
        }
        Assignment other = (Assignment) object;
        if ((this.assignmentId == null && other.assignmentId != null) || (this.assignmentId != null && !this.assignmentId.equals(other.assignmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bitirmeprojesi.entity.Assignment[ assignmentId=" + assignmentId + " ]";
    }
    
}
