package soon.soondoitmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import soon.soondoitmvc.dto.SignupReqDto;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/add")
    public String addForm(@ModelAttribute("signupReqDto") SignupReqDto dto) {
        return "users/addUserForm";
    }
}
