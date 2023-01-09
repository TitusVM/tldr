
package ch.hearc.jee.tldr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.hearc.jee.tldr.entity.User;

public interface UserRepository extends JpaRepository<User, Long>
	{

	User findByEmail(String email);

	}
