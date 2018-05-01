package presentation.controller;

import business.domain.Student;
import business.service.IStudentService;
import presentation.controller.manager.StudentManager;
import presentation.util.Pages;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ListController implements Serializable {

    private String filter;

    @Inject
    private IStudentService studentService;

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public List<Student> getStudentList() {
        if (filter != null) return studentService.getStudentByName(filter);
        return studentService.getAllStudents();
    }

    public void removeStudent(Student student) {
        studentService.removeStudent(student);
    }

    public String updateStudent(Student student) {
        StudentManager.setSelectedStudent(student);
        return Pages.EDIT_PAGE;
    }

}
