package com.example.usermanage.user.service;

/**
 * @author zhiyaoma
 */
public interface MailService {

    /**
     * @param to      接受人
     * @param subject 主题
     * @param text    内容
     */
    void send(String to, String subject, String text);
}
