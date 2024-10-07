package kr.co.sh.labor.labor_core.ports.users;


import java.util.Optional;
import kr.co.sh.labor.labor_core.users.User;

public interface UserPersistencePort {

    Optional<User> findByEmail(String email);

    User save(User user);

}