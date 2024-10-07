package kr.co.sh.labor.mysql_jpa.users.repository;


import java.util.Optional;
import kr.co.sh.labor.mysql_jpa.users.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
    UserEntity findByEmailAndPassword(String email, String password);

}