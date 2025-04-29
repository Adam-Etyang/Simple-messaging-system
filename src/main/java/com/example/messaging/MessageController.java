//definition of endpounts that the user can interat with via HTTP 

package com.example.messaging;

import com.example.messaging.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // annotation
@RequestMapping("/messages") // sets a base path for all the endpoints

public class MessageController {

  @Autowired
  private MessageService messageService;

  // endpoint to send a message
  @PostMapping
  public void sendMessage(@RequestBody Message message) {
    messageService.sendMessage(message);
  }

  // endpoint to get all messages
  @GetMapping
  public List<Message> getAllMessages() {
    return messageService.getAllMessages();
  }

  // endpoint to get messages for a specific receiver
  @GetMapping("/reciver/{receiver}")
  public List<Message> getMessagesForReceiver(@PathVariable String receiver) {
    return messageService.getMessagesForReceiver(receiver);

  }

}
