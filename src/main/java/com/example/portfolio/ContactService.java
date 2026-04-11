package com.example.portfolio;

import com.example.portfolio.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact sendMessage(Contact contact){
        return contactRepository.save(contact);
    }

}
