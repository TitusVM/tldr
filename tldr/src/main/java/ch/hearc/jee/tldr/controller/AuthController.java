
package ch.hearc.jee.tldr.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ch.hearc.jee.tldr.entity.User;
import ch.hearc.jee.tldr.service.user.UserService;

import jakarta.validation.Valid;

@Controller
public class AuthController
	{

	private UserService userService;

	public AuthController(UserService userService)
		{
		this.userService = userService;
		}

	// handler method to handle login request
	@GetMapping("/login")
	public String login(Model model)
		{
		model.addAttribute("user", new User());
		model.addAttribute("loginForm", Boolean.TRUE);
		return "auth";
		}

	// handler method to handle user registration form request
	@GetMapping("/register")
	public String showRegistrationForm(Model model)
		{
		// create model object to store form data
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("registerForm", Boolean.TRUE);
		return "auth";
		}

	// handler method to handle user registration form submit request
	@PostMapping("/register/save")
	public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model)
		{
		User existingUser = userService.findUserByEmail(user.getEmail());

		if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty())
			{
			result.rejectValue("email", null, "There is already an account registered with the same email");
			}

		if (result.hasErrors())
			{
			model.addAttribute("user", user);
			return "redirect:/register";
			}

		userService.save(user);
		return "redirect:/login";
		}

	// handler method to handle list of users
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/users")
	public String users(Model model)
		{
		System.out.println("-----ADMIN SPACE-----");
		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		model.addAttribute("userList", Boolean.TRUE);
		return "list";
		}

	}
