package com.example.usermanage.user.event;

import com.alibaba.fastjson.JSON;
import com.example.usermanage.user.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

/**
 * 执行时间
 *
 * @author zhiyaoma
 */
@Slf4j
public class NoticeEvent extends ApplicationEvent {

    private String to;

    private UserDTO userDTO;

    public NoticeEvent(UserDTO userDTO, String to) {
        super(userDTO);
        this.userDTO = userDTO;
        this.to = to;
        log.info("add event success! user: {}", JSON.toJSONString(userDTO));
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
