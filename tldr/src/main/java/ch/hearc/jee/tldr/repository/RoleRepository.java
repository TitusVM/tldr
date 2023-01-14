
package ch.hearc.jee.tldr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.hearc.jee.tldr.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>
	{

	public Role findByName(String name);

	}
