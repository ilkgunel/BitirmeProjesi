/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitirmeprojesi.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "student", catalog = "e_odev", schema = "")
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
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s WHERE s.id = :id"),
    @NamedQuery(name = "Student.findByStudentClassname", query = "SELECT s FROM Student s WHERE s.studentClassname = :studentClassname"),
    @NamedQuery(name = "Student.findByStudentLoginnumber", query = "SELECT s FROM Student s WHERE s.studentLoginnumber = :studentLoginnumber"),
    @NamedQuery(name = "Student.findByStudentLoginpassword", query = "SELECT s FROM Student s WHERE s.studentLoginpassword = :studentLoginpassword"),
    @NamedQuery(name = "Student.findByStudentName", query = "SELECT s FROM Student s WHERE s.studentName = :studentName"),
    @NamedQuery(name = "Student.findByStudentStudentNumber", query = "SELECT s FROM Student s WHERE s.studentStudentNumber = :studentStudentNumber"),
    @NamedQuery(name = "Student.findByStudentSurname", query = "SELECT s FROM Student s WHERE s.studentSurname = :studentSurname")})
public class Student extends BasePersistenceObject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "Student_Classname")
    private String studentClassname;
    @Column(name = "Student_Loginnumber")
    private BigInteger studentLoginnumber;
    @Size(max = 255)
    @Column(name = "Student_Loginpassword")
    private String studentLoginpassword;
    @Size(max = 255)
    @Column(name = "Student_Name")
    private String studentName;
    @Column(name = "Student_StudentNumber")
    private Short studentStudentNumber;
    @Size(max = 255)
    @Column(name = "Student_Surname")
    private String studentSurname;
    @OneToMany(mappedBy = "sAStudentId")
    private List<StudentAssesment> studentAssesmentList;
    @JoinColumn(name = "Student_TeacherId", referencedColumnName = "id")
    @ManyToOne
    private Teacher studentTeacherId;

    public Student() {
    }

    public Student(Integer id) {
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

    public String getStudentClassname() {
        return studentClassname;
    }

    public void setStudentClassname(String studentClassname) {
        this.studentClassname = studentClassname;
    }

    public BigInteger getStudentLoginnumber() {
        return studentLoginnumber;
    }

    public void setStudentLoginnumber(BigInteger studentLoginnumber) {
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

    public Short getStudentStudentNumber() {
        return studentStudentNumber;
    }

    public void setStudentStudentNumber(Short studentStudentNumber) {
        this.studentStudentNumber = studentStudentNumber;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    @XmlTransient
    public List<StudentAssesment> getStudentAssesmentList() {
        return studentAssesmentList;
    }

    public void setStudentAssesmentList(List<StudentAssesment> studentAssesmentList) {
        this.studentAssesmentList = studentAssesmentList;
    }

    public Teacher getStudentTeacherId() {
        return studentTeacherId;
    }

    public void setStudentTeacherId(Teacher studentTeacherId) {
        this.studentTeacherId = studentTeacherId;
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
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((super.getId() == null && other.getId() != null) || (super.getId() != null && !super.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bitirmeprojesi.entity.Student[ id=" + super.getId() + " ]";
    }

}
