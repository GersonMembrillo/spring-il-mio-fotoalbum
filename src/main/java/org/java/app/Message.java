package org.java.app;

import org.java.app.api.MessageDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Message {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String subject;

    public Message() {}
    public Message(int id, String name, String email, String subject) {
    	this.id = id;
        this.name = name;
        this.email = email;
        this.subject = subject;
    }
    
    public Message(MessageDTO messageDto) {
    	setId(messageDto.getId());
        setName(messageDto.getName());
        setEmail(messageDto.getEmail());
        setSubject(messageDto.getSubject());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

