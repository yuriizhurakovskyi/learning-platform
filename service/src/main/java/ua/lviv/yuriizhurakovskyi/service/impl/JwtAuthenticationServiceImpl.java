package ua.lviv.yuriizhurakovskyi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ua.lviv.yuriizhurakovskyi.dto.jwt.JwtRequest;
import ua.lviv.yuriizhurakovskyi.dto.jwt.JwtResponse;
import ua.lviv.yuriizhurakovskyi.security.util.JwtTokenUtil;
import ua.lviv.yuriizhurakovskyi.service.JwtAuthenticationService;
import ua.lviv.yuriizhurakovskyi.service.UserService;

@AllArgsConstructor
@Service
public class JwtAuthenticationServiceImpl implements JwtAuthenticationService {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    private final UserService userDetailsService;

    @Override
    public JwtResponse createAuthenticationToken(JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return new JwtResponse(token);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e){
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
