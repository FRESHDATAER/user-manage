package com.example.usermanage.user.vo;

import lombok.Data;

/**
 * @author zhiyaoma
 */
@Data
public class UserVO {
    /**
     * 用户id
     */
    private Long id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 创建时间(YYYY-MM-DD HH:MM:SS)
     */
    private String createTime;
    /**
     * 更新时间(YYYY-MM-DD HH:MM:SS)
     */
    private String updateTime;
}
