
package com.example.portfolio;

import com.example.portfolio.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private JavaMailSender mailSender;

    public String sendMessage(Contact contact){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("mohanapriyasivalingam@gmail.com");
        message.setSubject("New Contact Form Message");

        message.setText(
                "Name: " + contact.getName() + "\n" +
                        "Email: " + contact.getEmail() + "\n\n" +
                        "Message:\n" + contact.getMessage()
        );

        mailSender.send(message);

        return "Message sent successfully!";
    }
}