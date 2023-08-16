package test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import java.lang.*;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTimeZone;
import org.joda.time.Instant;

import com.aventstack.extentreports.model.Log;
import com.google.common.base.Stopwatch;

import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.PropertySet;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.enumeration.property.BasePropertySet;
import microsoft.exchange.webservices.data.core.enumeration.property.BodyType;
import microsoft.exchange.webservices.data.core.enumeration.property.WellKnownFolderName;
import microsoft.exchange.webservices.data.core.enumeration.search.LogicalOperator;
import microsoft.exchange.webservices.data.core.enumeration.search.SortDirection;
import microsoft.exchange.webservices.data.core.service.folder.Folder;
import microsoft.exchange.webservices.data.core.service.item.EmailMessage;
import microsoft.exchange.webservices.data.core.service.item.Item;
import microsoft.exchange.webservices.data.core.service.schema.EmailMessageSchema;
import microsoft.exchange.webservices.data.core.service.schema.ItemSchema;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.property.complex.MessageBody;
import microsoft.exchange.webservices.data.search.filter.SearchFilter;
import microsoft.exchange.webservices.data.search.filter.SearchFilter.SearchFilterCollection;
import microsoft.exchange.webservices.data.search.*;

public class ReadEmailClientTest {
	
	public static void connect()
	{
		ExchangeService service;
	    Folder inbox;
		Integer timeout;
		Integer checkInterval;
		boolean debug;
		System.out.println("Connecting");
		service = new ExchangeService(ExchangeVersion.Exchange2010_SP2);
		ExchangeCredentials credentials = new WebCredentials("srijani.kandi1@outlook.com","ushaSATISH@504313");
		service.setCredentials(credentials);
		
		try {
			service.setUrl(new URI("https://outlook.com"+"/EWS/Exchange.asmx"));
			inbox = Folder.bind(service,  WellKnownFolderName.Inbox);
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace(System.err);
			
		}
	}
	
	public static void main(String args[]) throws IOException {
	
	ExchangeService service;
    Folder inbox;
	Integer timeout = 20;
	Integer checkInterval;
	boolean debug;
	String subject = "Testing Email";
	boolean isRead = true;
	String expectedBodyText = null;
	
	
	System.out.println("Searching the mail with subject"+subject);
	SearchFilterCollection sf = new SearchFilter.SearchFilterCollection();
	sf.add(new SearchFilter.ContainsSubstring(ItemSchema.Subject,subject.trim()));
	
	if(null==expectedBodyText) {
		expectedBodyText = "";
	}
	List<String> emailMessageBody = null;
	List<String> emailFoundMessageBody;
	
	//reading the expected mail body
	File f = new File(System.getProperty("user.dir")+"/testdata/samplemail");
	expectedBodyText = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"/testdata/samplemail"), "UTF-8");
	emailMessageBody = new ArrayList<String>(Arrays.asList(expectedBodyText.split("\n")));
	
	
	boolean found = false;
	String expectedMailKey = "Srijani";
	
	PropertySet itempropertyset = new PropertySet(BasePropertySet.FirstClassProperties);
	itempropertyset.setRequestedBodyType(BodyType.Text);//set the body type as html if it is html
	ItemView itemview = new ItemView(100);
	try {
		itemview.getOrderBy().add(ItemSchema.DateTimeReceived, SortDirection.Descending);
	}
	catch(Exception ex) {
		ex.printStackTrace();
	}
	
	Stopwatch s = Stopwatch.createStarted();
	while(s.elapsed(TimeUnit.SECONDS) < timeout && found==false)
	{
		service = new ExchangeService(ExchangeVersion.Exchange2010_SP2);
		ExchangeCredentials credentials = new WebCredentials("srijani.gupta@outlook.com","@94guptaSRIJANI");
		service.setCredentials(credentials);
		
		try {
			service.setUrl(new URI("https://outlook.com"+"/EWS/Exchange.asmx"));
			inbox = Folder.bind(service,  WellKnownFolderName.Inbox);
			inbox.load();
			FindItemsResults<Item> findResults;
			findResults = inbox.findItems(sf , new ItemView(Integer.MAX_VALUE));
			System.out.println(findResults.getItems().size());
			if(findResults.getItems().size() > 0)
			{
				System.out.println("Subject found");
				for(Item email : findResults.getItems())
				{
					email.load(itempropertyset);
					EmailMessage msg = (EmailMessage)email;
					Date received = msg.getDateTimeReceived();
					System.out.println(received);
					Date d = new Date();
					SimpleDateFormat format = new SimpleDateFormat("MMM dd HH:mm:ss z yyyy");
					format.setTimeZone(TimeZone.getTimeZone("IST"));
					String expected = format.format(d);
					//System.out.println(expected);
					
					Date expectedDate = format.parse(expected);
					System.out.println(expectedDate);
					String receivedDate = format.format(received);
					Date receivedD = format.parse(receivedDate);
					System.out.println(receivedD);
					System.out.println(receivedD.before(expectedDate));
					
					String foundBodyEmail =  MessageBody.getStringFromMessageBody(msg.getBody());
					if(foundBodyEmail.contains(expectedMailKey) &&
							receivedD.before(expectedDate))
					{
						Stream<String> bodyTextArray;
						bodyTextArray = Stream.of(foundBodyEmail);
						found = true;
					}
				
				if(found == true)
				{
					emailFoundMessageBody =  new ArrayList<String>(Arrays.asList(foundBodyEmail.trim().split("/n")));
					System.out.println("Achieved");
					System.out.println(emailFoundMessageBody);
					System.out.println(emailMessageBody);
					System.out.println(emailFoundMessageBody.size());
					System.out.println(emailMessageBody.size());
					System.out.println(emailFoundMessageBody.containsAll(emailMessageBody));
					break;
					
				}
				}
			}
			
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
	}
	
	}

}
