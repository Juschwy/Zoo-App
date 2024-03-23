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
    private final TicketUserRole role;
    private final String token;

    public TicketUserDTO(String lastname, String firstname, String username, String token, TicketUserRole role) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.username = username;
        this.token = token;
        this.role = role;
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

    public String getToken() {
        return token;
    }

    public TicketUserRole getRole() {
        return role;
    }
}
