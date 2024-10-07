package kr.co.sh.labor.mysql_jpa.users.repository;


import kr.co.sh.labor.mysql_jpa.users.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

}