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
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "test", catalog = "e_odev", schema = "")
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
    @NamedQuery(name = "Test.findAll", query = "SELECT t FROM Test t"),
    @NamedQuery(name = "Test.findById", query = "SELECT t FROM Test t WHERE t.id = :id"),
    @NamedQuery(name = "Test.findByTestInsertedDate", query = "SELECT t FROM Test t WHERE t.testInsertedDate = :testInsertedDate"),
    @NamedQuery(name = "Test.findByTestLessonName", query = "SELECT t FROM Test t WHERE t.testLessonName = :testLessonName"),
    @NamedQuery(name = "Test.findByTestName", query = "SELECT t FROM Test t WHERE t.testName = :testName"),
    @NamedQuery(name = "Test.findByTestTopicName", query = "SELECT t FROM Test t WHERE t.testTopicName = :testTopicName"),
    @NamedQuery(name = "Test.findByTestUpdatedTime", query = "SELECT t FROM Test t WHERE t.testUpdatedTime = :testUpdatedTime")})
public class Test extends BasePersistenceObject implements Serializable {

    private static final long serialVersionUID = 1L;

    @Lob
    @Column(name = "Test_Contains")
    private byte[] testContains;
    @Column(name = "Test_InsertedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date testInsertedDate;
    @Size(max = 255)
    @Column(name = "Test_LessonName")
    private String testLessonName;
    @Size(max = 255)
    @Column(name = "Test_Name")
    private String testName;
    @Size(max = 255)
    @Column(name = "Test_TopicName")
    private String testTopicName;
    @Column(name = "Test_UpdatedTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date testUpdatedTime;
    @OneToMany(mappedBy = "sATestId")
    private List<StudentAssesment> studentAssesmentList;
    @JoinColumn(name = "Test_TeacherId", referencedColumnName = "id")
    @ManyToOne
    private Teacher testTeacherId;

    public Test() {
    }

    public Test(Integer id) {
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

    public byte[] getTestContains() {
        return testContains;
    }

    public void setTestContains(byte[] testContains) {
        this.testContains = testContains;
    }

    public Date getTestInsertedDate() {
        return testInsertedDate;
    }

    public void setTestInsertedDate(Date testInsertedDate) {
        this.testInsertedDate = testInsertedDate;
    }

    public String getTestLessonName() {
        return testLessonName;
    }

    public void setTestLessonName(String testLessonName) {
        this.testLessonName = testLessonName;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestTopicName() {
        return testTopicName;
    }

    public void setTestTopicName(String testTopicName) {
        this.testTopicName = testTopicName;
    }

    public Date getTestUpdatedTime() {
        return testUpdatedTime;
    }

    public void setTestUpdatedTime(Date testUpdatedTime) {
        this.testUpdatedTime = testUpdatedTime;
    }

    @XmlTransient
    public List<StudentAssesment> getStudentAssesmentList() {
        return studentAssesmentList;
    }

    public void setStudentAssesmentList(List<StudentAssesment> studentAssesmentList) {
        this.studentAssesmentList = studentAssesmentList;
    }

    public Teacher getTestTeacherId() {
        return testTeacherId;
    }

    public void setTestTeacherId(Teacher testTeacherId) {
        this.testTeacherId = testTeacherId;
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
        if (!(object instanceof Test)) {
            return false;
        }
        Test other = (Test) object;
        if ((super.getId() == null && other.getId() != null) || (super.getId() != null && !super.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bitirmeprojesi.entity.Test[ id=" + super.getId() + " ]";
    }

}
