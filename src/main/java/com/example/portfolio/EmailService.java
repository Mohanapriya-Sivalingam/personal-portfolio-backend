package com.example.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

public void sendEmail(String name, String email, String message){
    SimpleMailMessage mail = new SimpleMailMessage();

    mail.setTo("mohanapriyasivalingam@gmail.com");
    mail.setSubject("From Portfolio: New Contact Form Message!");
    mail.setText(
            "Name : " + name + "\n" +
            "Email : " + email + "\n" +
                    "Message: " + message
    );
    javaMailSender.send(mail);
}
}

