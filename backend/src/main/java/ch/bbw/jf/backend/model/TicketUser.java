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
    private final TicketUserRole role;
    private final List<Ticket> tickets;

    public TicketUser(String firstname, String lastname, String username, String password, UserDetailsManager userDetailsManager, TicketUserRole role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.role = role;
        userDetailsManager.createUser(User
                .withUsername(username)
                .password(password)
                .authorities(role.name())
                .build());
        tickets = new ArrayList<>();
    }

    public TicketUser(String firstname, String lastname, String username, String password, UserDetailsManager userDetailsManager) {
        this(firstname, lastname, username, password, userDetailsManager, TicketUserRole.USER);
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

    public TicketUserRole getRole() {
        return role;
    }
}
