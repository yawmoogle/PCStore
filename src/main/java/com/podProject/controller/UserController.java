package com.podProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.podProject.model.User;
import com.podProject.repository.UserRepo;
import com.podProject.security.UserPrincipal;
import com.podProject.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String goTo() {
		return "customerHome";
	}

	@GetMapping("/register")
	public String goToRegisterPage(Model model) {

		model.addAttribute("user", new User());

		return "register";
	}

	@PostMapping("/register")
	public String registerUser(User user) {

		if(userService.registerNewUser(user)) {
			return "redirect:/login";
		}else {
			return "register";
		}
	}

	@GetMapping("/login")
	public String goToLogin() {
		return "login";
	}

	@GetMapping("/logout")
	public String logoutAccount(HttpServletRequest request) {
//		System.out.println(request. + "will be closed");
		request.getSession().invalidate();
		return "redirect:index";
	}

	@GetMapping("/home")
	public String goToHome() {
		return "customerHome";
	}

	// @GetMapping("/home")
	// public String userHome(Model model) {
	// String username = ((UserPrincipal)
	// SecurityContextHolder.getContext().getAuthentication()
	// .getPrincipal()).getUsername();
	//
	// User user = userService.findVerifiedUser(username);
	//
	// model.addAttribute("username",user.getUsername());
	// return "home";
	// }

	// @GetMapping("/logout")
	// public String logout(HttpSession session) {
	// session.invalidate();
	// return "redirect:/";
	// }

	@GetMapping("/users/{id}")
	public String getUser(@PathVariable("id") long userId, Model model) {
		User user = userService.findUser(userId);

		model.addAttribute("user", user);

		return "profile";
	}

	@GetMapping("/users")
	public String getAllUsers(Model model) {
		List<User> userList = userService.findAllUsers();

		model.addAttribute("userlist", userList);

		return "user-list";
	}

	@GetMapping("/products")
	public String goToProducts() {
		return "customerProductPage";
	}
}
