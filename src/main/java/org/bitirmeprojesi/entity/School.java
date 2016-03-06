/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bitirmeprojesi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "school")
@Cache(
        type = CacheType.SOFT_WEAK,
        size = 64000,
        isolation = CacheIsolationType.SHARED,
        disableHits = true,
        alwaysRefresh = false,
        expiry = 7200000 //2 minutes
)
@ExistenceChecking(ExistenceType.CHECK_CACHE)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "School.findAll", query = "SELECT s FROM School s"),
    @NamedQuery(name = "School.findById", query = "SELECT s FROM School s WHERE s.id = :id"),
    @NamedQuery(name = "School.findBySchoolCity", query = "SELECT s FROM School s WHERE s.schoolCity = :schoolCity"),
    @NamedQuery(name = "School.findBySchoolDistrict", query = "SELECT s FROM School s WHERE s.schoolDistrict = :schoolDistrict"),
    @NamedQuery(name = "School.findBySchoolName", query = "SELECT s FROM School s WHERE s.schoolName = :schoolName"),
    @NamedQuery(name = "School.findBySchoolfoundationYear", query = "SELECT s FROM School s WHERE s.schoolfoundationYear = :schoolfoundationYear")})
public class School extends BasePersistenceObject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "School_City")
    private String schoolCity;
    @Size(max = 255)
    @Column(name = "School_District")
    private String schoolDistrict;
    @Size(max = 255)
    @Column(name = "School_Name")
    private String schoolName;
    @Column(name = "School_foundationYear")
    @Temporal(TemporalType.DATE)
    private Date schoolfoundationYear;
    @OneToMany(mappedBy = "teacherSchoolId")
    private List<Teacher> teacherList;

    public School() {
    }

    public School(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return getId();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchoolCity() {
        return schoolCity;
    }

    public void setSchoolCity(String schoolCity) {
        this.schoolCity = schoolCity;
    }

    public String getSchoolDistrict() {
        return schoolDistrict;
    }

    public void setSchoolDistrict(String schoolDistrict) {
        this.schoolDistrict = schoolDistrict;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Date getSchoolfoundationYear() {
        return schoolfoundationYear;
    }

    public void setSchoolfoundationYear(Date schoolfoundationYear) {
        this.schoolfoundationYear = schoolfoundationYear;
    }

    @XmlTransient
    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
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
        if (!(object instanceof School)) {
            return false;
        }
        School other = (School) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bitirmeprojesi.entity.School[ id=" + id + " ]";
    }
    
}
