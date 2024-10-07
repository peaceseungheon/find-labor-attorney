package kr.co.sh.labor.labor_core.users;

import java.util.Optional;
import java.util.Set;
import kr.co.sh.labor.labor_core.exception.DuplicateException;
import kr.co.sh.labor.labor_core.exception.UserNotFoundException;
import kr.co.sh.labor.labor_core.ports.users.UserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserPersistencePort userPersistencePort;

    public User register(String email, String encodedPassword, String roleType) {
        Optional<User> maybeUser = userPersistencePort.findByEmail(email);
        if (maybeUser.isPresent()){
            throw new DuplicateException("해당 이메일로 가입된 회원이 존재합니다.");
        }
        User user = User.builder()
            .email(email)
            .password(encodedPassword)
            .userRoles(Set.of(roleType))
            .build();
        return userPersistencePort.save(user);
    }

    public User findByEmail(String email) {
        Optional<User> user = userPersistencePort.findByEmail(email);
        if (user.isEmpty()){
            throw new UserNotFoundException("해당 이메일로 가입한 회원이 존재하지 않습니다.");
        }
        return user.get();
    }


}