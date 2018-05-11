package com.renzo.cursoMC.services;

import org.springframework.mail.SimpleMailMessage;

import com.renzo.cursoMC.domain.Pedido;

public interface EmailService {
	
	public void sendOrderConfirmationEmail(Pedido obj);
	
	public void sendEmail(SimpleMailMessage msg);

}
