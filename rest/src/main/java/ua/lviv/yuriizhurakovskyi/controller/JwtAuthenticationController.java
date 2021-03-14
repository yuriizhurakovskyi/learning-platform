package ua.lviv.yuriizhurakovskyi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.yuriizhurakovskyi.dto.jwt.JwtRequest;
import ua.lviv.yuriizhurakovskyi.service.JwtAuthenticationService;

@RestController
@CrossOrigin
@AllArgsConstructor
public class JwtAuthenticationController {

    private final JwtAuthenticationService jwtAuthenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        return ResponseEntity
                .ok(jwtAuthenticationService.createAuthenticationToken(authenticationRequest));
    }

}
