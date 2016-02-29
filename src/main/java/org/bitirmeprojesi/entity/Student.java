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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
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
@Table(name = "student")
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
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStudentClassname", query = "SELECT s FROM Student s WHERE s.studentClassname = :studentClassname"),
    @NamedQuery(name = "Student.findByStudentLoginnumber", query = "SELECT s FROM Student s WHERE s.studentLoginnumber = :studentLoginnumber"),
    @NamedQuery(name = "Student.findByStudentLoginpassword", query = "SELECT s FROM Student s WHERE s.studentLoginpassword = :studentLoginpassword"),
    @NamedQuery(name = "Student.findByStudentName", query = "SELECT s FROM Student s WHERE s.studentName = :studentName"),
    @NamedQuery(name = "Student.findByStudentStudentNumber", query = "SELECT s FROM Student s WHERE s.studentStudentNumber = :studentStudentNumber"),
    @NamedQuery(name = "Student.findByStudentSurname", query = "SELECT s FROM Student s WHERE s.studentSurname = :studentSurname")})
public class Student extends BasePersistenceObject implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "Student_Classname")
    private String studentClassname;
    @Basic(optional = false)
    @Column(name = "Student_Loginnumber")
    private long studentLoginnumber;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "Student_Loginpassword")
    private String studentLoginpassword;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "Student_Name")
    private String studentName;
    @Basic(optional = false)
    @Column(name = "Student_StudentNumber")
    private short studentStudentNumber;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "Student_Surname")
    private String studentSurname;
    @JoinColumn(name = "Student_TeacherId", referencedColumnName = "id")
    @ManyToOne
    private Teacher studentTeacherId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sAStudentId")
    private List<StudentAssesment> studentAssesmentList;

    public Student() {
    }

    public Student(Integer studentId) {
        super(studentId);
    }

    public Student(String studentClassname, long studentLoginnumber, String studentLoginpassword, String studentName, short studentStudentNumber, String studentSurname) {
        this.studentClassname = studentClassname;
        this.studentLoginnumber = studentLoginnumber;
        this.studentLoginpassword = studentLoginpassword;
        this.studentName = studentName;
        this.studentStudentNumber = studentStudentNumber;
        this.studentSurname = studentSurname;
    }

    public String getStudentClassname() {
        return studentClassname;
    }

    public void setStudentClassname(String studentClassname) {
        this.studentClassname = studentClassname;
    }

    public long getStudentLoginnumber() {
        return studentLoginnumber;
    }

    public void setStudentLoginnumber(long studentLoginnumber) {
        this.studentLoginnumber = studentLoginnumber;
    }

    public String getStudentLoginpassword() {
        return studentLoginpassword;
    }

    public void setStudentLoginpassword(String studentLoginpassword) {
        this.studentLoginpassword = studentLoginpassword;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public short getStudentStudentNumber() {
        return studentStudentNumber;
    }

    public void setStudentStudentNumber(short studentStudentNumber) {
        this.studentStudentNumber = studentStudentNumber;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public Teacher getStudentTeacherId() {
        return studentTeacherId;
    }

    public void setStudentTeacherId(Teacher studentTeacherId) {
        this.studentTeacherId = studentTeacherId;
    }

    @XmlTransient
    public List<StudentAssesment> getStudentAssesmentList() {
        return studentAssesmentList;
    }

    public void setStudentAssesmentList(List<StudentAssesment> studentAssesmentList) {
        this.studentAssesmentList = studentAssesmentList;
    }

}
