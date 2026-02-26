package com.siddiqie.stacks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/loginResult")
    public String loginResult(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) {
        String qury = "select password from users_info where username = ?";
        try {
            List<String> user = jdbcTemplate.query(qury,
                    ps -> ps.setString(1, username),
                    (rs, rowNum) -> rs.getString("password"));
            if (user.get(0).equals(password))
                return "dashboard";
            return "deny";
        } catch (Exception e) {
            return "deny";
        }
    }
}
