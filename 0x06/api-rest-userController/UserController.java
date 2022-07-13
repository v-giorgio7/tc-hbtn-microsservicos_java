

import com.example.user.exception.CPFException;
import com.example.user.exception.UserIdException;
import com.example.user.exception.UserNameException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.user.util.UserValidations.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping("/user-id/{id}")
    public String findUserById(@PathVariable int id) {
        if (isIdValid(id)) {
            return "You have entered valid ID";
        } else {
            throw new UserIdException(String.valueOf(id));
        }
    }

    @GetMapping("/user-name/{userName}")
    public String findUserByName(@PathVariable String userName) {
        if (isUsernameValid(userName)) {
            return "You have entered valid USERNAME";
        } else {
            throw new UserNameException(userName);
        }
    }

    @GetMapping("/user-cpf/{cpf}")
    public String findUserByCPF(@PathVariable String cpf) {
        if (isCPFValid(cpf)) {
            return "You have entered valid CPF";
        } else {
            throw new CPFException(cpf);
        }
    }
}
