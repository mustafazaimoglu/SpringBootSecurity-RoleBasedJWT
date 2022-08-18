package developer.mz.SpringBootSecurityJWT.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test/")
public class TestController {

    @GetMapping("hello-admin")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String helloAdmin() {
        return "How you doin' admin?";
    }

    @GetMapping("hello-user")
    @PreAuthorize("hasAuthority('USER')")
    public String helloUser() {
        return "How you doin' user?";
    }

    @GetMapping("hello-all")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public String helloAll() {
        return "How you doin' admin-and-user?";
    }
}
