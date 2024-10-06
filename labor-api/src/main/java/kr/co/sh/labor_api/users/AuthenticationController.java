package kr.co.sh.labor_api.users;

import kr.co.sh.labor_api.users.dto.AuthenticationResponse;
import kr.co.sh.labor_api.users.dto.UserLoginRequest;
import kr.co.sh.labor_api.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/sign-in")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody UserLoginRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

}
