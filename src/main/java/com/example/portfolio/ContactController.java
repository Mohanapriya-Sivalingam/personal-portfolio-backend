

package com.example.portfolio;

import com.example.portfolio.model.Contact;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contactms")
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendmessage")
    public ResponseEntity<String> contact(@Valid @RequestBody Contact contact) {  // ← FIXED: Use Contact model directly
        try {
            emailService.sendContactEmail(
                    contact.getName(),
                    contact.getEmail(),
                    contact.getMessage()
            );
            return ResponseEntity.ok("Message sent successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send message. Please try again.");
        }
    }
}