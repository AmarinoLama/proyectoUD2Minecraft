import edu.badpals.proyectoud2minecraft.Controller.ControllerLogin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    @Test
    public void testContrasenasValidas() {

        String validUser = "evan";
        String validPass = "abc";

        assertTrue(ControllerLogin.validatePass(validUser, validPass));

    }

    @Test
    public void testContrasenasInvalidas() {

        String invalidUser = "aman";
        String invalidPass = "Pass";

        assertFalse(ControllerLogin.validatePass(invalidUser, invalidPass));

    }

    @Test
    public void testUsuarioNoExiste() {

        String userNotExist = "aaaaa";
        String pwdNotExist = "Pass";

        assertFalse(ControllerLogin.validatePass(userNotExist, pwdNotExist));

    }
}