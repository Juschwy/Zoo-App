package ch.bbw.jf.backend.model;

/**
 * Class: TicketUserResponseDTO
 *
 * @author Schules
 * @version 21.03.2024
 */
public class TicketUserDTO {
    private final String lastname;
    private final String firstname;
    private final String username;

    public TicketUserDTO(String lastname, String firstname, String username) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getUsername() {
        return username;
    }
}
