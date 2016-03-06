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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
@Table(name = "teacher")
@XmlRootElement
@Cache(
        type = CacheType.SOFT_WEAK,
        size = 100,
        isolation = CacheIsolationType.SHARED,
        disableHits = true,
        alwaysRefresh = false,
        expiry = 7200000 //2 minutes
)
@ExistenceChecking(ExistenceType.CHECK_CACHE)
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t"),
    @NamedQuery(name = "Teacher.findById", query = "SELECT t FROM Teacher t WHERE t.id = :id"),
    @NamedQuery(name = "Teacher.findByEnabled", query = "SELECT t FROM Teacher t WHERE t.enabled = :enabled"),
    @NamedQuery(name = "Teacher.findByPassword", query = "SELECT t FROM Teacher t WHERE t.password = :password"),
    @NamedQuery(name = "Teacher.findByTeacherAge", query = "SELECT t FROM Teacher t WHERE t.teacherAge = :teacherAge"),
    @NamedQuery(name = "Teacher.findByTeacherBranch", query = "SELECT t FROM Teacher t WHERE t.teacherBranch = :teacherBranch"),
    @NamedQuery(name = "Teacher.findByTeacherEndDate", query = "SELECT t FROM Teacher t WHERE t.teacherEndDate = :teacherEndDate"),
    @NamedQuery(name = "Teacher.findByTeacherLoginNumber", query = "SELECT t FROM Teacher t WHERE t.teacherLoginNumber = :teacherLoginNumber"),
    @NamedQuery(name = "Teacher.findByTeacherName", query = "SELECT t FROM Teacher t WHERE t.teacherName = :teacherName"),
    @NamedQuery(name = "Teacher.findByTeacherStartedDate", query = "SELECT t FROM Teacher t WHERE t.teacherStartedDate = :teacherStartedDate"),
    @NamedQuery(name = "Teacher.findByTeacherSurname", query = "SELECT t FROM Teacher t WHERE t.teacherSurname = :teacherSurname")})
public class Teacher extends BasePersistenceObject implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "enabled")
    private Boolean enabled;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    @Column(name = "Teacher_Age")
    private Integer teacherAge;
    @Size(max = 255)
    @Column(name = "Teacher_Branch")
    private String teacherBranch;
    @Column(name = "Teacher_End_Date")
    @Temporal(TemporalType.DATE)
    private Date teacherEndDate;
    @Size(max = 255)
    @Column(name = "Teacher_LoginNumber")
    private String teacherLoginNumber;
    @Size(max = 255)
    @Column(name = "Teacher_Name")
    private String teacherName;
    @Column(name = "Teacher_Started_Date")
    @Temporal(TemporalType.DATE)
    private Date teacherStartedDate;
    @Size(max = 255)
    @Column(name = "Teacher_Surname")
    private String teacherSurname;
    @JoinColumn(name = "Teacher_SchoolId", referencedColumnName = "id")
    @ManyToOne
    private School teacherSchoolId;

    public Teacher() {
    }

    public Teacher(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
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

    public Integer getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(Integer teacherAge) {
        this.teacherAge = teacherAge;
    }

    public String getTeacherBranch() {
        return teacherBranch;
    }

    public void setTeacherBranch(String teacherBranch) {
        this.teacherBranch = teacherBranch;
    }

    public Date getTeacherEndDate() {
        return teacherEndDate;
    }

    public void setTeacherEndDate(Date teacherEndDate) {
        this.teacherEndDate = teacherEndDate;
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

    public Date getTeacherStartedDate() {
        return teacherStartedDate;
    }

    public void setTeacherStartedDate(Date teacherStartedDate) {
        this.teacherStartedDate = teacherStartedDate;
    }

    public String getTeacherSurname() {
        return teacherSurname;
    }

    public void setTeacherSurname(String teacherSurname) {
        this.teacherSurname = teacherSurname;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bitirmeprojesi.entity.Teacher[ id=" + id + " ]";
    }

}
