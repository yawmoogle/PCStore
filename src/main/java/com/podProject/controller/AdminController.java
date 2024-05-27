package com.podProject.controller;

import com.podProject.model.Admin;
import com.podProject.model.AuthAdmin;
import com.podProject.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/login")
    public String showAdminLoginPage(@RequestParam(value = "error", required = false) String error, Model model,
                                     @RequestParam(value = "logout", required = false) String logout) {
        if (error != null) {
            model.addAttribute("errorMessage",
                    "Incorrect username or password. Please re-enter your username or password.");
        }
        if (logout != null) {
            model.addAttribute("logoutMessage", "Logout successful.");
        }
        return "adminLogin";
    }

    @GetMapping("/home")
//    @PreAuthorize("hasRole('ADMIN')")
    public String showAdminHomePage(@AuthenticationPrincipal AuthAdmin principal, Model model) {
        String username = principal.getUsername(); // Get the username directly from AuthAdmin
        model.addAttribute("username", username);
        return "adminHome";
    }


    @GetMapping("/logout")
    public String logout(RedirectAttributes redirectAttributes, HttpServletRequest request) {
        redirectAttributes.addFlashAttribute("logoutMessage", "Logout successful.");
        request.getSession().invalidate();
        return "redirect:/admin/login";
    }

    @GetMapping("/createNewAdmin")
    public String createNewAdminPage() {
        return "adminCreateNewAccount";
    }

    @PostMapping("/createNewAdmin")
    public String createNewAdmin(@ModelAttribute Admin admin, RedirectAttributes redirectAttributes) {
        if (adminService.existsByAdminusername(admin.getAdminusername())) {
            // If the username is in use, add an error message to the redirect attributes and redirect back to the form
            redirectAttributes.addFlashAttribute("error", "Error: The Login ID '" + admin.getAdminusername() + "' is already in use.");
            return "redirect:/admin/createNewAdmin";
        }
        adminService.createAdmin(admin);
        redirectAttributes.addFlashAttribute("message", "Admin " + admin.getAdminusername() + " was successfully created.");
        return "redirect:/admin/createNewAdmin";


    }
}
