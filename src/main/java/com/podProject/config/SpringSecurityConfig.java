package com.podProject.config;

import com.podProject.service.AdminUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	@Autowired
	private AdminUserDetailsService adminUserDetailsService;

	@Bean
	public AuthenticationProvider authenticationProvider(PasswordEncoder passwordEncoder) {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(adminUserDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder);
		return authProvider;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(authorize -> authorize
								.requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN") // Restrict access to other admin pages to users with ADMIN role
								.anyRequest().permitAll() // Allow all users to access all other requests


//				Future use
//						.requestMatchers("/", "/login").permitAll() // Permit all for home and general user login
//						.requestMatchers("/admin/login").permitAll() // Allow all users to access admin login
//						.requestMatchers("/admin/**").hasRole("ADMIN") // Restrict access to other admin pages to users with ADMIN role
//						.anyRequest().authenticated() // Require authentication for any other request


				)
				.formLogin(formLogin -> formLogin
						.loginPage("/admin/login")
						.loginProcessingUrl("/perform_admin_login")
						.failureUrl("/admin/login?error=true")
						.defaultSuccessUrl("/admin/home", true)
						.permitAll()
				)
				.logout(logout -> logout
						.logoutUrl("/logout")
						.logoutSuccessUrl("/home")
						.deleteCookies("JSESSIONID")  // delete session cookie
						.invalidateHttpSession(true)  // invalidate session
						.clearAuthentication(true)  // clear authentication
						.permitAll()
				);
		return http.build();
	}

}