package business.model;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@RequestScoped
@Named
public class Student implements Serializable {

    private long matriculationNumber;
    private String firstName, lastName;
    private Integer postalCode;
    private String street, location;

    public Student() {
    }

    public Student(String firstName, String lastName, Integer postalCode, String street, String location) {
        this.matriculationNumber = generateId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
        this.street = street;
        this.location = location;
        System.out.println("student id: " + matriculationNumber);
    }

    public long getMatriculationNumber() {
        return matriculationNumber;
    }

    public void setMatriculationNumber(long matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }

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

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
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

    /**
     * Format: “<Aktuelles-Jahr-2-stellig><Nummer-Uni-2-stellig><Nummer-fortlaufend-3-stellig>”;
     * Beispiel: “1530312” (15=2015, 30=TU Graz, 312=fortlaufende Nummer);
     *
     * @return matriculation Number
     */
    private long generateId() {
        // get last two digits of current year
        int currentYear = Calendar.getInstance().get(Calendar.YEAR) % 100;
        int uniId = 30;
        String matriculationNumber = String.valueOf(currentYear) + String.valueOf(uniId);
        //TODO: auto generate three numbers with JPA
        return Long.parseLong(matriculationNumber);
    }
}