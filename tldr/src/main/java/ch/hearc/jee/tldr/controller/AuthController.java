
package ch.hearc.jee.tldr.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ch.hearc.jee.tldr.dto.UserDto;
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
		model.addAttribute("user", new UserDto());
		model.addAttribute("loginForm", Boolean.TRUE);
		return "auth";
		}

	// handler method to handle user registration form request
	@GetMapping("/register")
	public String showRegistrationForm(Model model)
		{
		// create model object to store form data
		UserDto user = new UserDto();
		model.addAttribute("user", user);
		model.addAttribute("registerForm", Boolean.TRUE);
		return "auth";
		}

	// handler method to handle user registration form submit request
	@PostMapping("/register/save")
	public String registration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model)
		{
		User existingUser = userService.findUserByEmail(userDto.getEmail());

		if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty())
			{
			result.rejectValue("email", null, "There is already an account registered with the same email");
			}

		if (result.hasErrors())
			{
			model.addAttribute("user", userDto);
			return "redirect:/register";
			}

		userService.saveUser(userDto);
		return "redirect:/login";
		}

	// handler method to handle list of users
	@GetMapping("/users")
	public String users(Model model)
		{
		List<UserDto> users = userService.findAllUsers();
		model.addAttribute("users", users);
		model.addAttribute("userList", Boolean.TRUE);
		return "list";
		}
	}
