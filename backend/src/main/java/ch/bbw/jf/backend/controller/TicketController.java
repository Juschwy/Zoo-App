package ch.bbw.jf.backend.controller;

import ch.bbw.jf.backend.model.TicketCreateDTO;
import ch.bbw.jf.backend.model.Ticket;
import ch.bbw.jf.backend.model.TicketUserRole;
import ch.bbw.jf.backend.repository.TicketUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Class: TicketController
 *
 * @author Schules
 * @version 12.03.2024
 */

@RestController
@RequestMapping({"/tickets/", "/tickets"})
@CrossOrigin("http://localhost:5173")
public class TicketController {
    private final TicketUserRepository ticketUserRepository;

    @Autowired
    public TicketController(TicketUserRepository ticketUserRepository) {
        this.ticketUserRepository = ticketUserRepository;
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getTickets(Authentication authentication) {
        try {
            return new ResponseEntity<>(ticketUserRepository.findTicketsByUsername(authentication.getName()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Ticket> getTicket(Authentication authentication, @PathVariable UUID id) {
        if (authentication.getAuthorities().stream().noneMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("SCOPE_" + TicketUserRole.ADMIN.name()))){
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
            try {
                return new ResponseEntity<>(ticketUserRepository.findTicketById(id), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @PostMapping
        public ResponseEntity<Ticket> createTicket (Authentication authentication, @RequestBody TicketCreateDTO
        ticketDTO){
            try {
                return new ResponseEntity<>(ticketUserRepository.createTicket(authentication.getName(),
                        ticketDTO.getValidFrom(),
                        ticketDTO.getValidTo(),
                        ticketDTO.getOrderContent(),
                        ticketDTO.getIdId()),
                        HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }
