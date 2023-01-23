
package ch.hearc.jee.tldr.repositories;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ch.hearc.jee.tldr.entity.TLDR;
import ch.hearc.jee.tldr.entity.User;
import ch.hearc.jee.tldr.repository.TLDRRepository;
import ch.hearc.jee.tldr.seed.SeederSettings;
import ch.hearc.jee.tldr.service.user.UserService;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TestTLDRRepository
	{

	@Autowired
	private TLDRRepository tldrRepository;

	@Mock
	private UserService userService;

	private TLDR tldr;

	@BeforeEach
	public void setUp()
		{
		this.tldr = new TLDR("name", "content");
		}

	@AfterEach
	public void tearDown()
		{
		tldrRepository.deleteAll();
		tldr = null;
		}

	@Test
	public void testSave()
		{
		tldrRepository.save(tldr);
		TLDR fetchedTldr = tldrRepository.findById(tldr.getId());
		Assertions.assertEquals(tldr.getId(), fetchedTldr.getId());
		}

	@Test
	public void testFindAll()
		{
		TLDR tldr1 = new TLDR("name1", "content1");
		TLDR tldr2 = new TLDR("name2", "content2");
		tldrRepository.save(tldr1);
		tldrRepository.save(tldr2);
		List<TLDR> tldrList = tldrRepository.findAll();
		Assertions.assertEquals("name2", tldrList.get(1).getName());
		}

	@Test
	public void testFindByName()
		{
		tldrRepository.save(tldr);
		TLDR fetchedTldr = tldrRepository.findByName(tldr.getName());
		Assertions.assertEquals(tldr.getName(), fetchedTldr.getName());
		}

	@Test
	public void testFindById()
		{
		tldrRepository.save(tldr);
		TLDR fetchedTldr = tldrRepository.findById(tldr.getId());
		Assertions.assertEquals(tldr.getId(), fetchedTldr.getId());
		}

	@Test
	public void testDeleteById()
		{
		tldrRepository.save(tldr);
		tldrRepository.deleteById(tldr.getId());
		TLDR fetchedTldr = tldrRepository.findById(tldr.getId());
		Assertions.assertNull(fetchedTldr);
		}

	@Test
	public void testDeleteAll()
		{
		tldrRepository.save(tldr);
		tldrRepository.deleteAll();
		List<TLDR> tldrList = tldrRepository.findAll();
		Assertions.assertTrue(tldrList.isEmpty());
		}

	@Test
	public void testFindByUser()
		{
		// create a user and add it to the tldr
		User user = new User();
		user = new User();
		user.setFirstName(SeederSettings.ADMIN_FIRSTNAME.toString());
		user.setLastName(SeederSettings.ADMIN_LASTNAME.toString());
		user.setPassword(SeederSettings.ADMIN_PASSWORD.toString());
		user.setEmail(SeederSettings.ADMIN_EMAIL.toString());
		userService.save(user);
		tldr.setUser(userService.findUserByEmail(SeederSettings.ADMIN_EMAIL.toString()));
		tldrRepository.save(tldr);
		List<TLDR> tldrList = tldrRepository.findByUser(userService.findUserByEmail(SeederSettings.ADMIN_EMAIL.toString()));
		Assertions.assertEquals(1, tldrList.size());
		Assertions.assertEquals(tldr.getId(), tldrList.get(0).getId());
		}
	}
