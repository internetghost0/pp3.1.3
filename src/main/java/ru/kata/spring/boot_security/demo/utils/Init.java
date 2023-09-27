package ru.kata.spring.boot_security.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

import javax.annotation.PostConstruct;

@Component
public class Init {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @PostConstruct
    public void postConstruct() {
        roleService.saveOrUpdateRole(new Role("ROLE_ADMIN"));
        roleService.saveOrUpdateRole(new Role("ROLE_MODERATOR"));
        roleService.saveOrUpdateRole(new Role("ROLE_USER"));

        User adminUser = new User("admin", "admin", "ghost", roleService.getAllRoles());
        userService.saveOrUpdateUser(adminUser);

        User moder = new User("moder", "moder", "moder", roleService.findByNameRole("ROLE_MODERATOR").toSet());
        userService.saveOrUpdateUser(moder);

        User user = new User("user", "user", "user", roleService.findByNameRole("ROLE_USER").toSet());
        userService.saveOrUpdateUser(user);

    }
}
