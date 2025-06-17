package ge.croco.NotificationsApp.user.controller;


import ge.croco.NotificationsApp.user.entity.AppUser;
import ge.croco.NotificationsApp.user.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class AuthController {

    private final AppUserService userService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new AppUser());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute AppUser user) {
        userService.registerUser(user);
        return "redirect:/login";
    }

    @PostMapping("/register-admin")
    public String register(@ModelAttribute AppUser user) {
        userService.registerAdmin(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
