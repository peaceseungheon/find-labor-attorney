package kr.co.sh.labor_api.security;

import kr.co.sh.domain.users.User;
import kr.co.sh.domain.users.service.UserService;
import kr.co.sh.labor_api.users.dto.AuthenticationResponse;
import kr.co.sh.labor_api.users.dto.UserLoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(UserLoginRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );
        userService.findByEmail(request.email());
        User user = userService.findByEmail(request.email());
        CustomUserDetails userDetails = new CustomUserDetails(user);
        String token = jwtService.generateToken(userDetails);
        return new AuthenticationResponse(token);
    }
}
