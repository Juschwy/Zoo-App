package ch.bbw.jf.backend.controller;

import ch.bbw.jf.backend.model.GetUserRequestDTO;
import ch.bbw.jf.backend.model.GetUserReturnDTO;
import ch.bbw.jf.backend.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Class: UserController
 *
 * @author Schules
 * @version 19.03.2024
 */

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:5173")
public class Controller {
    private List<User> users;

    public Controller(List<User> users) {
        this.users = users;
        users.add(new User("Any", "Nymous", "ano.nymous@email.com", "asdf"));
        users.add(new User("Inko", "Gnito", "inko.gnito@email.com", "asdf"));
    }

    public ResponseEntity<GetUserReturnDTO> login(@RequestBody GetUserRequestDTO userRequest){
        Optional<User> user = users.stream().filter(user1 -> user1.getEmail().equals(userRequest.getEmail())).findFirst();
        if (user.isPresent()){
            if (user.get().getPasswordHash().equals(userRequest.getPasswordHash())){
                return new ResponseEntity<>(new GetUserReturnDTO(user.get()), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
