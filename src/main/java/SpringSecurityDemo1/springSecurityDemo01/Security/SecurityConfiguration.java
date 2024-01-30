package SpringSecurityDemo1.springSecurityDemo01.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;

@Configuration
public class SecurityConfiguration {


    @Bean
    public InMemoryUserDetailsManager uerDetailsManager(){
        UserDetails tejas= User.builder()
                .username("tejas")
                .password("{noop}123")
                .roles("ADMIN")
                .build();

        UserDetails sham=User.builder()
                .username("sham")
                .password("{noop}456")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(tejas, sham);
    }
    @Bean
    public DefaultSecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(
                config -> config
                        .requestMatchers("/product/display").hasRole("ADMIN")
                        .requestMatchers("/product/display").hasRole("USER")
                        .anyRequest().authenticated()
                )
        .formLogin(Customizer.withDefaults());
        return httpSecurity.build();
    }

}
