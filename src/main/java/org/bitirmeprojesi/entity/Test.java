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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.config.CacheIsolationType;

/**
 *
 * @author Batuhan
 */
@Entity
@Table(name = "test")
@XmlRootElement
@Cache(
        type = CacheType.SOFT_WEAK,
        size = 64000,
        isolation = CacheIsolationType.SHARED,
        disableHits = true,
        alwaysRefresh = false,
        expiry = 36000000 //2 minutes
)
@NamedQueries({
    @NamedQuery(name = "Test.findAll", query = "SELECT t FROM Test t"),
    @NamedQuery(name = "Test.findByTestLessonName", query = "SELECT t FROM Test t WHERE t.testLessonName = :testLessonName"),
    @NamedQuery(name = "Test.findByTestName", query = "SELECT t FROM Test t WHERE t.testName = :testName"),
    @NamedQuery(name = "Test.findByTestTopicName", query = "SELECT t FROM Test t WHERE t.testTopicName = :testTopicName"),
    @NamedQuery(name = "Test.findByTestInsertedDate", query = "SELECT t FROM Test t WHERE t.testInsertedDate = :testInsertedDate"),
    @NamedQuery(name = "Test.findByTestUpdatedTime", query = "SELECT t FROM Test t WHERE t.testUpdatedTime = :testUpdatedTime")})
public class Test extends BasePersistenceObject implements Serializable {
    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Lob
    @Column(name = "Test_Contains")
    private byte[] testContains;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "Test_LessonName")
    private String testLessonName;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "Test_Name")
    private String testName;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "Test_TopicName")
    private String testTopicName;
    @Basic(optional = false)
    @Column(name = "Test_InsertedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date testInsertedDate;
    @Basic(optional = false)
    @Column(name = "Test_UpdatedTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date testUpdatedTime;
    @JoinColumn(name = "Test_TeacherId", referencedColumnName = "id")
    @ManyToOne
    private Teacher testTeacherId;

    public Test() {
    }

    public Test(Integer testId) {
        super(testId);
    }

    public Test(byte[] testContains, String testLessonName, String testName, String testTopicName, Date testInsertedDate, Date testUpdatedTime) {
        this.testContains = testContains;
        this.testLessonName = testLessonName;
        this.testName = testName;
        this.testTopicName = testTopicName;
        this.testInsertedDate = testInsertedDate;
        this.testUpdatedTime = testUpdatedTime;
    }



    public byte[] getTestContains() {
        return testContains;
    }

    public void setTestContains(byte[] testContains) {
        this.testContains = testContains;
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

    public Date getTestInsertedDate() {
        return testInsertedDate;
    }

    public void setTestInsertedDate(Date testInsertedDate) {
        this.testInsertedDate = testInsertedDate;
    }

    public Date getTestUpdatedTime() {
        return testUpdatedTime;
    }

    public void setTestUpdatedTime(Date testUpdatedTime) {
        this.testUpdatedTime = testUpdatedTime;
    }

    public Teacher getTestTeacherId() {
        return testTeacherId;
    }

    public void setTestTeacherId(Teacher testTeacherId) {
        this.testTeacherId = testTeacherId;
    }
}
