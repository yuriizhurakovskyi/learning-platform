package ua.lviv.yuriizhurakovskyi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<String> login(HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return ResponseEntity.ok().body("Welcome!");
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        SecurityContextHolder.clearContext();
        if (session != null) {
            session.invalidate();
        }
        return ResponseEntity.ok().body("Logout success");
    }
}
