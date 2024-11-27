package com.myapp.assignment11;

import org.springframework.stereotype.Component;

/*
    TODO:
    - Annotate this class with @Component
    - Inject the Channel and Message instance using @Autowired
*/

@Component
public class NotificationService {
  
  Channel channel;
  Message message;
  
  // autowired constructor
  public NotificationService(Channel channel, Message message){
    this.channel = channel;
    this.message = message;
  }
  
  public void setup(String to, String messageInput){
      message.setTo(to);
      message.setMessage(messageInput);
      // System.out.println("---Start of NotificationService setup---");
      // System.out.println("To: " + to + "\n" + message);
      // System.out.println("---End of NotificationService setup---");
  }

  public void send(){
      StringBuilder messageBuilder = new StringBuilder();
      messageBuilder.append("---Sending notification ...---");
      messageBuilder.append("\nTo:");
      messageBuilder.append(this.message.getTo());
      messageBuilder.append("\nMessage:");
      messageBuilder.append(this.message.getMessage());
      messageBuilder.append("\nChannel:");
      messageBuilder.append(this.channel.getType());
      messageBuilder.append("\n---Finish sending notification.---");
      System.out.println(messageBuilder.toString()) ;
  }

} // end of class