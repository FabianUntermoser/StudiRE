package presentation.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class IndexController implements Serializable {

    public String createNewStudent() {
        return "edit";
    }

    public String listStudents() {
        return "list";
    }

}
