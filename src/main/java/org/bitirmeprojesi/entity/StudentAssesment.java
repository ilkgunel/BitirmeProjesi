/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitirmeprojesi.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.ExistenceChecking;
import org.eclipse.persistence.annotations.ExistenceType;
import org.eclipse.persistence.config.CacheIsolationType;

/**
 *
 * @author Batuhan
 */
@Entity
@Table(name = "student_assesment")
@Cache(
        type = CacheType.SOFT_WEAK,
        size = 1000,
        isolation = CacheIsolationType.SHARED,
        disableHits = true,
        alwaysRefresh = false,
        expiry = 7200000 //2 minutes
)
@ExistenceChecking(ExistenceType.CHECK_CACHE)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentAssesment.findAll", query = "SELECT s FROM StudentAssesment s"),
    @NamedQuery(name = "StudentAssesment.findBySAAssignmentDeliveryDate", query = "SELECT s FROM StudentAssesment s WHERE s.sAAssignmentDeliveryDate = :sAAssignmentDeliveryDate"),
    @NamedQuery(name = "StudentAssesment.findBySAAssignmentScore", query = "SELECT s FROM StudentAssesment s WHERE s.sAAssignmentScore = :sAAssignmentScore"),
    @NamedQuery(name = "StudentAssesment.findBySATestCorrectAnswer", query = "SELECT s FROM StudentAssesment s WHERE s.sATestCorrectAnswer = :sATestCorrectAnswer"),
    @NamedQuery(name = "StudentAssesment.findBySATestDeliveryDate", query = "SELECT s FROM StudentAssesment s WHERE s.sATestDeliveryDate = :sATestDeliveryDate"),
    @NamedQuery(name = "StudentAssesment.findBySATestWrongAnswer", query = "SELECT s FROM StudentAssesment s WHERE s.sATestWrongAnswer = :sATestWrongAnswer")})
public class StudentAssesment extends BasePersistenceObject implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "SA_AssignmentDeliveryDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sAAssignmentDeliveryDate;
    @Basic(optional = false)
    @Column(name = "SA_AssignmentScore")
    private short sAAssignmentScore;
    @Basic(optional = false)
    @Column(name = "SA_TestCorrectAnswer")
    private short sATestCorrectAnswer;
    @Basic(optional = false)
    @Column(name = "SA_TestDeliveryDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sATestDeliveryDate;
    @Basic(optional = false)
    @Column(name = "SA_TestWrongAnswer")
    private short sATestWrongAnswer;
    @JoinColumn(name = "SA_StudentId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Student sAStudentId;
    @JoinColumn(name = "SA_AssignmentId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Assignment sAAssignmentId;
    @JoinColumn(name = "SA_TestId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Test sATestId;

    public StudentAssesment() {
    }

    public StudentAssesment(Integer sAId) {
        super(sAId);
    }

    public StudentAssesment(Date sAAssignmentDeliveryDate, short sAAssignmentScore, short sATestCorrectAnswer, Date sATestDeliveryDate, short sATestWrongAnswer) {
        this.sAAssignmentDeliveryDate = sAAssignmentDeliveryDate;
        this.sAAssignmentScore = sAAssignmentScore;
        this.sATestCorrectAnswer = sATestCorrectAnswer;
        this.sATestDeliveryDate = sATestDeliveryDate;
        this.sATestWrongAnswer = sATestWrongAnswer;
    }

    public Date getSAAssignmentDeliveryDate() {
        return sAAssignmentDeliveryDate;
    }

    public void setSAAssignmentDeliveryDate(Date sAAssignmentDeliveryDate) {
        this.sAAssignmentDeliveryDate = sAAssignmentDeliveryDate;
    }

    public short getSAAssignmentScore() {
        return sAAssignmentScore;
    }

    public void setSAAssignmentScore(short sAAssignmentScore) {
        this.sAAssignmentScore = sAAssignmentScore;
    }

    public short getSATestCorrectAnswer() {
        return sATestCorrectAnswer;
    }

    public void setSATestCorrectAnswer(short sATestCorrectAnswer) {
        this.sATestCorrectAnswer = sATestCorrectAnswer;
    }

    public Date getSATestDeliveryDate() {
        return sATestDeliveryDate;
    }

    public void setSATestDeliveryDate(Date sATestDeliveryDate) {
        this.sATestDeliveryDate = sATestDeliveryDate;
    }

    public short getSATestWrongAnswer() {
        return sATestWrongAnswer;
    }

    public void setSATestWrongAnswer(short sATestWrongAnswer) {
        this.sATestWrongAnswer = sATestWrongAnswer;
    }

    public Student getSAStudentId() {
        return sAStudentId;
    }

    public void setSAStudentId(Student sAStudentId) {
        this.sAStudentId = sAStudentId;
    }

    public Assignment getSAAssignmentId() {
        return sAAssignmentId;
    }

    public void setSAAssignmentId(Assignment sAAssignmentId) {
        this.sAAssignmentId = sAAssignmentId;
    }

    public Test getSATestId() {
        return sATestId;
    }

    public void setSATestId(Test sATestId) {
        this.sATestId = sATestId;
    }

}
