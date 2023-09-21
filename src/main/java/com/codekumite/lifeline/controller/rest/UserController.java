package com.codekumite.lifeline.controller.rest;

import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @GetMapping("currentUser")
    public Object getCurrentUser(Principal principal) {
        return principal;
    }
}
