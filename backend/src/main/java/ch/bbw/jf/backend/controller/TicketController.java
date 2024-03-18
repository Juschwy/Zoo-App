package ch.bbw.jf.backend.controller;

import ch.bbw.jf.backend.model.CreateTicketDTO;
import ch.bbw.jf.backend.model.Ticket;
import ch.bbw.jf.backend.model.TicketCategory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Class: TicketController
 *
 * @author Schules
 * @version 12.03.2024
 */

@RestController
@RequestMapping("/tickets")
@CrossOrigin("http://localhost:5173")
public class TicketController {
    private List<Ticket> tickets;

    public TicketController(List<Ticket> tickets) {
        this.tickets = tickets;
        Map<TicketCategory, Integer> order = new HashMap<>();
        order.put(TicketCategory.ADULT, 1);
        tickets.add(new Ticket("Ano", "Nymous", LocalDateTime.MIN, LocalDateTime.MAX, order));
        tickets.add(new Ticket("Ano", "Nymous", LocalDateTime.MIN, LocalDateTime.MAX, order, "TEST"));
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getTickets(){
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable UUID id){
        Optional<Ticket> ticket = tickets.stream().filter((ticket1 -> ticket1.getId().toString().equals(id.toString()))).findFirst();
        if (ticket.isPresent()){
            return new ResponseEntity<>(ticket.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody CreateTicketDTO ticketDTO){
        System.out.println(ticketDTO.getIdId());
        Ticket ticket = new Ticket(ticketDTO.getCustomerFirstname(), ticketDTO.getCustomerLastname(), ticketDTO.getValidFrom(), ticketDTO.getValidTo(), ticketDTO.getOrderContent());
        tickets.add(ticket);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }
}
