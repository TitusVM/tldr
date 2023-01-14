
package ch.hearc.jee.tldr.service.user.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ch.hearc.jee.tldr.dto.UserDto;
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
	public void saveUser(UserDto userDto)
		{
		User user = new User();
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());

		// encrypt the password using spring security
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));

		Role role = roleRepository.findByName("ROLE_USER");
		if (role == null)
			{
			role = checkRoleExist();
			}
		user.setRoles(Arrays.asList(role));
		userRepository.save(user);
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
	public List<UserDto> findAllUsers()
		{
		List<User> users = userRepository.findAll();
		return users.stream().map((user) -> mapToUserDto(user)).collect(Collectors.toList());
		}

	private UserDto mapToUserDto(User user)
		{
		UserDto userDto = new UserDto();
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setEmail(user.getEmail());
		return userDto;
		}

	private Role checkRoleExist()
		{
		Role role = new Role();
		role.setName("ROLE_USER");
		return roleRepository.save(role);
		}
	}
