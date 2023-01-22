
package ch.hearc.jee.tldr.repositories;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ch.hearc.jee.tldr.entity.TLDR;
import ch.hearc.jee.tldr.repository.TLDRRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TestTLDRRepository
	{

	@Autowired
	private TLDRRepository tldrRepository;

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
	}
