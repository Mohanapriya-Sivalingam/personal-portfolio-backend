
package com.example.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;   // ← FIXED: was lombok.Value (wrong!)
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${app.mail.to}")
    private String mailTo;

    public void sendContactEmail(String name, String senderEmail, String message) {
        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(mailTo);
            mail.setSubject("Portfolio Contact from: " + name);
            mail.setText(
                    "Name: " + name + "\n" +
                            "Email: " + senderEmail + "\n\n" +
                            "Message:\n" + message
            );
            mail.setReplyTo(senderEmail);
            mailSender.send(mail);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send email: " + e.getMessage());
        }
    }
}