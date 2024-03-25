package ch.bbw.jf.backend.controller;

import ch.bbw.jf.backend.model.TicketUser;
import ch.bbw.jf.backend.model.TicketUserDTO;
import ch.bbw.jf.backend.repository.TicketUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.stream.Collectors;

/**
 * Class: TokenController
 *
 * @author Schules
 * @version 21.03.2024
 */
@RestController
@CrossOrigin("http://localhost:5173")
public class TokenController {
    private final JwtEncoder encoder;
    private final TicketUserRepository ticketUserRepository;

    @Autowired
    public TokenController(JwtEncoder encoder, TicketUserRepository ticketUserRepository) {
        this.encoder = encoder;
        this.ticketUserRepository = ticketUserRepository;
    }

    @PostMapping("/token")
    public ResponseEntity<TicketUserDTO> token(Authentication authentication) {
        Instant now = Instant.now();
        long expiry = 36000L;
        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject(authentication.getName())
                .claim("scope", scope)
                .build();
        TicketUser user = ticketUserRepository.findUserByUsername(authentication.getName());
        return new ResponseEntity<>(
                new TicketUserDTO(user.getLastname(),
                        user.getFirstname(),
                        user.getUsername(),
                        this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue(),
                        user.getRole()),
                HttpStatus.OK);
    }
}
