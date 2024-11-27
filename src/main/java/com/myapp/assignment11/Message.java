package com.myapp.assignment11;

import org.springframework.stereotype.Component;

/*
    TODO:
    Annotate this message as @Component
*/

@Component
public class Message {
    
  String to;
  String message;

  // getters and setters
  public String getTo() {
      return this.to;
  }

  public void setTo(String to) {
      this.to = to;
  }

  public String getMessage() {
      return this.message;
  }

  public void setMessage(String message) {
      this.message = message;
  }

  // toString
  @Override
  public String toString(){
    return String.format("Message to " + to + ", message length: " + message.length());
  }
  
}