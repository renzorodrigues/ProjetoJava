package com.renzo.cursoMC.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.renzo.cursoMC.domain.Pedido;

public interface EmailService {

	public void sendOrderConfirmationEmail(Pedido obj);

	public void sendEmail(SimpleMailMessage msg);

	void sendOrderConfirmationHtmlEmail(Pedido obj);

	void sendHtmlEmail(MimeMessage msg);

}
