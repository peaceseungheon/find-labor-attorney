package kr.co.sh.find_labor_attorney.entity.users.repository;

import java.util.Optional;
import kr.co.sh.find_labor_attorney.entity.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    User findByEmailAndPassword(String email, String password);

}
