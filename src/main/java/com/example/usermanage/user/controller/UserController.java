package com.example.usermanage.user.controller;

import com.example.usermanage.user.param.RegisterParam;
import com.example.usermanage.user.service.UserService;
import com.example.usermanage.user.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户
 *
 * @author zhiyaoma
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/register")
    public Result register(@RequestBody @Validated({RegisterParam.Save.class}) RegisterParam param) {
        return userService.register(param);
    }

    @GetMapping("/user/delete")
    public Result deleteById(@RequestParam Long id) {
        return userService.delete(id);
    }

    @GetMapping("/user/queryList")
    public Result queryList(@RequestParam String name) {
        return userService.queryList(name);
    }
}
