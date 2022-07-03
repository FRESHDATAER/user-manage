package com.example.usermanage.user.convert;

import com.example.usermanage.user.Do.UserDO;
import com.example.usermanage.user.dto.UserDTO;
import org.springframework.beans.BeanUtils;

/**
 * 用户类转换器
 *
 * @author zhiyaoma
 */
public class UserConverter {

    public static UserDTO DO2DTO(UserDO userDO) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userDO, userDTO);
        return userDTO;
    }

    public static UserDO DTO2DO(UserDTO userDTO) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userDTO, userDO);
        return userDO;
    }

    public static UserDTO DTO2VO(UserDTO userDO) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userDO, userDTO);
        return userDTO;
    }
}
