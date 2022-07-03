package com.example.usermanage.user.listener;

import com.example.usermanage.user.event.NoticeEvent;
import com.example.usermanage.user.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 监听注册事件
 *
 * @author zhiyaoma
 */
@Component
@Slf4j
public class NoticeListener implements ApplicationListener<NoticeEvent> {
    @Autowired
    private MailService mailService;

    @Override
    public void onApplicationEvent(NoticeEvent event) {

        log.info("user: {} register successfully!", event.getUserDTO().getUserName());

        //发送内容
        String content = "hi, welcome to register our service!";
        String subject = "welcome mail";

        mailService.send(event.getTo(), subject, content);
    }
}
