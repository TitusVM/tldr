
package ch.hearc.tldr.collection.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.hearc.tldr.collection.models.TLDR;
import ch.hearc.tldr.collection.repository.TLDRRepository;
import ch.hearc.tldr.collection.service.CollectionService;

@Service
public class CollectionService_V1 implements CollectionService
	{

	/*------------------------------------------------------------------*\
	|*							 Annotations							*|
	\*------------------------------------------------------------------*/

	@Autowired
	TLDRRepository tldrRepository;

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void addTLDRToCollection(TLDR tldr)
		{
		tldrRepository.save(tldr);
		}

	@Override
	public List<TLDR> getAllTLDRsFromCollection()
		{

		List<TLDR> result = new ArrayList<TLDR>();
		tldrRepository.findAll().forEach(result::add);
		return result;
		}

	@Override
	public void deleteTLDR(Long id)
		{
		TLDR tldr = tldrRepository.findById(Long.valueOf(id)).get();
		tldrRepository.delete(tldr);
		}

	@Override
	public TLDR updateTLDR(TLDR tldr)
		{
		tldrRepository.save(tldr);
		return tldr;
		}

	@Override
	public TLDR getTLDRById(Long id)
		{
		return tldrRepository.findById(Long.valueOf(id)).get();

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
