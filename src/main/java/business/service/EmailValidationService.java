package business.service;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Singleton;
import java.util.logging.Level;
import java.util.logging.Logger;

@RolesAllowed("Teacher")
@Singleton
public class EmailValidationService {

    // TODO: Send Validation Email here
    public void validateEmail(String email) {
        Logger.getLogger("EmailValidationService").log(Level.INFO, "Email validierung bei E-Mail: " + email);
    }

}
