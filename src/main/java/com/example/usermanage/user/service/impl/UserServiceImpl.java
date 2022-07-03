package com.example.usermanage.user.service.impl;

import com.example.usermanage.user.dto.UserDTO;
import com.example.usermanage.user.event.NoticeEvent;
import com.example.usermanage.user.exception.SystemErrorType;
import com.example.usermanage.user.manager.UserManager;
import com.example.usermanage.user.param.RegisterParam;
import com.example.usermanage.user.service.UserService;
import com.example.usermanage.user.vo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author zhiyaoma
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserManager userManager;
    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public Result register(RegisterParam param) {
        //校验手机号是否存在
        if (userNameExists(param.getUserName())) {
            return Result.fail(SystemErrorType.USER_EXITS);
        }
        //校验邮箱是否存在
        if (emailExists(param.getEmail())) {
            return Result.fail(SystemErrorType.EMAIL_EXITS);
        }
        //校验密码是否一致
        if (Objects.equals(param.getEmail(), param.getPasswordConfirm())) {
            return Result.fail(SystemErrorType.PW_NOT_EQUAL);
        }
        //保存用户
        UserDTO ud = convert(param);
        userManager.createUser(ud);

        //发布注册完成事件，用于异步发送邮件通知
        publisher.publishEvent(new NoticeEvent(ud, ud.getEmail()));

        return Result.success();
    }

    @Override
    public Result delete(Long userId) {
        if (!userExits(userId)) {
            return Result.fail(SystemErrorType.USER_NOT_EXITS);
        }
        userManager.deleteUser(userId);
        return Result.success();
    }

    @Override
    public Result queryList(String name) {
        List<UserDTO> userList = userManager.findUserByName(name);
        return Result.success(userList);
    }

    private Boolean userNameExists(String userName) {
        List<UserDTO> userList = userManager.findUserByName(userName);
        return !CollectionUtils.isEmpty(userList);
    }

    private Boolean emailExists(String email) {
        UserDTO ud = userManager.findUserByEmail(email);
        return ud != null;
    }

    private UserDTO convert(RegisterParam param) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(param, userDTO);
        return userDTO;
    }

    private Boolean userExits(Long id) {
        UserDTO ud = userManager.findUserById(id);
        return ud != null;
    }
}
