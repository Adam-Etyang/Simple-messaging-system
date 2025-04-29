package com.example.messaging;

import com.example.messaging.model.Message;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
  // list to simulate a database for now
  private List<Message> messagedatabase = new ArrayList<>();

  public void sendMessage(Message message) {
    messagedatabase.add(message);
    System.out.println("message sent from: " + message.getSender() + "to: " + message.getReceiver());
  }

  // get messages
  public List<Message> getAllMessages() {
    return messagedatabase;
  }

  // get messages for a specfic getReceiver
  public List<Message> getMessagesForReceiver(String receiver) {
    List<Message> MessagesForReceiver = new ArrayList<>();
    for (Message message : messagedatabase) {
      if (message.getReceiver().equals(receiver)) {
        MessagesForReceiver.add(message);
      }
    }
    return MessagesForReceiver;
  }
}
