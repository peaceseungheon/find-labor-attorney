package kr.co.sh.domain.port.users;

import java.util.Optional;
import kr.co.sh.domain.users.User;

public interface UserPersistencePort {

    Optional<User> findByEmail(String email);

    User save(User user);

}
