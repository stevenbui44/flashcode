package com.stevenbui.flashcode.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.stevenbui.flashcode.services.MyUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private MyUserService userDetailsService;

    // set up authorization
    @Bean
    public SecurityFilterChain securityFilterChain ( final HttpSecurity httpSecurity ) throws Exception {
        return httpSecurity
                .csrf( AbstractHttpConfigurer::disable )
                .authorizeHttpRequests( registry -> {

                    // everyone, even if they are not logged in
                    registry.requestMatchers( "/login", "/register" ).permitAll();

                    // for just users
                    registry.requestMatchers( "/assortments", "/assortments/**", "/settings" ).hasRole( "USER" );
                    registry.requestMatchers( HttpMethod.DELETE, "/**" ).hasRole( "USER" );

                    // any other pages, user must be authenticated
                    registry.anyRequest().authenticated();
                } )
                .formLogin( httpSecurityFormLoginConfigurer -> {
                    httpSecurityFormLoginConfigurer
                            .loginPage( "/login" )
                            .successHandler( new AuthenticationSuccessHandler() )
                            .permitAll();
                } )
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService () {
        return userDetailsService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider () {
        final DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService( userDetailsService );
        provider.setPasswordEncoder( passwordEncoder() );
        return provider;
    }

    // set up what type of password encoding in UserDetailsService
    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager ( final AuthenticationConfiguration authConfig )
            throws Exception {
        return authConfig.getAuthenticationManager();
    }

}
