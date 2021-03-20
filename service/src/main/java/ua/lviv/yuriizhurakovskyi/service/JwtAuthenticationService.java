package ua.lviv.yuriizhurakovskyi.service;

import ua.lviv.yuriizhurakovskyi.dto.jwt.JwtRequest;
import ua.lviv.yuriizhurakovskyi.dto.jwt.JwtResponse;

public interface JwtAuthenticationService {

    JwtResponse createAuthenticationToken(JwtRequest authenticationRequest) throws Exception;
}
