
package ch.hearc.tldr;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SecurityConfiguration
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Bean
	public UserDetailsService userDetailsService()
		{

		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build();

		return new InMemoryUserDetailsManager(user);
		}

	/*
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
		{

		http.authorizeRequests().antMatchers("/", "/accueil").permitAll().anyRequest().authenticated();

		http.logout().logoutSuccessUrl("/admin");

		return http.build();

		}*/

	}
