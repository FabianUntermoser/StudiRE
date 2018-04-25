package business.service;

import business.domain.Student;

import java.util.List;

public interface IStudentService {

    List<Student> getAllStudents();

    void addStudent(Student student);

    void removeStudent(Student student);

    void updateStudent(Student student);
}
