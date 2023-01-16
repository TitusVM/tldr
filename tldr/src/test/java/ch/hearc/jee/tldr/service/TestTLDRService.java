
package ch.hearc.jee.tldr.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import ch.hearc.jee.tldr.entity.TLDR;
import ch.hearc.jee.tldr.repository.TLDRRepository;
import ch.hearc.jee.tldr.service.tldr.impl.TLDRServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestTLDRService
	{

	@Mock
	private TLDRRepository tldrRepository;

	@InjectMocks
	private TLDRServiceImpl tldrService;

	@Test
	public void testSaveTLDR()
		{
		TLDR tldr = new TLDR(null, "name", "content", null);
		tldrService.saveTLDR(tldr);
		Mockito.verify(tldrRepository, Mockito.times(1)).save(ArgumentMatchers.any(TLDR.class));
		}

	@Test
	public void testUpdateTLDR()
		{
		TLDR tldr = new TLDR(null, "name", "content", null);
		tldrService.updateTLDR(tldr);
		Mockito.verify(tldrRepository, Mockito.times(1)).save(ArgumentMatchers.any(TLDR.class));
		}

	@Test
	public void testDeleteTLDR()
		{
		TLDR tldr = new TLDR(null, "name", "content", null);
		tldrService.deleteTLDR(tldr);
		Mockito.verify(tldrRepository, Mockito.times(1)).delete(ArgumentMatchers.any(TLDR.class));
		}

	@Test
	public void testDeleteTLDRById()
		{
		Long id = 1L;
		tldrService.deleteTLDRById(id);
		Mockito.verify(tldrRepository, Mockito.times(1)).deleteById(id);
		}

	@Test
	public void testFindTLDRByName()
		{
		String name = "name";
		tldrService.findTLDRByName(name);
		Mockito.verify(tldrRepository, Mockito.times(1)).findByName(name);
		}

	@Test
	public void testFindAllTLDRs()
		{
		tldrService.findAllTLDRs();
		Mockito.verify(tldrRepository, Mockito.times(1)).findAll();
		}

	@Test
	public void testFindTLDRsByUserId()
		{
		Long id = 1L;
		tldrService.findTLDRsByUserId(id);
		Mockito.verify(tldrRepository, Mockito.times(1)).findByUserId(id);
		}

	@Test
	public void testFindAll()
		{
		tldrService.findAll();
		Mockito.verify(tldrRepository, Mockito.times(1)).findAll();
		}

	@Test
	public void testFindById()
		{
		Long id = 1L;
		tldrService.findById(id);
		Mockito.verify(tldrRepository, Mockito.times(1)).findById(id);
		}

	@Test
	public void testSave()
		{
		TLDR tldr = new TLDR();
		tldrService.save(tldr);
		Mockito.verify(tldrRepository, Mockito.times(1)).save(tldr);
		}
	}
