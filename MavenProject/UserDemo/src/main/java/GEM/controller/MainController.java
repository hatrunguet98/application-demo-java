package GEM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }

    @GetMapping("/login-form")
    public String getLogin() {
        return "login-form";
    }

    @PostMapping("/login")
    public String postLogin() {
        return "login-form";
    }
    @GetMapping("/registration")
    public String register() {
        return "registration";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginErro", true);
        return "login-form";
    }
    @GetMapping("/verifyError")
    public String verifyEroor(Model model) {
        model.addAttribute("message","Enter your email");
        return "/verifyError";
    }
    @GetMapping("/updatePassword")
    public String changePassword() {
        return "/updatePassword";
    }
//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request, HttpServletResponse response, Model model) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) {
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "redirect:/";
//    }
}