package edu.duke.summer.server.service;

import edu.duke.summer.server.stomp.TestMessageSent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public interface WebsocketService {
    void sendTopicMessage(String messageReceived);
    void sendChatMessage(TestMessageSent testMessageSent);
    void sendServerJVMInfo();
    void sendGameResponse(UserDetails userDetails);
}
