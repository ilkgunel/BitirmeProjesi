/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitirmeprojesi.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.faces.model.SelectItem;
import org.apache.commons.io.IOUtils;
import org.bitirmeprojesi.dto.DTO;
import org.bitirmeprojesi.entity.Teacher;
import org.bitirmeprojesi.entity.Test;
import org.bitirmeprojesi.service.TeacherOperationsDAOImplService;
import org.bitirmeprojesi.service.TestOperationsDAOImplService;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Batuhan
 */
@ManagedBean(name = "testControllerBean")
@SessionScoped
public class TestControllerBean implements Serializable {

    private Test test = new Test();
    private UploadedFile uploadedFile;
    private Teacher unSelectedTeacherId = new Teacher();
    public List<Teacher> teacherList = new ArrayList<Teacher>();
    private List<Test> testList = new ArrayList<Test>();
    private List<SelectItem> testNameList = new ArrayList<SelectItem>();
    private List<SelectItem> testTopicList = new ArrayList<SelectItem>();

    @EJB
    TeacherOperationsDAOImplService teacherOperationsDAOImplService;

    @EJB
    TestOperationsDAOImplService testOperationsDAOImplService;

    @PostConstruct
    public void init() {
        teacherList = teacherOperationsDAOImplService.getTeachersFromService();
        testList = testOperationsDAOImplService.getTestListFromService();
    }

    public String insertTestFromBean() throws IOException {
        byte[] fileContent = IOUtils.toByteArray(uploadedFile.getInputstream());
        if (fileContent != null) {
            test.setTestContains(fileContent);
        } else {
            fileContent = new byte[1024];
            test.setTestContains(fileContent);
        }
        DTO dto = testOperationsDAOImplService.insertTestFromService(test);
        if (dto.isSuccess()) {
            test = new Test();
            setTest(test);
            testList = testOperationsDAOImplService.getTestListFromService();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, dto.getMessage(), null));
            return "/testWorks/testList.xhtml?faces-redirect=true";
        } else {
             FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, dto.getMessage(), null));
            return "";
        }
    }

    public StreamedContent getTestContent() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        } else {
            // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
            String testId = context.getExternalContext().getRequestParameterMap().get("testId");
            Test test = testOperationsDAOImplService.findTestByIdFromService(Integer.parseInt(testId));
            return new DefaultStreamedContent(new ByteArrayInputStream(test.getTestContains()));
        }
    }

    public List<SelectItem> getTestLessonNameList() {
        List<SelectItem> testLessonNameList = new ArrayList<SelectItem>();
        testLessonNameList.add(new SelectItem("Matematik", "Matematik"));
        testLessonNameList.add(new SelectItem("Türkce", "Türkçe"));

        return testLessonNameList;
    }

    public List<SelectItem> refreshTestNameList() {
        testNameList = new ArrayList<SelectItem>();

        if (test.getTestLessonName() == null) {
            return testNameList;
        } else if (test.getTestLessonName().equals("Matematik") && test.getTestLessonName() != null) {
            testNameList.add(new SelectItem("Üslü Sayılar", "Üslü Sayılar"));
            testNameList.add(new SelectItem("Doğal Sayılar", "Doğal Sayılar"));
            testNameList.add(new SelectItem("Asal Sayılar", "Asal Sayılar"));
            return testNameList;
        } else if (test.getTestLessonName().equals("Türkce") && test.getTestLessonName() != null) {
            testNameList.add(new SelectItem("Sözcükte Anlam", "Sözcükte Anlam"));
            testNameList.add(new SelectItem("Cümlede Anlam", "Cümlede Anlam"));
            testNameList.add(new SelectItem("Paragrafta Anlam", "Paragrafta Anlam"));
            return testNameList;
        }

        return testNameList;
    }

    public List<SelectItem> refreshTestTopicList() {
        testTopicList = new ArrayList<SelectItem>();
        if (test.getTestName() == null) {
            return testTopicList;
        } else if (test.getTestName().equals("Üslü Sayılar") && test.getTestName() != null) {
            testTopicList.add(new SelectItem("Üslü Sayılara Giriş", "Üslü Sayılara Giriiş"));
            testTopicList.add(new SelectItem("Üslü Sayılarla İşlemler", "Üslü Sayılarla İşlemler"));
            testTopicList.add(new SelectItem("Üslü Sayılarla Problemler Çözme", "Üslü Sayılarla Problemler Çözme"));
            return testTopicList;
        } else if (test.getTestName().equals("Doğal Sayılar") && test.getTestName() != null) {
            testTopicList.add(new SelectItem("Doğal Sayılara Giriş", "Doğal Sayılara Giriş"));
            testTopicList.add(new SelectItem("Doğal Sayılarla İşlemler", "Doğal Sayılarla İşlemler"));
            testTopicList.add(new SelectItem("Doğal Sayılarla Problemler Çözme", "Doğal Sayılarla Problemler Çözme"));
            return testTopicList;
        } else if (test.getTestName().equals("Asal Sayılar") && test.getTestName() != null) {
            testTopicList.add(new SelectItem("Asal Sayılara Giriş", "Asal Sayılara Giriş"));
            testTopicList.add(new SelectItem("Asal Sayılarla İşlemler", "Asal Sayılarla İşlemler"));
            testTopicList.add(new SelectItem("Asal Sayılarla Problemler Çözme", "Asal Sayılarla Problemler Çözme"));
            return testTopicList;
        } else if (test.getTestName().equals("Sözcükte Anlam") && test.getTestName() != null) {
            testTopicList.add(new SelectItem("Sözcükte Anlam Özellikleri", "Sözcükte Anlam Özellikleri"));
            testTopicList.add(new SelectItem("Sözcükler Arası Anlam İlişkileri", "Sözcükler Arası Anlam İlişkileri"));
            testTopicList.add(new SelectItem("Söz Öbekleri", "Söz Öbekleri "));
            return testTopicList;
        } else if (test.getTestName().equals("Cümlede Anlam") && test.getTestName() != null) {
            testTopicList.add(new SelectItem("Cümlede Anlam İlişkileri", "Cümlede Anlam İlişkileri"));
            testTopicList.add(new SelectItem("Anlatımına Göre Cümleler", "Anlatımına Göre Cümleler"));
            testTopicList.add(new SelectItem("Cümle Yorumlama", "Cümle Yorumlama"));
            return testTopicList;
        } else if (test.getTestName().equals("Paragrafta Anlam") && test.getTestName() != null) {
            testTopicList.add(new SelectItem("Paragrafın Anlam Yönü", "Paragrafın Anlam Yönü"));
            testTopicList.add(new SelectItem("Paragrafın Yapı Yönü", "Paragrafın Yapı Yönü"));
            testTopicList.add(new SelectItem("Paragrafın Anlatım Yönü", "Paragrafın Anlatım Yönü"));
            return testTopicList;
        }

        return testTopicList;
    }

    public Teacher getUnSelectedTeacherId() {
        return unSelectedTeacherId;
    }

    public void setUnSelectedTeacherId(Teacher unSelectedTeacherId) {
        this.unSelectedTeacherId = unSelectedTeacherId;
    }

    

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public List<SelectItem> getTestNameList() {
        return testNameList;
    }

    public void setTestNameList(List<SelectItem> testNameList) {
        this.testNameList = testNameList;
    }

    public List<SelectItem> getTestTopicList() {
        return testTopicList;
    }

    public void setTestTopicList(List<SelectItem> testTopicList) {
        this.testTopicList = testTopicList;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Test> getTestList() {
        return testList;
    }

    public void setTestList(List<Test> testList) {
        this.testList = testList;
    }

}
