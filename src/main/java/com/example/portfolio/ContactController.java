package com.example.portfolio;

import com.example.portfolio.model.Contact;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contactms")
@CrossOrigin(origins = "http://localhost:5173")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendmessage")
    public ResponseEntity<String> sendMessage(@Valid @RequestBody Contact contact){

        try{
            contactService.sendMessage(contact);

            emailService.sendEmail(contact.getName(),
                    contact.getEmail(),
                    contact.getMessage());
            return ResponseEntity.ok("Message Saved & Email Sent Successfully!");

        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Something went wrong!");
        }

    }


}
