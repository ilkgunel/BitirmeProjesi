/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitirmeprojesi.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.ExistenceChecking;
import org.eclipse.persistence.annotations.ExistenceType;

/**
 *
 * @author Batuhan
 */
@Entity
@Table(name = "student_assesment", catalog = "e_odev", schema = "")
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
    @NamedQuery(name = "StudentAssesment.findAll", query = "SELECT s FROM StudentAssesment s"),
    @NamedQuery(name = "StudentAssesment.findById", query = "SELECT s FROM StudentAssesment s WHERE s.id = :id"),
    @NamedQuery(name = "StudentAssesment.findBySAAssignmentDeliveryDate", query = "SELECT s FROM StudentAssesment s WHERE s.sAAssignmentDeliveryDate = :sAAssignmentDeliveryDate"),
    @NamedQuery(name = "StudentAssesment.findBySAAssignmentScore", query = "SELECT s FROM StudentAssesment s WHERE s.sAAssignmentScore = :sAAssignmentScore"),
    @NamedQuery(name = "StudentAssesment.findBySATestCorrectAnswer", query = "SELECT s FROM StudentAssesment s WHERE s.sATestCorrectAnswer = :sATestCorrectAnswer"),
    @NamedQuery(name = "StudentAssesment.findBySATestDeliveryDate", query = "SELECT s FROM StudentAssesment s WHERE s.sATestDeliveryDate = :sATestDeliveryDate"),
    @NamedQuery(name = "StudentAssesment.findBySATestWrongAnswer", query = "SELECT s FROM StudentAssesment s WHERE s.sATestWrongAnswer = :sATestWrongAnswer")})
public class StudentAssesment extends BasePersistenceObject implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "SA_AssignmentDeliveryDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sAAssignmentDeliveryDate;
    @Column(name = "SA_AssignmentScore")
    private Short sAAssignmentScore;
    @Column(name = "SA_TestCorrectAnswer")
    private Short sATestCorrectAnswer;
    @Column(name = "SA_TestDeliveryDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sATestDeliveryDate;
    @Column(name = "SA_TestWrongAnswer")
    private Short sATestWrongAnswer;
    @JoinColumn(name = "SA_AssignmentId", referencedColumnName = "id")
    @ManyToOne
    private Assignment sAAssignmentId;
    @JoinColumn(name = "SA_StudentId", referencedColumnName = "id")
    @ManyToOne
    private Student sAStudentId;
    @JoinColumn(name = "SA_TestId", referencedColumnName = "id")
    @ManyToOne
    private Test sATestId;

    public StudentAssesment() {
    }

    public StudentAssesment(Integer id) {
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

    public Date getSAAssignmentDeliveryDate() {
        return sAAssignmentDeliveryDate;
    }

    public void setSAAssignmentDeliveryDate(Date sAAssignmentDeliveryDate) {
        this.sAAssignmentDeliveryDate = sAAssignmentDeliveryDate;
    }

    public Short getSAAssignmentScore() {
        return sAAssignmentScore;
    }

    public void setSAAssignmentScore(Short sAAssignmentScore) {
        this.sAAssignmentScore = sAAssignmentScore;
    }

    public Short getSATestCorrectAnswer() {
        return sATestCorrectAnswer;
    }

    public void setSATestCorrectAnswer(Short sATestCorrectAnswer) {
        this.sATestCorrectAnswer = sATestCorrectAnswer;
    }

    public Date getSATestDeliveryDate() {
        return sATestDeliveryDate;
    }

    public void setSATestDeliveryDate(Date sATestDeliveryDate) {
        this.sATestDeliveryDate = sATestDeliveryDate;
    }

    public Short getSATestWrongAnswer() {
        return sATestWrongAnswer;
    }

    public void setSATestWrongAnswer(Short sATestWrongAnswer) {
        this.sATestWrongAnswer = sATestWrongAnswer;
    }

    public Assignment getSAAssignmentId() {
        return sAAssignmentId;
    }

    public void setSAAssignmentId(Assignment sAAssignmentId) {
        this.sAAssignmentId = sAAssignmentId;
    }

    public Student getSAStudentId() {
        return sAStudentId;
    }

    public void setSAStudentId(Student sAStudentId) {
        this.sAStudentId = sAStudentId;
    }

    public Test getSATestId() {
        return sATestId;
    }

    public void setSATestId(Test sATestId) {
        this.sATestId = sATestId;
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
        if (!(object instanceof StudentAssesment)) {
            return false;
        }
        StudentAssesment other = (StudentAssesment) object;
        if ((super.getId() == null && other.getId() != null) || (super.getId() != null && !super.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bitirmeprojesi.entity.StudentAssesment[ id=" + super.getId() + " ]";
    }

}
