
package ch.hearc.jee.tldr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.hearc.jee.tldr.entity.TLDR;

public interface TLDRRepository extends JpaRepository<TLDR, Long>
	{

	public TLDR findByName(String name);

	public List<TLDR> findByUserId(Long id);

	}
