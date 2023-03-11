package com.ali.service;

import com.ali.repository.entity.Mail;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailSenderService {
    private final JavaMailSender javaMailSender;
    public void sendMail(Mail email) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("${mailusername}");
        mailMessage.setTo(email.getMail());
        mailMessage.setSubject("Aktivasyon kodunuz: ");
        mailMessage.setText(email.getCode());
        javaMailSender.send(mailMessage);
    }

}
