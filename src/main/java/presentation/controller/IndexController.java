package presentation.controller;

import presentation.util.Pages;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

// TODO: Provide Page for searching students by name
// TODO: Provide Login Page
// TODO: Use SSL encryption

@Named
@ViewScoped
public class IndexController implements Serializable {

    public String createNewStudent() {
        return Pages.EDIT_PAGE;
    }

    public String listStudents() {
        return Pages.LIST_PAGE;
    }

    public String searchStudents() {
        return Pages.SEARCH_PAGE;
    }

}