
package ch.hearc.jee.tldr.service;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestTLDRService
	{
	/*
		@Autowired
		private TLDRService tldrService;

		@Mock
		private TLDRRepository tldrRepository;

		private TLDR tldr;

		@BeforeEach
		public void setUp()
			{
			tldr = new TLDR("name", "content");
			}

		//	@Test
		//	public void testSaveTLDR()
		//		{
		//		tldrService.saveTLDR(tldr);
		//		Mockito.verify(tldrRepository, Mockito.times(1)).save(tldr);
		//		}

		@Test
		public void testUpdateTLDR()
			{
			tldrService.updateTLDR(tldr);
			Mockito.verify(tldrRepository, Mockito.times(1)).save(tldr);
			}

		@Test
		public void testDeleteTLDR()
			{
			tldrService.deleteTLDR(tldr);
			Mockito.verify(tldrRepository, Mockito.times(1)).delete(tldr);
			}

		@Test
		public void testDeleteTLDRById()
			{
			tldrService.deleteTLDRById(tldr.getId());
			Mockito.verify(tldrRepository, Mockito.times(1)).deleteById(tldr.getId());
			}

		@Test
		public void testFindTLDRByName()
			{
			Mockito.when(tldrRepository.findByName(tldr.getName())).thenReturn(tldr);
			TLDR fetchedTldr = tldrService.findTLDRByName(tldr.getName());
			Assertions.assertEquals(tldr.getName(), fetchedTldr.getName());
			}

		@Test
		public void testFindAllTLDRs()
			{
			List<TLDR> tldrList = Arrays.asList(tldr);
			Mockito.when(tldrRepository.findAll()).thenReturn(tldrList);
			List<TLDR> fetchedTldrList = tldrService.findAllTLDRs();
			Assertions.assertEquals(tldrList, fetchedTldrList);
			}
			*/
	}
