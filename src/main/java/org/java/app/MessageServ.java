package org.java.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServ {
	@Autowired
	private MessageRepo messageRepo;
	public Message save(Message message) {
		return messageRepo.save(message);
	}
}
