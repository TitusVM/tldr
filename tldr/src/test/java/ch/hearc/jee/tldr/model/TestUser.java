
package ch.hearc.jee.tldr.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ch.hearc.jee.tldr.entity.Role;
import ch.hearc.jee.tldr.entity.TLDR;
import ch.hearc.jee.tldr.entity.User;

public class TestUser
	{

	@Test
	public void testGetId()
		{
		User user = new User(1L, "John", "Doe", "johndoe@example.com", "password", null, null);
		assertEquals(1L, user.getId());
		}

	@Test
	public void testSetId()
		{
		User user = new User();
		user.setId(1L);
		assertEquals(1L, user.getId());
		}

	@Test
	public void testGetFirstName()
		{
		User user = new User(1L, "John", "Doe", "johndoe@example.com", "password", null, null);
		assertEquals("John", user.getFirstName());
		}

	@Test
	public void testSetFirstName()
		{
		User user = new User();
		user.setFirstName("John");
		assertEquals("John", user.getFirstName());
		}

	@Test
	public void testGetLastName()
		{
		User user = new User(1L, "John", "Doe", "johndoe@example.com", "password", null, null);
		assertEquals("Doe", user.getLastName());
		}

	@Test
	public void testSetLastName()
		{
		User user = new User();
		user.setLastName("Doe");
		assertEquals("Doe", user.getLastName());
		}

	@Test
	public void testGetEmail()
		{
		User user = new User(1L, "John", "Doe", "johndoe@example.com", "password", null, null);
		assertEquals("johndoe@example.com", user.getEmail());
		}

	@Test
	public void testSetEmail()
		{
		User user = new User();
		user.setEmail("johndoe@example.com");
		assertEquals("johndoe@example.com", user.getEmail());
		}

	@Test
	public void testGetPassword()
		{
		User user = new User(1L, "John", "Doe", "johndoe@example.com", "password", null, null);
		assertEquals("password", user.getPassword());
		}

	@Test
	public void testSetPassword()
		{
		User user = new User();
		user.setPassword("password");
		assertEquals("password", user.getPassword());
		}

	@Test
	public void testGetRoles()
		{
		List<Role> roles = new ArrayList<>();
		User user = new User(1L, "John", "Doe", "johndoe@example.com", "password", roles, null);
		assertEquals(roles, user.getRoles());
		}

	@Test
	public void testSetRoles()
		{
		List<Role> roles = new ArrayList<Role>();
		User user = new User();
		user.setRoles(roles);
		assertEquals(roles, user.getRoles());
		}

	@Test
	public void testGetTldrs()
		{
		List<TLDR> tldrs = new ArrayList<>();
		User user = new User(1L, "John", "Doe", "johndoe@example.com", "password", null, tldrs);
		assertEquals(tldrs, user.getTldrs());
		}

	@Test
	public void testSetTldrs()
		{
		List<TLDR> tldrs = new ArrayList<>();
		User user = new User();
		user.setTldrs(tldrs);
		assertEquals(tldrs, user.getTldrs());
		}
	}
