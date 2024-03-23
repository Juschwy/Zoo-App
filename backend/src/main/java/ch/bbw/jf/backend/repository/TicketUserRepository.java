package ch.bbw.jf.backend.repository;

import ch.bbw.jf.backend.model.Ticket;
import ch.bbw.jf.backend.model.TicketCategory;
import ch.bbw.jf.backend.model.TicketUser;
import ch.bbw.jf.backend.model.TicketUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Class: UserRepository
 *
 * @author Schules
 * @version 21.03.2024
 */

@Repository
public class TicketUserRepository {
    private final UserDetailsManager userDetailsManager;
    private final List<TicketUser> users;

    @Autowired
    public TicketUserRepository(UserDetailsService userDetailsService) {
        this.userDetailsManager = (UserDetailsManager) userDetailsService;
        users = new ArrayList<>();
        createUser("ano.nymous@email.com", "{noop}asdf", "Ano", "Nymous", TicketUserRole.ADMIN);
        createUser("inko.gnito@email.com", "{noop}asdf", "Inko", "Gnito");
    }

    public TicketUser createUser(String username, String password, String firstname, String lastname, TicketUserRole role) {
        TicketUser user = new TicketUser(firstname, lastname, username, password, userDetailsManager, role);
        users.add(user);
        return user;
    }

    public TicketUser createUser(String username, String password, String firstname, String lastname){
        TicketUser user = new TicketUser(firstname, lastname, username, password, userDetailsManager);
        users.add(user);
        return user;
    }

    public TicketUser findUserByUsername(String username) {
        return users.stream().filter(user -> user.getUsername().equals(username)).findFirst().get();
    }

    public List<Ticket> findTicketsByUsername(String username) {
        return findUserByUsername(username).getTickets();
    }

    public List<Ticket> findAllTickets() {
        return users.stream()
                .flatMap(ticketUser -> ticketUser.getTickets().stream())
                .collect(Collectors.toList());
    }

    public Ticket findTicketById(UUID id){
        return findAllTickets().stream().filter(ticket -> ticket.getId().toString().equals(id.toString())).findFirst().get();
    }

    public Ticket createTicket(String username, LocalDateTime validFrom, LocalDateTime validTo, Map<TicketCategory, Integer> orderContent, String idId){
        Ticket ticket = new Ticket(validFrom, validTo, orderContent, idId);
        findTicketsByUsername(username).add(ticket);
        return ticket;
    }

}
