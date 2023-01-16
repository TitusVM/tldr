
package ch.hearc.jee.tldr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.hearc.jee.tldr.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
	{

	public User findByEmail(String email);

	}
