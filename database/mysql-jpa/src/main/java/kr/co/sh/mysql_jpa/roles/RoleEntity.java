package kr.co.sh.mysql_jpa.roles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import kr.co.sh.mysql_jpa.users.UserRoleEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "role")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoleEntity {

    @Id
    @Column(name = "role_id")
    private Long id;

    @Column(name = "role", columnDefinition = "varchar(20)")
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @OneToMany(mappedBy = "role")
    private Set<UserRoleEntity> userRoles = new HashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RoleEntity role = (RoleEntity) o;
        return Objects.equals(id, role.id) && roleType == role.roleType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleType);
    }

    public RoleEntity(RoleType roleType){
        this.id = roleType.id;
        this.roleType = roleType;
    }

    public enum RoleType{
        ROLE_USER(100L),
        ROLE_ADMIN(200L);

        private long id;

        RoleType(long id){
            this.id = id;
        }
    }
}
