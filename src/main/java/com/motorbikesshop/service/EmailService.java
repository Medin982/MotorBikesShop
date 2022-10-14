package com.motorbikesshop.service;

import com.motorbikesshop.model.dtos.EmailRequestDTO;
import com.motorbikesshop.model.view.UserViewModel;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    private final TemplateEngine templateEngine;
    private final MessageSource messageSource;
    private final JavaMailSender  javaMailSender;

    public EmailService(TemplateEngine templateEngine, MessageSource messageSource, JavaMailSender javaMailSender) {
        this.templateEngine = templateEngine;
        this.messageSource = messageSource;
        this.javaMailSender = javaMailSender;
    }

    public void sendRegistrationEmail(String userEmail, String username) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setFrom("motorBikeShop@mail.com");
            mimeMessageHelper.setTo(userEmail);
            mimeMessageHelper.setSubject("Welcome!");
            mimeMessageHelper.setText(generateMessageContent(username, "userName", "email/registrationEmail"), true);
            javaMailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateMessageContent(String subject, String field, String template) {
        Context ctx = new Context();
        ctx.setVariable(field, subject);
        return templateEngine.process(template, ctx);
    }

    public void sendRequestEmailToSeller(UserViewModel seller, EmailRequestDTO emailRequestDTO) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setFrom(emailRequestDTO.getEmail());
            mimeMessageHelper.setTo(seller.getEmail());
            mimeMessageHelper.setSubject("Some Request for product.");
            mimeMessageHelper.setText(generateMessageContent(emailRequestDTO.getMessage(),
                    "message", "email/requestEmail"), true);
            javaMailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
