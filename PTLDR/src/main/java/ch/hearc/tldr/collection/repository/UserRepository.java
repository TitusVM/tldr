
package ch.hearc.tldr.collection.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ch.hearc.tldr.collection.models.User;

public interface UserRepository extends CrudRepository<User, Long>
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public Optional<User> findByUsername(String username);

	public String findPasswordById(Long id);
	}
