package ch.bbw.jf.backend.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Class: User
 *
 * @author Schules
 * @version 19.03.2024
 */
public class User {
    private UUID id;
    private String firstname;
    private String lastname;
    private String email;
    private String passwordHash;
    private List<Ticket> tickets;

    public User(String firstname, String lastname, String email, String passwordHash) {
        id = UUID.randomUUID();
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.passwordHash = passwordHash;
        tickets = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}
