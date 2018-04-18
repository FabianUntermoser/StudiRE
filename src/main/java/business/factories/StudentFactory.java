package business.factories;

import business.model.Student;

public class StudentFactory {

    public static Student createStudent(String firstName, String lastName, Integer postalCode, String street, String location) {
        long matriculationNumber = NextMatriculationNumberGenerator.generateNextNumber();
        return new Student(matriculationNumber, firstName, lastName, postalCode, street, location);
    }

}
