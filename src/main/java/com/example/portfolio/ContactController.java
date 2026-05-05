
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
    private ContactService contactService;

    @PostMapping("/sendmessage")
    public ResponseEntity<String> sendMessage(@Valid @RequestBody Contact contact) {
        try {
            String response = contactService.sendMessage(contact);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send message: " + e.getMessage());
        }
    }
}