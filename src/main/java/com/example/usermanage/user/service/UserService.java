package com.example.usermanage.user.service;

import com.example.usermanage.user.param.RegisterParam;
import com.example.usermanage.user.vo.Result;

/**
 * @author zhiyaoma
 */
public interface UserService {

    /**
     * 注册用户
     *
     * @param param
     * @return
     */
    Result register(RegisterParam param);

    /**
     * (soft)删除
     *
     * @param userId
     * @return
     */
    Result delete(Long userId);


    /**
     * 根据姓名查询
     *
     * @param name
     * @return
     */
    Result queryList(String name);
}
