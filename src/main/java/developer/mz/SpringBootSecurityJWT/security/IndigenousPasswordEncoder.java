package developer.mz.SpringBootSecurityJWT.security;

import developer.mz.SpringBootSecurityJWT.util.HashCreator;
import org.springframework.security.crypto.password.PasswordEncoder;

// In order to use my own encoder
public class IndigenousPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return HashCreator.create(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return HashCreator.create(rawPassword.toString()).equals(encodedPassword);
    }
}
