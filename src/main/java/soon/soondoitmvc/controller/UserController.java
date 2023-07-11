package soon.soondoitmvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import soon.soondoitmvc.dto.SignupReqDto;
import soon.soondoitmvc.service.UserService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("signupReqDto") SignupReqDto dto) {
        return "users/addUserForm";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute SignupReqDto dto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "users/addUserForm";
        }
        userService.saveUser(dto);
        return "redirect:/";
    }
}
