package com.example.usermanage.usermanage;

import com.example.usermanage.user.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserManageApplicationTests {

    @Autowired
    private UserController controller;

    @Test
    void contextLoads() {
    }


}
