package ch.bbw.jf.backend.model;

/**
 * Class: GetUserRequestDTO
 *
 * @author Schules
 * @version 19.03.2024
 */
public class GetUserRequestDTO {
    private String email;
    private String passwordHash;

    public GetUserRequestDTO(String email, String passwordHash) {
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
