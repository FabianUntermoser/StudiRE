package presentation.controller;

import business.domain.Student;
import business.service.IStudentService;
import presentation.controller.manager.StudentManager;
import presentation.util.Pages;
import presentation.util.Regex;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class EditController implements Serializable {

    private static int maximumPostalCodeSize = 4;

    @EJB
    private IStudentService studentService;

    private boolean inAddMode = false;

    private Student selectedStudent;

    @PostConstruct
    public void init() {
        selectedStudent = StudentManager.getSelectedStudent();
        if (selectedStudent == null) {
            selectedStudent = new Student();
            inAddMode = true;
        }
    }

    public boolean isInAddMode() {
        return inAddMode;
    }

    public void setInAddMode(boolean inAddMode) {
        this.inAddMode = inAddMode;
    }

    public Student getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(Student selectedStudent) {
        this.selectedStudent = selectedStudent;
    }

    public String getEmailPattern() {
        return Regex.EMAIL_PATTERN;
    }

    public Integer getMaximumPostalCodeSize() {
        return maximumPostalCodeSize;
    }

    public String create() {
        if (inAddMode) {
            studentService.addStudent(selectedStudent);
        } else {
            StudentManager.setSelectedStudent(null);
            studentService.updateStudent(selectedStudent);
        }
        return inAddMode ? Pages.INDEX_PAGE : Pages.LIST_PAGE;
    }
}
