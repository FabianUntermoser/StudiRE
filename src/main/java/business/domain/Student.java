package business.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
        @NamedQuery(name = Student.findAll, query = "SELECT s FROM Student s"),
        @NamedQuery(name = Student.findLastMatriculationNumber, query = "SELECT s.matriculationNumber FROM Student s ORDER BY s.matriculationNumber DESC"),
        @NamedQuery(
                name = Student.findByName,
                query = "SELECT s FROM Student s " +
                        "WHERE lower(s.firstName) LIKE :name OR lower(s.lastName) LIKE :name " +
                        "ORDER BY s.matriculationNumber DESC"
        )
})

@Entity
public class Student {

    public static final String findAll = "Student.findAll",
            findLastMatriculationNumber = "Student.findLastMatriculationNumber",
            findByName = "Student.findByName";

    @Id
    private long matriculationNumber;
    private String firstName, lastName;
    private Integer postalCode;
    private String street, location;

    public Student() {
    }

    public Student(long matriculationNumber, String firstName, String lastName, Integer postalCode, String street, String location) {
        this.matriculationNumber = matriculationNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
        this.street = street;
        this.location = location;
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

}
