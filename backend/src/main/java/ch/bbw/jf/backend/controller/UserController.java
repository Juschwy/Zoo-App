package ch.bbw.jf.backend.controller;

import ch.bbw.jf.backend.model.TicketUser;
import ch.bbw.jf.backend.model.TicketUserCreateDTO;
import ch.bbw.jf.backend.model.TicketUserDTO;
import ch.bbw.jf.backend.repository.TicketUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Class: UserController
 *
 * @author Schules
 * @version 21.03.2024
 */

@RestController
@RequestMapping({"/users", "/users/"})
@CrossOrigin("http://localhost:5173")
public class UserController {
    private final TicketUserRepository ticketUserRepository;

    @Autowired
    public UserController(TicketUserRepository ticketUserRepository) {
        this.ticketUserRepository = ticketUserRepository;
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody TicketUserCreateDTO dto){
        System.out.println("/users:POST");
        try {
            TicketUser user = ticketUserRepository.createUser(dto.getUsername(), dto.getPassword(), dto.getFirstname(), dto.getLastname());
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
