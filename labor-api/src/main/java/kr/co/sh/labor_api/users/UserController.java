package kr.co.sh.labor_api.users;

import kr.co.sh.domain.users.service.UserService;
import kr.co.sh.labor_api.users.dto.UserRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody UserRegisterRequest request){
        String encodedPassword = passwordEncoder.encode(request.password());
        userService.register(request.email(), encodedPassword, request.roleType());
    }
}
