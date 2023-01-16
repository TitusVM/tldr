
package ch.hearc.jee.tldr.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ch.hearc.jee.tldr.entity.TLDR;
import ch.hearc.jee.tldr.entity.User;

public class TestTLDR
	{

	@Test
	public void testGetId()
		{
		TLDR tldr = new TLDR(1L, "TLDR", "A small description of the meaning of the thing", null);
		assertEquals(1L, tldr.getId());
		}

	@Test
	public void testSetId()
		{
		TLDR tldr = new TLDR();
		tldr.setId(1L);
		assertEquals(1L, tldr.getId());
		}

	@Test
	public void testGetName()
		{
		TLDR tldr = new TLDR(1L, "TLDR", "A small description of the meaning of the thing", null);
		assertEquals("Summary", tldr.getName());
		}

	@Test
	public void testSetName()
		{
		TLDR tldr = new TLDR();
		tldr.setName("Summary");
		assertEquals("Summary", tldr.getName());
		}

	@Test
	public void testGetContent()
		{
		TLDR tldr = new TLDR(1L, "TLDR", "A small description of the meaning of the thing", null);
		assertEquals("This is a summary of the article", tldr.getContent());
		}

	@Test
	public void testSetContent()
		{
		TLDR tldr = new TLDR();
		tldr.setContent("A small description of the meaning of the thing");
		assertEquals("A small description of the meaning of the thing", tldr.getContent());
		}

	@Test
	public void testGetUser()
		{
		User user = new User();
		TLDR tldr = new TLDR(1L, "TLDR", "A small description of the meaning of the thing", user);
		assertEquals(user, tldr.getUser());
		}

	@Test
	public void testSetUser()
		{
		User user = new User();
		TLDR tldr = new TLDR();
		tldr.setUser(user);
		assertEquals(user, tldr.getUser());
		}
	}
