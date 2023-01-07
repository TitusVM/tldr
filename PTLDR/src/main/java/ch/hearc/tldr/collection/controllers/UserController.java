
package ch.hearc.tldr.collection.controllers;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.hearc.tldr.collection.models.User;
import ch.hearc.tldr.collection.service.UserService;

@Controller
public class UserController
	{

	/*------------------------------------------------------------------*\
	|*							 Annotations							*|
	\*------------------------------------------------------------------*/

	@Autowired
	UserService userService;

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@GetMapping(value = { "/login" })
	public String showLoginPage(Model model, HttpSession session)
		{
		model.addAttribute("logged", Boolean.FALSE);
		model.addAttribute("showNewAccountForm", Boolean.FALSE);
		model.addAttribute("showLoginForm", Boolean.TRUE);

		return "/login";
		}

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session)
		{
		Optional<User> user = userService.getUserByUsername(username);
		if (user.isPresent())
			{
			if (user.get().getPassword().equals(password))
				{
				//			model.addAttribute("logged", Boolean.TRUE);
				//			model.addAttribute("user", user);
				//			return "redirect:/";
				System.out.println("[DEBUG] : Login successfull");
				}
			}
		else
			{
			//			model.addAttribute("username", username);
			//			model.addAttribute("login-denied", Boolean.TRUE);
			//			return "redirect:/login";
			System.out.println("[DEBUG] : Login unsuccessfull");
			}
		return null;
		}

	@GetMapping("/new-account")
	public String showNewAccountForm(Model model, HttpSession session)
		{
		model.addAttribute("showNewAccountForm", Boolean.TRUE);
		model.addAttribute("showLoginForm", Boolean.FALSE);
		return "/login";
		}

	@PostMapping("/new-account")
	public String newAccount(@RequestParam String username, @RequestParam String password)
		{
		//if()
		return null;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
