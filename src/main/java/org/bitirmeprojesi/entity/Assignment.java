/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitirmeprojesi.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.ExistenceChecking;
import org.eclipse.persistence.annotations.ExistenceType;

/**
 *
 * @author Batuhan
 */
@Entity
@Table(name = "assignment", catalog = "e_odev", schema = "")
@XmlRootElement
@Cache(
        type = CacheType.SOFT, // Cache everything until the JVM decides memory is low.
        size = 64000, // Use 64,000 as the initial cache size.
        expiry = 36000000, // 10 minutes
        coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS // if cache coordination is used, only send invalidation messages.
)
@Cacheable(true)
@ExistenceChecking(ExistenceType.CHECK_CACHE)
@NamedQueries({
    @NamedQuery(name = "Assignment.findAll", query = "SELECT a FROM Assignment a"),
    @NamedQuery(name = "Assignment.findByAssignmentContains", query = "SELECT a FROM Assignment a WHERE a.assignmentContains = :assignmentContains"),
    @NamedQuery(name = "Assignment.findByAssignmentName", query = "SELECT a FROM Assignment a WHERE a.assignmentName = :assignmentName")})
public class Assignment extends BasePersistenceObject implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(max = 255)
    @Column(name = "Assignment_Contains")
    private String assignmentContains;
    @Size(max = 255)
    @Column(name = "Assignment_Name")
    private String assignmentName;
    @OneToMany(mappedBy = "sAAssignmentId")
    private List<StudentAssesment> studentAssesmentList;

    public Assignment() {
    }

    public Assignment(Integer id) {
        super(id);
    }

    @Override
    public void setId(Integer id) {
        this.id = id; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getId() {
        return this.id;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (super.getId() != null ? super.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assignment)) {
            return false;
        }
        Assignment other = (Assignment) object;
        if ((super.getId() == null && other.getId() != null) || (super.getId() != null && !super.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bitirmeprojesi.entity.Assignment[ id=" + super.getId() + " ]";
    }

}
