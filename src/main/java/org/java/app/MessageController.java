package org.java.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.ui.Model;
@Controller
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageServ messageServ;

    @GetMapping
    public String getIndex(Model model) {
        
        List<Message> messages = messageServ.findAll();
        model.addAttribute("messages", messages);
        
        return "message-index";
    }
    
    @PostMapping("/delete/{id}")
	public String deletePizza(@PathVariable int id) {

		Message message = messageServ.findById(id);;
		messageServ.deleteMessage(message);

		return "redirect:/messages";
	}
}

