package kr.co.sh.labor.mysql_jpa.users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import kr.co.sh.labor.labor_core.users.User;
import kr.co.sh.labor.mysql_jpa.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no")
    private Long userNo;

    @Column(name = "email", columnDefinition = "varchar(50)", unique = true, nullable = false)
    private String email;

    @Column(name = "password", columnDefinition = "varchar(200)")
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<UserRoleEntity> userRoles = new HashSet<>();

    public UserEntity(String email, String password){
        this.email = email;
        this.password = password;
    }

    public void setUserRoles(Set<UserRoleEntity> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserEntity user = (UserEntity) o;
        return Objects.equals(userNo, user.userNo) && Objects.equals(email,
            user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userNo, email);
    }

    public User toUserDomain() {
        return User.builder()
            .email(email)
            .password(password)
            .userRoles(userRoles.stream().map(role-> role.getRole().getRoleType().name()).collect(Collectors.toSet()))
            .build();
    }

}
