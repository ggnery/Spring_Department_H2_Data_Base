package com.project.userdept;

import com.project.userdept.controllers.UserController;
import com.project.userdept.entities.Department;
import com.project.userdept.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class UserDeptApplicationTests {
    @Autowired
    private UserController controller;

    @Test
    public void testAddUser() {
        User user = new User("Jonh", "jonh1337@gmail.com", new Department(1, "Gestão"));

        //Adiciono o usuário na base de dados
        User savedUser = controller.insert(user);

        //Pego todos os usuários da minha base de dados
        List<User> allUsers = controller.findAll();

        //Verifico se o usuário que inseri está na base de dados
        boolean result = allUsers.contains(savedUser);
        assertTrue(result);

    }

    @Test
    public void testFindUser(){
        User user = new User("Mario", "MarioArmario@gmail.com", new Department(2, "Informática"));
        User savedUser = controller.insert(user);

        User expected = controller.findById(user.getId());

        boolean result = savedUser.equals(expected);
        assertTrue(result);
    }

}
