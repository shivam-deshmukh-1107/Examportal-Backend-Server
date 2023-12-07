//Examserver.Application code
package com.exam.examserver;

import com.exam.examserver.model.Role;
import com.exam.examserver.model.User;
import com.exam.examserver.model.UserRole;
import com.exam.examserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(ExamserverApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting Code!!!!");

        User user = new User();

        user.setFirstname("Shivam");
        user.setLastname("Deshmukh");
        user.setUsername("admin");
        user.setPassword(this.bCryptPasswordEncoder.encode("admin"));
        user.setEmail("admin.com");
        user.setProfile("default.png");
        user.setPhone("8879891779");

        Role role_1 = new Role();
        role_1.setRoleID(44L);
        role_1.setRoleName("ADMIN");

        Set<UserRole> userRoleSet = new HashSet<>();
        UserRole userRole = new UserRole();
        userRole.setRole(role_1);
        userRole.setUser(user);
        userRoleSet.add(userRole);
        User user_1 = this.userService.createUser(user, userRoleSet);
        System.out.println(user_1.getUsername());

    }
}
