package com.example.usermanage.user.controller;

import com.alibaba.fastjson.JSON;
import com.example.usermanage.user.dto.UserDTO;
import com.example.usermanage.user.manager.UserManager;
import com.example.usermanage.user.param.RegisterParam;
import com.example.usermanage.user.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.validation.constraints.AssertTrue;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserControllerTest {

    @Autowired
    private UserController userController;
    @Autowired
    private UserManager userManager;

    @Test
    void register() {
        RegisterParam param = new RegisterParam();
        param.setEmail("2345654@163.com");
        param.setUserName("lisi");
        param.setPassword("123456");
        param.setPasswordConfirm("123456");
        Result register = userController.register(param);
        log.info(JSON.toJSONString(register));
        Assert.isTrue(register.getCode().equals("00000"), "注册失败");
    }

    @Test
    void deleteById() {
        Result result = userController.deleteById(1543531152067837953l);
        Assert.isTrue(result.getCode().equals("00000"), "删除失败");
        UserDTO userById = userManager.findUserById(1543531152067837953l);
        Assert.isNull(userById, "删除失败");
    }

    @Test
    void queryList() {
        Result result = userController.queryList("zhangsan");
        log.info(JSON.toJSONString(result));
        Assert.notNull(result.getData(), "用户列表为空");
    }
}