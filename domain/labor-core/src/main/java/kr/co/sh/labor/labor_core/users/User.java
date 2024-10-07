package kr.co.sh.labor.labor_core.users;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private String email;
    private String password;
    private Set<String> userRoles;

}