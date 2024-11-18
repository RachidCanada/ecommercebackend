package com.ecommerce.services;

import java.util.Properties;


import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ServiceMailing {
	
	@Value("${config.mail.sender_mail}")
	private String SENDER_MAIL;
	
	@Value("${config.mail.sender_password}")
	private String SENDER_PASSWORD;
	
	@Value("${config.mail.host}")
	private String HOST_MAIL;
	
	@Value("${config.mail.port}")
	private String PORT_MAIL;
	
	private final String OBJECT_CONFIRMATION_INSCRIPTION = "Confirmation inscription";
	
	private final String OBJECT_CONFIRMATION_COMMANDE = "Confirmation de votre commande";
	
	
	public void confirmationInscription(String email) {
		String contenu;
		
		contenu="Ceci est un mail de confirmation de votre inscription.";
		
		sendMail(email, OBJECT_CONFIRMATION_INSCRIPTION, contenu);
	}
	
	private void sendMail(String dest, String object, String text) {
		// Activer explicitement TLSv1.2 et TLSv1.3
		System.setProperty("https.protocols", "TLSv1.2,TLSv1.3");

		// Propriétés pour le serveur SMTP
		Properties propMail = new Properties();
		propMail.put("mail.smtp.auth", "true");
		propMail.put("mail.smtp.starttls.enable", "true");
		propMail.put("mail.smtp.host", HOST_MAIL);
		propMail.put("mail.smtp.port", PORT_MAIL);
		propMail.put("mail.smtp.ssl.trust", HOST_MAIL);
		propMail.put("mail.smtp.ssl.protocols", "TLSv1.2");

		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(SENDER_MAIL, SENDER_PASSWORD);
			}
		};

		// Envoi du message
		try {
			// Créer une session
			Session session = Session.getInstance(propMail, auth);

			// Créer un message
			Message message = new MimeMessage(session);

			// Ajout du sender
			message.setFrom(new InternetAddress("ne-pas-repondre@gmail.com"));

			// Ajout du destinataire
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(dest));

			// Ajout de l'objet
			message.setSubject(object);

			// Ajout du corps de l'email
			message.setText(text);
			Transport.send(message);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
}
