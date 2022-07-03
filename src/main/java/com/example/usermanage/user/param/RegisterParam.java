package com.example.usermanage.user.param;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author zhiyaoma
 */
@Data
public class RegisterParam {

    @Min(value = 0L, groups = Update.class)
    private Long id;
    @NotNull(groups = {Save.class, Update.class})
    @Length(min = 2, max = 10, groups = {Save.class, Update.class})
    private String userName;
    /**
     * 密码至少8位
     */
    @NotNull
    @Length(min = 8, groups = {Save.class, Update.class})
    private String password;
    /**
     * 二次确认密码，至少8位
     */
    @NotNull
    @Length(min = 8, groups = {Save.class, Update.class})
    private String passwordConfirm;
    /**
     * 必须为邮箱
     */
    @NotNull
    @Email
    private String email;

    /**
     * 用于保存操作分组校验
     */
    public interface Save {
    }

    /**
     * 用于更新操作分组校验
     */
    public interface Update {
    }
}
