
package ch.hearc.jee.tldr.service.tldr;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ch.hearc.jee.tldr.entity.TLDR;

public interface TLDRService
	{

	public void saveTLDR(TLDR tldr);

	public void updateTLDR(TLDR tldr);

	public void deleteTLDR(TLDR tldr);

	public void deleteTLDRById(Long id);

	public TLDR findTLDRByName(String name);

	public List<TLDR> findAllTLDRs();

	public List<TLDR> findAll();

	public TLDR findById(Long id);

	public void save(TLDR tldr);

	public Page<TLDR> findPaginated(Pageable pageable);

	public Page<TLDR> findByUserId(Long id, Pageable pageable);

	public void saveSeeds(TLDR tldr);

	}
