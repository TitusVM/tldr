
package ch.hearc.jee.tldr.repositories;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ch.hearc.jee.tldr.entity.User;
import ch.hearc.jee.tldr.repository.UserRepository;
import ch.hearc.jee.tldr.seed.SeederSettings;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TestUserRepository
	{

	@Autowired
	private UserRepository userRepository;

	private User user;

	@BeforeEach
	public void setUp()
		{
		user = new User();
		user.setFirstName(SeederSettings.ADMIN_FIRSTNAME.toString());
		user.setLastName(SeederSettings.ADMIN_LASTNAME.toString());
		user.setPassword(SeederSettings.ADMIN_PASSWORD.toString());
		user.setEmail(SeederSettings.ADMIN_EMAIL.toString());
		userRepository.save(user);
		user.setId(userRepository.findByEmail(SeederSettings//
				.ADMIN_EMAIL.toString()).getId());
		}

	@AfterEach
	public void tearDown()
		{
		userRepository.deleteAll();
		user = null;
		}

	@Test
	public void testSave()
		{
		User fetchedUser = userRepository.findById(user.getId()).get();
		Assertions.assertEquals(user.getId(), fetchedUser.getId());
		}

	@Test
	public void testFindById()
		{
		User fetchedUser = userRepository.findById(user.getId()).get();
		Assertions.assertEquals(user.getId(), fetchedUser.getId());
		}

	@Test
	public void testFindByEmail()
		{
		User fetchedUser = userRepository.findByEmail(user.getEmail());
		Assertions.assertEquals(user.getEmail(), fetchedUser.getEmail());
		}

	@Test
	public void testDeleteById()
		{
		userRepository.save(user);
		userRepository.deleteById(user.getId());
		Optional<User> fetchedUser = userRepository.findById(user.getId());
		Assertions.assertFalse(fetchedUser.isPresent());
		}
	}
