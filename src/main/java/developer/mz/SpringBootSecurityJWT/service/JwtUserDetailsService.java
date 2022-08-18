package developer.mz.SpringBootSecurityJWT.service;

import java.util.Collections;

import developer.mz.SpringBootSecurityJWT.security.IndigenousPasswordEncoder;
import developer.mz.SpringBootSecurityJWT.model.User;
import developer.mz.SpringBootSecurityJWT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.singleton(getAuthority(user)));
    }

    private SimpleGrantedAuthority getAuthority(User user) {
        return new SimpleGrantedAuthority(user.getRole());
    }

//    public User save(User user) {
//        User newUser = new User();
//        newUser.setUsername(user.getUsername());
//        newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
////        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
//        return userRepository.save(newUser);
//    }

    public User save(User user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(new IndigenousPasswordEncoder().encode(user.getPassword()));
        newUser.setRole(user.getRole());
        return userRepository.save(newUser);
    }
}
