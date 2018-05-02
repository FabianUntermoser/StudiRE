package presentation.controller;

import presentation.util.Pages;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class IndexController implements Serializable {

    public String createNewStudent() {
        return Pages.EDIT_PAGE;
    }

    public String listStudents() {
        return Pages.LIST_PAGE;
    }

}