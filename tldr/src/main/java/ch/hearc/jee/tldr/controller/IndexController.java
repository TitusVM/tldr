
package ch.hearc.jee.tldr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.hearc.jee.tldr.entity.TLDR;
import ch.hearc.jee.tldr.service.tldr.TLDRService;

@Controller
public class IndexController
	{

	@Autowired
	private TLDRService tldrService;

	// handler method to handle home page request
	@GetMapping(value = { "/", "/index" })
	public String index(@RequestParam(required = false) String success, Model model)
		{
		if (success != null)
			{
			model.addAttribute("message", "Login successful");
			}

		List<TLDR> tldrs = tldrService.findAllTLDRs();

		model.addAttribute("tldrList", Boolean.TRUE);
		model.addAttribute("tldrs", tldrs);
		return "list";
		}
	}
