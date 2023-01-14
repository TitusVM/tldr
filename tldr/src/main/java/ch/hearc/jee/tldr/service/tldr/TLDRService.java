
package ch.hearc.jee.tldr.service.tldr;

import java.util.List;

import ch.hearc.jee.tldr.dto.TLDRDto;
import ch.hearc.jee.tldr.entity.TLDR;

public interface TLDRService
	{

	public void saveTLDR(TLDRDto tldrDto);

	public void updateTLDR(TLDRDto tldrDto);

	public void deleteTLDR(TLDRDto tldrDto);

	public void deleteTLDRById(Long id);

	public TLDR findTLDRByName(String name);

	public List<TLDR> findAllTLDRs();

	public List<TLDR> findTLDRsByUserId(Long id);

	public List<TLDR> findAll();

	public TLDR findById(Long id);

	public void save(TLDR tldr);

	}
