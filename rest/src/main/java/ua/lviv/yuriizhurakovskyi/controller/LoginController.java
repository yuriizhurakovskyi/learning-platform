package ua.lviv.yuriizhurakovskyi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/login")
    public ResponseEntity<String> login() {
        return ResponseEntity.ok().body("Welcome!");
    }

    @PostMapping("/logout")
    public String logout() {
        return "You logged out!";
    }
}
