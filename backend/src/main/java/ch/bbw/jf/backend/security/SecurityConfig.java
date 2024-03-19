package ch.bbw.jf.backend.security;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;

/**
 * Class: SecurityConfig
 *
 * @author Schules
 * @version 19.03.2024
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {
    private ApplicationContext applicationContext;

    public SecurityConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CsrfConfigurer<HttpSecurity> config = new CsrfConfigurer<>(applicationContext);
        config.disable()
                .authorizeRequests()
                .antMatchers("/users").permitAll() // Exclude login and token endpoints from authentication
                .anyRequest().authenticated();
        Customizer<CsrfConfigurer<HttpSecurity>> customizer = Customizer.withDefaults();
        customizer.customize(config);
        http.csrf(customizer);
    }
}
