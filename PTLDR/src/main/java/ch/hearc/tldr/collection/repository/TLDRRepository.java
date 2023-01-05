
package ch.hearc.tldr.collection.repository;

import org.springframework.data.repository.CrudRepository;

import ch.hearc.tldr.collection.models.implementation.TLDR;

public interface TLDRRepository extends CrudRepository<TLDR, Long>
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public TLDR findByName(String name);

	}
