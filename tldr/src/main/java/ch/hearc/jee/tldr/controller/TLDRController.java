
package ch.hearc.jee.tldr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ch.hearc.jee.tldr.dto.TLDRDto;
import ch.hearc.jee.tldr.dto.UserDto;
import ch.hearc.jee.tldr.entity.TLDR;
import ch.hearc.jee.tldr.entity.User;
import ch.hearc.jee.tldr.service.tldr.TLDRService;
import ch.hearc.jee.tldr.service.user.UserService;

import jakarta.validation.Valid;

@Controller
public class TLDRController
	{

	@Autowired
	private TLDRService tldrService;

	@Autowired
	private UserService userService;

	@GetMapping("/tldrs")
	public String users(Model model)
		{
		currentUser();
		List<TLDR> tldrs = tldrService.findAllTLDRs();
		model.addAttribute("tldrs", tldrs);
		return "list";
		}

	@GetMapping("/all")
	public List<TLDR> getAll()
		{
		return tldrService.findAll();
		}

	@GetMapping("/{id}")
	public TLDR getById(@PathVariable Long id)
		{
		return tldrService.findById(id);
		}

	@GetMapping("/create")
	public String create(Model model)
		{
		User user = currentUser();

		if (user != null)
			{
			model.addAttribute("createForm", Boolean.TRUE);
			return "tldr";
			}
		else
			{

			return "redirect:/login";
			}
		}

	@PostMapping("/create/save")
	public String createSave(@Valid @RequestBody TLDRDto tldrDto)
		{
		User user = currentUser();

		if (user != null)
			{
			TLDR tldr = new TLDR();
			tldr.setName(tldrDto.getName());
			tldr.setContent(tldrDto.getContent());
			tldr.setUser(user);
			tldrService.save(tldr);
			return "redirect:/my-tldrs";
			}
		else
			{
			return "redirect:login";
			}
		}

	@PutMapping("/update/{id}")
	public String update(@PathVariable Long id, @Valid @RequestBody TLDRDto tldrDto)
		{
		TLDR tldr = tldrService.findById(id);
		tldr.setName(tldrDto.getName());
		tldr.setContent(tldrDto.getContent());
		tldrService.save(tldr);
		return "redirect:/my-tldrs";
		}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id)
		{
		tldrService.deleteTLDRById(id);
		}

	@GetMapping("/my-tldrs")
	public String myTldrs(Model model)
		{
		User user = currentUser();
		if (user != null)
			{
			// The user is authenticated
			// find TLDRs
			List<TLDR> tldrs = tldrService.findTLDRsByUserId(user.getId());
			model.addAttribute("authenticated", true);
			model.addAttribute("tldrs", tldrs);
			model.addAttribute("tldrList", Boolean.TRUE);
			return "list";
			}
		else
			{
			return "redirect:/login";
			}
		}

	private User currentUser()
		{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = null;
		System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-..-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
		System.out.println(authentication.getPrincipal());
		if (authentication != null && authentication.isAuthenticated())
			{
			Object principal = authentication.getPrincipal();
			if (principal instanceof User)
				{
				UserDto userDto = (UserDto)principal;
				user = this.userService.findById(userDto.getId());
				}
			}
		return user;
		}
	}
