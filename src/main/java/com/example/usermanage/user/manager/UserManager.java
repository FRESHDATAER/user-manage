package com.example.usermanage.user.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.usermanage.user.Do.UserDO;
import com.example.usermanage.user.common.enums.DeleteEnum;
import com.example.usermanage.user.convert.UserConverter;
import com.example.usermanage.user.dto.UserDTO;
import com.example.usermanage.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhiyaoma
 */
@Component
public class UserManager {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据邮箱查询用户
     *
     * @param email
     * @return
     */
    public UserDTO findUserByEmail(String email) {
        QueryWrapper<UserDO> wrapper = new QueryWrapper<>();
        wrapper.eq("email", email).eq("is_deleted", DeleteEnum.NOT_DELETED);
        UserDO userDO = userMapper.selectOne(wrapper);
        if (userDO == null) {
            return null;
        }
        return UserConverter.DO2DTO(userDO);
    }

    /**
     * 根据姓名查询用户
     *
     * @param name
     * @return
     */
    public List<UserDTO> findUserByName(String name) {
        QueryWrapper<UserDO> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", name).eq("is_deleted", DeleteEnum.NOT_DELETED.getCode());
        List<UserDO> list = userMapper.selectList(wrapper);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.stream().map(userDO -> UserConverter.DO2DTO(userDO)).collect(Collectors.toList());
    }

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    public UserDTO findUserById(Long id) {
        QueryWrapper<UserDO> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id).eq("is_deleted", DeleteEnum.NOT_DELETED.getCode());
        UserDO ud = userMapper.selectOne(wrapper);
        if (ud == null){
            return null;
        }
        return UserConverter.DO2DTO(ud);
    }

    /**
     * 创建用户
     *
     * @param userDTO
     */
    public void createUser(UserDTO userDTO) {
        UserDO userDO = UserConverter.DTO2DO(userDTO);
        userMapper.insert(userDO);
    }

    /**
     * 根据用户id删除用户
     *
     * @param userId
     */
    public void deleteUser(Long userId) {
        UserDO userDO = new UserDO();
        userDO.setIsDeleted(DeleteEnum.DELETED.getCode());
        UpdateWrapper<UserDO> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", userId);
        userMapper.update(userDO, wrapper);
    }

    /**
     * 根据用户id更新用户
     *
     * @param userDTO
     */
    public void updateUser(UserDTO userDTO) {
        UserDO userDO = UserConverter.DTO2DO(userDTO);
        UpdateWrapper<UserDO> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", userDO.getId());
        userMapper.update(userDO, wrapper);
    }

}
