package ch.bbw.jf.backend.model;

/**
 * Class: CreateTicketUserDTO
 *
 * @author Schules
 * @version 21.03.2024
 */
public class TicketUserCreateDTO {
    private final String firstname;
    private final String lastname;
    private final String username;
    private final String password;

    public TicketUserCreateDTO(String firstname, String lastname, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
