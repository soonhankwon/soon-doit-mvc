package soon.soondoitmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import soon.soondoitmvc.argumentresolver.Login;
import soon.soondoitmvc.domain.User;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@Login User loginUser, Model model) {
        if(loginUser == null) {
            return "home";
        }

        model.addAttribute("user", loginUser);
        return "loginHome";
    }
}
