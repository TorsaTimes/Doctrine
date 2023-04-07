package de.hfu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MessageApp {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MessageApp.class, args);
		MessagePrinter messagePrinter = ctx.getBean(MessagePrinter.class);
		messagePrinter.outputMessages("stefan");
	}

}
