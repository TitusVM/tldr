
package ch.hearc.jee.tldr.service.user.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ch.hearc.jee.tldr.entity.Role;
import ch.hearc.jee.tldr.entity.User;
import ch.hearc.jee.tldr.repository.RoleRepository;
import ch.hearc.jee.tldr.repository.UserRepository;
import ch.hearc.jee.tldr.service.user.UserService;

@Service
public class UserServiceImpl implements UserService
	{

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder)
		{
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
		}

	@Override
	public void saveUser(User user)
		{
		User new_user = new User();
		new_user.setFirstName(user.getFirstName());
		new_user.setLastName(user.getLastName());
		new_user.setEmail(user.getEmail());

		// encrypt the password using spring security
		new_user.setPassword(passwordEncoder.encode(user.getPassword()));

		Role role = roleRepository.findByName("ROLE_USER");
		if (role == null)
			{
			role = checkRoleExist();
			}
		new_user.setRoles(Arrays.asList(role));
		userRepository.save(new_user);
		}

	@Override
	public User findUserByEmail(String email)
		{
		return userRepository.findByEmail(email);
		}

	@Override
	public User findById(Long userId)
		{
		return userRepository.findById(userId).get();
		}

	@Override
	public List<User> findAllUsers()
		{
		return userRepository.findAll();
		}

	private Role checkRoleExist()
		{
		Role role = new Role();
		role.setName("ROLE_USER");
		return roleRepository.save(role);
		}

	@Override
	public void save(User user)
		{
		this.saveUser(user);
		}
	}
