package edu.duke.summer.server.service.impl;

import edu.duke.summer.server.service.WebsocketService;
import edu.duke.summer.server.stomp.SingleMessage;
import edu.duke.summer.server.stomp.TestMessageReceive;
import edu.duke.summer.server.stomp.TestMessageSent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebsocketServiceImpl implements WebsocketService {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;


    @Override
    public void sendTopicMessage(String messageReceived) {
        simpMessagingTemplate.convertAndSend("/test/testmessageReceive", "Server Received: "
                + messageReceived + "\n Server Send: This is Server Send Message!");
    }

    @Override
    public void sendChatMessage(TestMessageSent testMessageSent) {
        TestMessageReceive testMessageReceive = new TestMessageReceive();
        testMessageReceive.setTest(testMessageSent.getContent());
        testMessageReceive.setUuid(testMessageSent.getFrom());
        simpMessagingTemplate.convertAndSend("/test/testmessageReceive/" + testMessageSent.getTo(),
                testMessageReceive);
    }

    @Override
    public void sendServerJVMInfo() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        Long freeMemory = Runtime.getRuntime().freeMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();
        String JVMInfo = String.format("\nServer avaliable Processors:%s;\n Free Memory: %s;\n Already Used Memory: %s\n",availableProcessors,freeMemory,maxMemory);
        simpMessagingTemplate.convertAndSend("/admin/jvminfo",new SingleMessage(JVMInfo));
    }
}
