package kr.co.sh.labor.mysql_jpa.users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import kr.co.sh.labor.mysql_jpa.roles.RoleEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user_role")
public class UserRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    public UserRoleEntity(UserEntity user, RoleEntity role){
        this.user = user;
        this.role = role;
    }

}
