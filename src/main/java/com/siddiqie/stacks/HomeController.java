package com.siddiqie.stacks;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String Home() {
        return "index";
    }

    @PostMapping("/getStarted")
    public String getStarted() {
        return "getStarted";
    }

    @PostMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @PostMapping("/working")
    public String working() {
        return "working";
    }

}
