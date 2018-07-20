package reg;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

   public static void sendEmail (String email, String userpassword) {    
	 
	      String from = "harshitamandloi25@gmail.com";//change accordingly
	      final String username = "harshitamandloi25";//change accordingly
	      final String password = "princess251291";//change accordingly

	      
	      String host = "smtp.gmail.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
	      });
       //compose message    
       try {    
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));    
        message.setSubject("Retrived Password !!!");    
        message.setText("Your password is: " + userpassword);    
        //send message  
        Transport.send(message);    
        System.out.println("message sent successfully");    
       } catch (MessagingException e) {throw new RuntimeException(e);}    
          
 }  
}  


