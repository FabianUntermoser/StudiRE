package business.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
        @NamedQuery(name = Teacher.findByEmail, query = "SELECT t from Teacher t WHERE t.email = :email")
})

@Entity
public class Teacher {

    public static final String findByEmail = "Teacher.findByEmail";

    @Id
    private String email;

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
