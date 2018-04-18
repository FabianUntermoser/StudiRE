package presentation.controller;

import business.domain.Student;
import business.service.IStudentService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ListController implements Serializable {

    @Inject
    private IStudentService studentService;

    public List<Student> getStudentList() {
        return studentService.getAllStudents();
    }

}
