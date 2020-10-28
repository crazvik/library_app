package se.ecutb.library_app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private AuthenticationEntryPoint entryPoint;

    protected void configure(HttpSecurity security) throws Exception {
        security.anonymous().authorities("ROLE_ANONYMOUS").and()
                .authorizeRequests().antMatchers("/").permitAll();
    }
}
