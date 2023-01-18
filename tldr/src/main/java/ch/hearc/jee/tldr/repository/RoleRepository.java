
package ch.hearc.jee.tldr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ch.hearc.jee.tldr.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>, PagingAndSortingRepository<Role, Long>
	{

	public Role findByName(String name);

	}
