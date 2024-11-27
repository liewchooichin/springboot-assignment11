package com.myapp.assignment11;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/*
    TODO:
    The channel of notification can be SMS or Email. 
    Set this class up as a @Bean by creating a configuration class with @Configuration annotation. Set the type to "SMS".
*/

@Configuration
public class Channel {
  String type;

  // getter and setters
  public String getType() {
      return this.type;
  }

  public void setType(String type) {
      this.type = type;
  }
  // toString
  @Override
  public String toString(){
    return String.format("Channel: " + type + "\n");
  }

  /* 
   * Setup two types SMS and Email beans. 
   */

  // SMS
  @Bean(name="SMSNotificationService")
  public NotificationService SMSNotificationService(Channel channel, Message messageSetup){
    // create an instance of NotificationService
    NotificationService newNotificationService = 
      new NotificationService(channel, messageSetup);
    // Set Channel type to SMS
    channel.setType("SMS");
    return newNotificationService;
  }
    
  
  // Email
  /***
  @Bean(name="EmailNotificationService")
  public NotificationService EmailNotificationService(Channel channel, Message messageSetup){
    // create an instance of NotificationService
    NotificationService newNotificationService = 
      new NotificationService(channel, messageSetup);
    // Set Channel type to Email
    channel.setType("Email");
    return newNotificationService;
  }
  ***/
  

}