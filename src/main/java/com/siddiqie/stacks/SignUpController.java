package com.siddiqie.stacks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUpController {
    @GetMapping("/signUp")
    public String signUp() {
        return "signUp";
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/signUpResult")
    public String signUpResult(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("username") String username,
            @RequestParam("password1") String password1,
            @RequestParam("password2") String password2,
            Model model) {

        if (!password1.equals(password2))
            return "passFail";

        try {
            String qury = "insert into users_info values (?, ?, ?, ?)";
            jdbcTemplate.update(qury, username, password1, firstName, lastName);
        } catch (Exception e) {
            return "dupUser";
        }
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("username", username);
        model.addAttribute("password1", password1);
        model.addAttribute("password2", password2);

        return "signUpSuccess";
    }

}
