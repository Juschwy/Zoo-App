package ch.bbw.jf.backend.contoller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class: TicketController
 *
 * @author Schules
 * @version 12.03.2024
 */

@RestController
public class TicketController {
    @GetMapping("/")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("test", HttpStatus.OK);
    }
}
