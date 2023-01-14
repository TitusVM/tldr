
package ch.hearc.jee.tldr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController
	{

	// handler method to handle home page request
	@GetMapping(value = { "/", "/index" })
	public String index(@RequestParam(required = false) String success, Model model)
		{
		if (success != null)
			{
			model.addAttribute("message", "Login successful");
			}
		model.addAttribute("tldrList", Boolean.TRUE);
		return "list";
		}
	}
