package presentation.controller;

import business.domain.Student;
import business.factories.StudentFactory;
import business.service.StudentService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class CreateController implements Serializable {
    private static int maximumPostalCodeSize = 4;

    @EJB
    private StudentService studentService;

    private String firstName, lastName, street, location, postalCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String create() {
        Student student = StudentFactory.createStudent(firstName, lastName, Integer.valueOf(postalCode), street, location);
        studentService.addStudent(student);
        return "index";
    }

    public Integer getMaximumPostalCodeSize() {
        return maximumPostalCodeSize;
    }
}
