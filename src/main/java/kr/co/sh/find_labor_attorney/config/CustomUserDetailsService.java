package kr.co.sh.find_labor_attorney.config;

import java.util.Optional;
import kr.co.sh.find_labor_attorney.entity.users.User;
import kr.co.sh.find_labor_attorney.entity.users.repository.UserRepository;
import kr.co.sh.find_labor_attorney.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(username);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User Not Found");
        }
        return optionalUser.get();
    }
}
