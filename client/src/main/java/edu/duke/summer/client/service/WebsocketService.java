package edu.duke.summer.client.service;

import edu.duke.summer.client.stomp.TestMessageSent;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public interface WebsocketService {
    void sendTopicMessage(String messageReceived);
    void sendChatMessage(TestMessageSent testMessageSent);
    void sendServerJVMInfo();
}
