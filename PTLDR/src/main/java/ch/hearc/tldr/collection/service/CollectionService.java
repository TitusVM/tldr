
package ch.hearc.tldr.collection.service;

import java.util.List;

import ch.hearc.tldr.collection.models.implementation.TLDR;

public interface CollectionService
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void addTLDRToCollection(TLDR tldr);

	public List<TLDR> getAllTLDRsFromCollection();

	public void deleteTLDR(Long id);

	public TLDR updateTLDR(TLDR tldr);

	public TLDR getTLDRById(Long id);

	}
