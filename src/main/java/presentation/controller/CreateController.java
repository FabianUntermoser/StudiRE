package presentation.controller;

import business.model.Student;
import business.service.StudentService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class CreateController implements Serializable {
    private static int maximumPostalCodeSize = 4;

    @Inject
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

    public void create() {
        Student student = new Student(firstName, lastName, Integer.valueOf(postalCode), street, location);
        System.out.println("student created");
        studentService.addStudent(student);
    }

    public Integer getMaximumPostalCodeSize() {
        return maximumPostalCodeSize;
    }
}
