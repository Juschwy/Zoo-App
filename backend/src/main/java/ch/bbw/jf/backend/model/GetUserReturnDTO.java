package ch.bbw.jf.backend.model;

import ch.bbw.jf.backend.security.JwtUtil;

/**
 * Class: UserDTO
 *
 * @author Schules
 * @version 19.03.2024
 */
public class GetUserReturnDTO {
    private String firstname;
    private String lastname;
    private String email;
    private String token;

    public GetUserReturnDTO(User user) {
        firstname = user.getFirstname();
        lastname = user.getLastname();
        email = user.getEmail();
        token = JwtUtil.generateToken(user.getId().toString());
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

    public String getToken() {
        return token;
    }
}
