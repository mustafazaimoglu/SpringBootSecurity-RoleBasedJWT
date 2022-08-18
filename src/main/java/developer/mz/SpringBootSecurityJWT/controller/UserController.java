package developer.mz.SpringBootSecurityJWT.controller;

import developer.mz.SpringBootSecurityJWT.model.User;
import developer.mz.SpringBootSecurityJWT.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/")
public class UserController {
    @Autowired
    JwtUserDetailsService jwtUserDetailsService;

    @GetMapping("hello")
    public String hello() {
        return "Sup, bruw?";
    }

    @GetMapping("save")
    public String save() {
        jwtUserDetailsService.save(new User(0,"test","test","USER"));
        jwtUserDetailsService.save(new User(0,"test2","test2","ADMIN"));
        return "saved! I mean I guess!";
    }
}
