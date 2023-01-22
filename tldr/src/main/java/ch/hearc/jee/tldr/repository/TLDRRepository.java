
package ch.hearc.jee.tldr.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ch.hearc.jee.tldr.entity.TLDR;
import ch.hearc.jee.tldr.entity.User;

@Repository
public interface TLDRRepository extends PagingAndSortingRepository<TLDR, Long>
	{

	public TLDR findByName(String name);

	public List<TLDR> findByUser(User user);

	@Override
	public Page<TLDR> findAll(Pageable pageable);

	public Page<TLDR> findAllByUserOrderByIdDesc(User user, Pageable pageable);

	public TLDR findById(Long id);

	public List<TLDR> findAll();

	public void deleteById(Long id);

	public void save(TLDR tldr);

	}
