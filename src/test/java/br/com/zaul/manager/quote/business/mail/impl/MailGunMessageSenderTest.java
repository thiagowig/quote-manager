package br.com.zaul.manager.quote.business.mail.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.zaul.manager.quote.business.mail.contract.EmailSender;

@RunWith(MockitoJUnitRunner.class)
public class MailGunMessageSenderTest {
	
	

	@Test
	public void testMail() {
		EmailSender sender = new MailGunMessageSender();
		
		sender.from("thiago.fonseca@arkhi.com.br").to("dev.thiago@gmail.com").withTheSubject("Test").withTheText("Texto").send();
		
	}
}
