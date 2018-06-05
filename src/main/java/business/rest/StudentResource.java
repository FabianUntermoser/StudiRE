package business.rest;

import business.domain.Student;
import business.service.IStudentService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/teacher/student")
public class StudentResource {

    @Inject
    private IStudentService studentService;

    @GET
    @Path("/list")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

}
