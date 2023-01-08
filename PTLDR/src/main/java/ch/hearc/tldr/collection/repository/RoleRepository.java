
package ch.hearc.tldr.collection.repository;

import org.springframework.data.repository.CrudRepository;

import ch.hearc.tldr.collection.models.Role;
import ch.hearc.tldr.collection.models.TLDR;

public interface RoleRepository extends CrudRepository<TLDR, Long>
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public Role findRoleByName(String name);
	}
