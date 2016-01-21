/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bitirmeprojesi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Batuhan
 */
@Entity
@Table(name = "teacher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t"),
    @NamedQuery(name = "Teacher.findByTeacherTeacherId", query = "SELECT t FROM Teacher t WHERE t.teacherTeacherId = :teacherTeacherId"),
    @NamedQuery(name = "Teacher.findByEnabled", query = "SELECT t FROM Teacher t WHERE t.enabled = :enabled"),
    @NamedQuery(name = "Teacher.findByPassword", query = "SELECT t FROM Teacher t WHERE t.password = :password"),
    @NamedQuery(name = "Teacher.findByTeacherLoginNumber", query = "SELECT t FROM Teacher t WHERE t.teacherLoginNumber = :teacherLoginNumber"),
    @NamedQuery(name = "Teacher.findByTeacherName", query = "SELECT t FROM Teacher t WHERE t.teacherName = :teacherName"),
    @NamedQuery(name = "Teacher.findByTeacherSurname", query = "SELECT t FROM Teacher t WHERE t.teacherSurname = :teacherSurname"),
    @NamedQuery(name = "Teacher.findByTeacherAge", query = "SELECT t FROM Teacher t WHERE t.teacherAge = :teacherAge"),
    @NamedQuery(name = "Teacher.findByTeacherBranch", query = "SELECT t FROM Teacher t WHERE t.teacherBranch = :teacherBranch"),
    @NamedQuery(name = "Teacher.findByTeacherStartedDate", query = "SELECT t FROM Teacher t WHERE t.teacherStartedDate = :teacherStartedDate"),
    @NamedQuery(name = "Teacher.findByTeacherEndDate", query = "SELECT t FROM Teacher t WHERE t.teacherEndDate = :teacherEndDate")})
public class Teacher implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Teacher_TeacherId")
    private Integer teacherTeacherId;
    @Column(name = "enabled")
    private Boolean enabled;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "Teacher_LoginNumber")
    private String teacherLoginNumber;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "Teacher_Name")
    private String teacherName;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "Teacher_Surname")
    private String teacherSurname;
    @Basic(optional = false)
    @Column(name = "Teacher_Age")
    private int teacherAge;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "Teacher_Branch")
    private String teacherBranch;
    @Basic(optional = false)
    @Column(name = "Teacher_Started_Date")
    @Temporal(TemporalType.DATE)
    private Date teacherStartedDate;
    @Basic(optional = false)
    @Column(name = "Teacher_End_Date")
    @Temporal(TemporalType.DATE)
    private Date teacherEndDate;
    @OneToMany(mappedBy = "testTeacherId")
    private List<Test> testList;
    @JoinColumn(name = "Teacher_SchoolId", referencedColumnName = "Schoold_Id")
    @ManyToOne
    private School teacherSchoolId;

    public Teacher() {
    }

    public Teacher(Integer teacherTeacherId) {
        this.teacherTeacherId = teacherTeacherId;
    }

    public Teacher(Integer teacherTeacherId, String password, String teacherLoginNumber, String teacherName, String teacherSurname, int teacherAge, String teacherBranch, Date teacherStartedDate, Date teacherEndDate) {
        this.teacherTeacherId = teacherTeacherId;
        this.password = password;
        this.teacherLoginNumber = teacherLoginNumber;
        this.teacherName = teacherName;
        this.teacherSurname = teacherSurname;
        this.teacherAge = teacherAge;
        this.teacherBranch = teacherBranch;
        this.teacherStartedDate = teacherStartedDate;
        this.teacherEndDate = teacherEndDate;
    }

    public Integer getTeacherTeacherId() {
        return teacherTeacherId;
    }

    public void setTeacherTeacherId(Integer teacherTeacherId) {
        this.teacherTeacherId = teacherTeacherId;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTeacherLoginNumber() {
        return teacherLoginNumber;
    }

    public void setTeacherLoginNumber(String teacherLoginNumber) {
        this.teacherLoginNumber = teacherLoginNumber;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSurname() {
        return teacherSurname;
    }

    public void setTeacherSurname(String teacherSurname) {
        this.teacherSurname = teacherSurname;
    }

    public int getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(int teacherAge) {
        this.teacherAge = teacherAge;
    }

    public String getTeacherBranch() {
        return teacherBranch;
    }

    public void setTeacherBranch(String teacherBranch) {
        this.teacherBranch = teacherBranch;
    }

    public Date getTeacherStartedDate() {
        return teacherStartedDate;
    }

    public void setTeacherStartedDate(Date teacherStartedDate) {
        this.teacherStartedDate = teacherStartedDate;
    }

    public Date getTeacherEndDate() {
        return teacherEndDate;
    }

    public void setTeacherEndDate(Date teacherEndDate) {
        this.teacherEndDate = teacherEndDate;
    }

    @XmlTransient
    public List<Test> getTestList() {
        return testList;
    }

    public void setTestList(List<Test> testList) {
        this.testList = testList;
    }

    public School getTeacherSchoolId() {
        return teacherSchoolId;
    }

    public void setTeacherSchoolId(School teacherSchoolId) {
        this.teacherSchoolId = teacherSchoolId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teacherTeacherId != null ? teacherTeacherId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.teacherTeacherId == null && other.teacherTeacherId != null) || (this.teacherTeacherId != null && !this.teacherTeacherId.equals(other.teacherTeacherId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bitirmeprojesi.entity.Teacher[ teacherTeacherId=" + teacherTeacherId + " ]";
    }
    
}
