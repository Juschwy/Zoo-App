package ch.bbw.jf.backend.model;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.UserDetailsManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Class: User
 *
 * @author Schules
 * @version 19.03.2024
 */
public class TicketUser {
    private final String firstname;
    private final String lastname;
    private final String username;
    private final List<Ticket> tickets;

    public TicketUser(String firstname, String lastname, String username, String password, UserDetailsManager userDetailsManager, String authority) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        userDetailsManager.createUser(User
                .withUsername(username)
                .password(password)
                .authorities(authority)
                .build());
        tickets = new ArrayList<>();
    }

    public TicketUser(String firstname, String lastname, String username, String password, UserDetailsManager userDetailsManager) {
        this(firstname, lastname, username, password, userDetailsManager, "USER");
    }


    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public String getUsername() {
        return username;
    }
}
