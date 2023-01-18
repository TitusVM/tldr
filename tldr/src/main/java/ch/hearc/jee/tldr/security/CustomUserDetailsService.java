
package ch.hearc.jee.tldr.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ch.hearc.jee.tldr.entity.Role;
import ch.hearc.jee.tldr.entity.User;
import ch.hearc.jee.tldr.service.user.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService
	{

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
		{
		User user = userService.findUserByEmail(username);
		if (user == null)
			{ throw new UsernameNotFoundException("Invalid username or password."); }
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(user));
		}

	private List<SimpleGrantedAuthority> getAuthority(User user)
		{
		System.out.println("-----------------GETTING USER AUTHORITIES-----------------");
		return user.getRoles()//
				.stream()//
				.map(Role::getName)//
				.peek(System.out::println)//
				.map(s -> new SimpleGrantedAuthority("ROLE_" + s))//
				.toList();

		}
	}
