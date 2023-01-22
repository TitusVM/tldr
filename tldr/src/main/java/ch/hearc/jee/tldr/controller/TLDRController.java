
package ch.hearc.jee.tldr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String tldrs(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size)
		{
		Page<TLDR> tldrs = tldrService.findPaginated(PageRequest.of(page, size));
		model.addAttribute("tldrs", tldrs);
		model.addAttribute("tldrList", Boolean.TRUE);
		return "list";
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
			model.addAttribute("tldr", new TLDR());
			return "tldr";
			}
		else
			{
			return "redirect:/login";
			}
		}

	@PostMapping("/create/save")
	public String createSave(@Valid @ModelAttribute("tldr") TLDR tldr, BindingResult result, Model model)
		{
		User user = currentUser();

		if (user != null)
			{

			tldrService.save(tldr);
			return "redirect:/my-tldrs";
			}
		else
			{
			return "redirect:login";
			}
		}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model)
		{
		TLDR tldr = tldrService.findById(id);
		model.addAttribute("tldr", tldr);
		model.addAttribute("editForm", Boolean.TRUE);
		return "tldr";
		}

	@PostMapping("/update/{id}")
	public String update(@PathVariable Long id, @Valid @ModelAttribute("tldr") TLDR tldr)
		{
		tldr.setId(id);
		tldrService.updateTLDR(tldr);
		return "redirect:/my-tldrs";
		}

	@PostMapping("/delete/{id}")
	public String delete(@PathVariable Long id)
		{
		tldrService.deleteTLDRById(id);
		return "redirect:/my-tldrs";
		}

	@GetMapping("/my-tldrs")
	public String myTldrs(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size)
		{
		User user = currentUser();
		if (user != null)
			{
			// The user is authenticated
			// find TLDRs
			Page<TLDR> tldrs = tldrService.findPaginated(PageRequest.of(page, size));
			model.addAttribute("authenticated", true);
			model.addAttribute("tldrs", tldrs);
			model.addAttribute("tldrList", Boolean.TRUE);
			model.addAttribute("editable", Boolean.TRUE);
			return "list";
			}
		else
			{
			return "redirect:/login";
			}
		}

	@GetMapping("/admin")
	public String admin(Model model)
		{
		model.addAttribute("editable", Boolean.TRUE);
		model.addAttribute("tldrs", tldrService.findAll());
		return "list";
		}

	private User currentUser()
		{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = null;
		if (authentication != null && authentication.isAuthenticated())
			{
			user = userService.findUserByEmail(authentication.getName());
			return user;
			}
		else
			{
			return null;
			}
		}
	}
