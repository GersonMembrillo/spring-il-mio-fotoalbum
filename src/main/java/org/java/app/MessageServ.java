package org.java.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServ {
	
	@Autowired
	private MessageRepo messageRepo;
	
	public Message save(Message message) 
	
	{
		
		return messageRepo.save(message);
		
	}

	public List<Message> findAll() {
		
		return messageRepo.findAll();
		
	}

	public Message findById(int id) {
		
		return messageRepo.findById(id).get();
	
	}
	
	public void deleteMessage(Message message) {
	    messageRepo.deleteById(message.getId());
	}
	
}
