package test;

import java.net.URI;
import java.nio.charset.Charset;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import com.aspose.email.MailAddress;
import com.aspose.email.MailMessage;
import com.aspose.email.SmtpClient;

import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.enumeration.property.WellKnownFolderName;
import microsoft.exchange.webservices.data.core.service.folder.Folder;
import microsoft.exchange.webservices.data.core.service.item.EmailMessage;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.property.complex.MessageBody;

public class EmailClientTest {
public static void main(String args[]) {
	
	ExchangeService service;
    Folder inbox;
	Integer timeout;
	Integer checkInterval;
	boolean debug;
	

	
	//public void connect()
	//{
		service = new ExchangeService(ExchangeVersion.Exchange2010_SP2);
		ExchangeCredentials credentials = new WebCredentials("srijani.kandi1@outlook.com","ushaSATISH@504313");
		service.setCredentials(credentials);
		
		try {
			service.setUrl(new URI("https://outlook.com"+"/EWS/Exchange.asmx"));
			//inbox = Folder.bind(service,  WellKnownFolderName.Inbox);
			//sendEmail();
			System.out.println("Conected");
			EmailMessage msg = new EmailMessage(service);
			msg.setSubject("Testing Email");
			msg.setBody(MessageBody.getMessageBodyFromText("Srijani,This is test mail for outlook"));
			msg.getToRecipients().add("srijani.gupta@outlook.com");
			msg.send();
			service.close();
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace(System.err);
			
		}
	}
	

	
}
