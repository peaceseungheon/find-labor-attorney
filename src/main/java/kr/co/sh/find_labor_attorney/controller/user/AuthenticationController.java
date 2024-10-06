package kr.co.sh.find_labor_attorney.controller.user;

import kr.co.sh.find_labor_attorney.controller.user.dto.AuthenticationResponse;
import kr.co.sh.find_labor_attorney.service.user.AuthenticationService;
import kr.co.sh.find_labor_attorney.service.user.dto.UserLoginRequest;
import kr.co.sh.find_labor_attorney.service.user.dto.UserRegisterRequest;
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

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserRegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request.email(), request.password()));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody UserLoginRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

}
