
package ch.hearc.jee.tldr.service.tldr.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import ch.hearc.jee.tldr.entity.TLDR;
import ch.hearc.jee.tldr.entity.User;
import ch.hearc.jee.tldr.repository.TLDRRepository;
import ch.hearc.jee.tldr.seed.SeederSettings;
import ch.hearc.jee.tldr.service.tldr.TLDRService;
import ch.hearc.jee.tldr.service.user.UserService;

@Service
public class TLDRServiceImpl implements TLDRService
	{

	@Autowired
	private TLDRRepository tldrRepository;

	@Autowired
	private UserService userService;

	@Override
	public void saveTLDR(TLDR tldr)
		{
		TLDR new_tldr = new TLDR();
		new_tldr.setName(tldr.getName());
		new_tldr.setContent(tldr.getContent());
		new_tldr.setUser(userService.findById(getCurrentUser().getId()));
		this.tldrRepository.save(new_tldr);
		}

	@Override
	public void updateTLDR(TLDR tldr)
		{
		TLDR updatedTldr = this.tldrRepository.findById(tldr.getId());

		if (updatedTldr != null)
			{
			updatedTldr.setId(tldr.getId());
			updatedTldr.setName(tldr.getName());
			updatedTldr.setContent(tldr.getContent());

			this.tldrRepository.save(updatedTldr);
			}
		}

	@Override
	public void deleteTLDR(TLDR tldr)
		{
		this.tldrRepository.deleteById(tldr.getId());
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
	public List<TLDR> findAll()
		{
		List<TLDR> list = this.tldrRepository.findAll();
		return list;
		}

	@Override
	public TLDR findById(Long id)
		{
		return this.tldrRepository.findById(id);
		}

	@Override
	public void save(TLDR tldr)
		{
		this.saveTLDR(tldr);
		}

	@Override
	public Page<TLDR> findPaginated(Pageable pageable)
		{
		return tldrRepository.findAll(pageable);
		}

	@Override
	public Page<TLDR> findByUserId(Long id, Pageable pageable)
		{
		return tldrRepository.findAllByUserOrderByIdDesc(userService.findById(id), pageable);
		}

	@Override
	public void saveSeeds(TLDR tldr)
		{
		tldr.setUser(userService.findUserByEmail(SeederSettings.ADMIN_EMAIL.toString()));
		tldrRepository.save(tldr);
		}

	private User getCurrentUser()
		{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.isAuthenticated())
			{ return userService.findUserByEmail(((UserDetails)(auth.getPrincipal())).getUsername()); }
		return null;
		}
	}
