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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStudentId", query = "SELECT s FROM Student s WHERE s.studentId = :studentId"),
    @NamedQuery(name = "Student.findByStudentClassname", query = "SELECT s FROM Student s WHERE s.studentClassname = :studentClassname"),
    @NamedQuery(name = "Student.findByStudentLoginnumber", query = "SELECT s FROM Student s WHERE s.studentLoginnumber = :studentLoginnumber"),
    @NamedQuery(name = "Student.findByStudentLoginpassword", query = "SELECT s FROM Student s WHERE s.studentLoginpassword = :studentLoginpassword"),
    @NamedQuery(name = "Student.findByStudentName", query = "SELECT s FROM Student s WHERE s.studentName = :studentName"),
    @NamedQuery(name = "Student.findByStudentStudentNumber", query = "SELECT s FROM Student s WHERE s.studentStudentNumber = :studentStudentNumber"),
    @NamedQuery(name = "Student.findByStudentSurname", query = "SELECT s FROM Student s WHERE s.studentSurname = :studentSurname")})
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "Student_Id")
    private Integer studentId;
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
    @JoinColumn(name = "Student_TeacherId", referencedColumnName = "Teacher_TeacherId")
    @ManyToOne
    private Teacher studentTeacherId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sAStudentId")
    private List<StudentAssesment> studentAssesmentList;

    public Student() {
    }

    public Student(Integer studentId) {
        this.studentId = studentId;
    }

    public Student(Integer studentId, String studentClassname, long studentLoginnumber, String studentLoginpassword, String studentName, short studentStudentNumber, String studentSurname) {
        this.studentId = studentId;
        this.studentClassname = studentClassname;
        this.studentLoginnumber = studentLoginnumber;
        this.studentLoginpassword = studentLoginpassword;
        this.studentName = studentName;
        this.studentStudentNumber = studentStudentNumber;
        this.studentSurname = studentSurname;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentId != null ? studentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bitirmeprojesi.entity.Student[ studentId=" + studentId + " ]";
    }
    
}
