/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bitirmeprojesi.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Batuhan
 */
@Entity
@Table(name = "test")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Test.findAll", query = "SELECT t FROM Test t"),
    @NamedQuery(name = "Test.findByTestId", query = "SELECT t FROM Test t WHERE t.testId = :testId"),
    @NamedQuery(name = "Test.findByTestLessonName", query = "SELECT t FROM Test t WHERE t.testLessonName = :testLessonName"),
    @NamedQuery(name = "Test.findByTestName", query = "SELECT t FROM Test t WHERE t.testName = :testName"),
    @NamedQuery(name = "Test.findByTestTopicName", query = "SELECT t FROM Test t WHERE t.testTopicName = :testTopicName")})
public class Test implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Test_Id")
    private Integer testId;
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
    @JoinColumn(name = "Test_TeacherId", referencedColumnName = "Teacher_TeacherId")
    @ManyToOne
    private Teacher testTeacherId;

    public Test() {
    }

    public Test(Integer testId) {
        this.testId = testId;
    }

    public Test(Integer testId, byte[] testContains, String testLessonName, String testName, String testTopicName) {
        this.testId = testId;
        this.testContains = testContains;
        this.testLessonName = testLessonName;
        this.testName = testName;
        this.testTopicName = testTopicName;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
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

    public Teacher getTestTeacherId() {
        return testTeacherId;
    }

    public void setTestTeacherId(Teacher testTeacherId) {
        this.testTeacherId = testTeacherId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (testId != null ? testId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Test)) {
            return false;
        }
        Test other = (Test) object;
        if ((this.testId == null && other.testId != null) || (this.testId != null && !this.testId.equals(other.testId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bitirmeprojesi.entity.Test[ testId=" + testId + " ]";
    }
    
}
