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
@Table(name = "school")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "School.findAll", query = "SELECT s FROM School s"),
    @NamedQuery(name = "School.findBySchooldId", query = "SELECT s FROM School s WHERE s.schooldId = :schooldId"),
    @NamedQuery(name = "School.findBySchoolCity", query = "SELECT s FROM School s WHERE s.schoolCity = :schoolCity"),
    @NamedQuery(name = "School.findBySchoolDistrict", query = "SELECT s FROM School s WHERE s.schoolDistrict = :schoolDistrict"),
    @NamedQuery(name = "School.findBySchoolName", query = "SELECT s FROM School s WHERE s.schoolName = :schoolName"),
    @NamedQuery(name = "School.findBySchoolfoundationYear", query = "SELECT s FROM School s WHERE s.schoolfoundationYear = :schoolfoundationYear")})
public class School implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Schoold_Id")
    private Integer schooldId;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "School_City")
    private String schoolCity;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "School_District")
    private String schoolDistrict;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "School_Name")
    private String schoolName;
    @Basic(optional = false)
    @Column(name = "School_foundationYear")
    @Temporal(TemporalType.DATE)
    private Date schoolfoundationYear;
    @OneToMany(mappedBy = "teacherSchoolId")
    private List<Teacher> teacherList;

    public School() {
    }

    public School(Integer schooldId) {
        this.schooldId = schooldId;
    }

    public School(Integer schooldId, String schoolCity, String schoolDistrict, String schoolName, Date schoolfoundationYear) {
        this.schooldId = schooldId;
        this.schoolCity = schoolCity;
        this.schoolDistrict = schoolDistrict;
        this.schoolName = schoolName;
        this.schoolfoundationYear = schoolfoundationYear;
    }

    public Integer getSchooldId() {
        return schooldId;
    }

    public void setSchooldId(Integer schooldId) {
        this.schooldId = schooldId;
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
        hash += (schooldId != null ? schooldId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof School)) {
            return false;
        }
        School other = (School) object;
        if ((this.schooldId == null && other.schooldId != null) || (this.schooldId != null && !this.schooldId.equals(other.schooldId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bitirmeprojesi.entity.School[ schooldId=" + schooldId + " ]";
    }
    
}
