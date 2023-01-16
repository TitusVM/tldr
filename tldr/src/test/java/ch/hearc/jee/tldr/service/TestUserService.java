
package ch.hearc.jee.tldr.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import ch.hearc.jee.tldr.entity.User;
import ch.hearc.jee.tldr.repository.UserRepository;
import ch.hearc.jee.tldr.service.user.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestUserService
	{

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceImpl userService;

	@Test
	public void testSaveUser()
		{
		User user = new User(null, "John", "Doe", "johndoe@example.com", "password", null, null);
		userService.saveUser(user);
		Mockito.verify(userRepository, Mockito.times(1)).save(ArgumentMatchers.any(User.class));
		}

	@Test
	public void testFindUserByEmail()
		{
		String email = "johndoe@example.com";
		userService.findUserByEmail(email);
		Mockito.verify(userRepository, Mockito.times(1)).findByEmail(email);
		}

	@Test
	public void testFindAllUsers()
		{
		userService.findAllUsers();
		Mockito.verify(userRepository, Mockito.times(1)).findAll();
		}

	@Test
	public void testFindById()
		{
		Long userId = 1L;
		userService.findById(userId);
		Mockito.verify(userRepository, Mockito.times(1)).findById(userId);
		}
	}
