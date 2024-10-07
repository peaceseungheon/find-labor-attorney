package kr.co.sh.labor.mysql_jpa.users.adapter;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import kr.co.sh.labor.labor_core.ports.users.UserPersistencePort;
import kr.co.sh.labor.labor_core.users.User;
import kr.co.sh.labor.mysql_jpa.roles.RoleEntity;
import kr.co.sh.labor.mysql_jpa.roles.RoleEntity.RoleType;
import kr.co.sh.labor.mysql_jpa.users.UserEntity;
import kr.co.sh.labor.mysql_jpa.users.UserRoleEntity;
import kr.co.sh.labor.mysql_jpa.users.repository.UserRepository;
import kr.co.sh.labor.mysql_jpa.users.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<UserEntity> user = userRepository.findByEmail(email);
        return user.map(UserEntity::toUserDomain);
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = new UserEntity(user.getEmail(), user.getPassword());
        Set<UserRoleEntity> userRoles = user.getUserRoles().stream()
            .map(role -> new UserRoleEntity(userEntity, new RoleEntity(RoleType.valueOf(role))))
            .collect(Collectors.toSet());
        userEntity.setUserRoles(userRoles);
        userRepository.save(userEntity);
        userRoleRepository.saveAll(userRoles);
        return userEntity.toUserDomain();
    }
}