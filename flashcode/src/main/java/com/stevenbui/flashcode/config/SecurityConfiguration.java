package com.stevenbui.flashcode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	// set up authorization
	@Bean
	public SecurityFilterChain securityFilterChain(final HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.authorizeHttpRequests(registry -> {

					// for all
					registry.requestMatchers("/").permitAll();

					// for admins
					registry.requestMatchers("/**").hasRole("ADMIN");

					// for just users
					registry.requestMatchers("/assortments/**").hasRole("USER");

					// any other pages, user must be authenticated
					registry.anyRequest().authenticated();

				})
				.formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
				.build();
	}

	// set up authentication credentials for users
	@Bean
	public UserDetailsService userDetailService() {
		final UserDetails normalUser = User.builder()
				.username("user")
				.password("$2a$12$0xQEXJmiyfv1qS0OpA17pehm0n9b8FWXScKnZo0GZ0/qBM0QBStrC") // users
				.roles("USER")
				.build();
		final UserDetails adminUser = User.builder()
				.username("admin")
				.password("$2a$12$ykz0gFFZl3N4FuKL1us1LeUnbhiNerCCzP54nOLP9KL5cPts7bJoC") // admins
				.roles("ADMIN", "USER")
				.build();
		return new InMemoryUserDetailsManager(normalUser, adminUser);
	}

	// set up what type of password encoding in UserDetailsService
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
