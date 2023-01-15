
package ch.hearc.jee.tldr.service.tldr.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.hearc.jee.tldr.dto.TLDRDto;
import ch.hearc.jee.tldr.entity.TLDR;
import ch.hearc.jee.tldr.repository.TLDRRepository;
import ch.hearc.jee.tldr.repository.UserRepository;
import ch.hearc.jee.tldr.service.tldr.TLDRService;

@Service
public class TLDRServiceImpl implements TLDRService
	{

	@Autowired
	private TLDRRepository tldrRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void saveTLDR(TLDRDto tldrDto)
		{
		TLDR tldr = new TLDR();
		tldr.setName(tldrDto.getName());
		tldr.setContent(tldrDto.getContent());
		tldr.setUser(userRepository.findById(tldrDto.getUserId()).get());
		this.tldrRepository.save(tldr);
		}

	@Override
	public void updateTLDR(TLDRDto tldrDto)
		{
		TLDR tldr = this.tldrRepository.findById(tldrDto.getId()).get();

		if (tldr != null)
			{
			tldr.setName(tldrDto.getName());
			tldr.setContent(tldrDto.getContent());
			}

		this.tldrRepository.save(tldr);
		}

	@Override
	public void deleteTLDR(TLDRDto tldrDto)
		{
		this.tldrRepository.deleteById(tldrDto.getId());
		}

	@Override
	public void deleteTLDRById(Long id)
		{
		this.tldrRepository.deleteById(id);
		}

	@Override
	public TLDR findTLDRByName(String name)
		{
		return this.tldrRepository.findByName(name);
		}

	@Override
	public List<TLDR> findAllTLDRs()
		{
		List<TLDR> list = this.tldrRepository.findAll();
		return list;
		}

	@Override
	public List<TLDR> findTLDRsByUserId(Long id)
		{
		List<TLDR> list = this.tldrRepository.findByUserId(id);
		return list;
		}

	@Override
	public List<TLDR> findAll()
		{
		List<TLDR> list = this.tldrRepository.findAll();
		return list;
		}

	@Override
	public TLDR findById(Long id)
		{
		return this.tldrRepository.findById(id).get();
		}

	@Override
	public void save(TLDR tldr)
		{
		this.tldrRepository.save(tldr);
		}
	}
