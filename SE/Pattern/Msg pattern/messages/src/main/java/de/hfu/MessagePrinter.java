package de.hfu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.hfu.messages.domain.model.Message;
import de.hfu.messages.domain.service.MessageService;

@Component
public class MessagePrinter {

	@Autowired
	private MessageService messageService;
	
	public void setMessageService(
	MessageService messageService) {
	this.messageService = messageService;
	}
	

	public void outputMessages(String author) {
		for (Message message : messageService.findAllMessages()) {
			if (message.getUser().getUsername().equals(author)) {
			System.out.println(message.getText());
			}
			}
			}
}
