package edu.duke.summer.client.stomp;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;

public class SocketChannelIntecepter implements ChannelInterceptor {

    /**
     * used before message actually be sent to the channel
     */
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        return ChannelInterceptor.super.preSend(message, channel);
    }

    private void connect(String sessionID){
        System.out.println("SocketChannelIntecepter.postSend()->disconnect [SessionID:]"+sessionID);
    }
    /**
     * call this method after .send is called
     */
    @Override
    public void postSend(Message<?> message, MessageChannel channel, boolean sent) {

        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(message);
        if(headerAccessor.getCommand() == null) return ;// avoid no stomp message(heartbeat etc.)
        String sessionID = headerAccessor.getSessionAttributes().get("sessionID").toString();
        System.out.println("SocketChannelIntecepter.postSend(); [sessionID]: "+ sessionID);
        switch (headerAccessor.getCommand()){
            case CONNECT:
                break;
            case DISCONNECT:
                break;
        }
    }

    /**
     * used for clean Resources after sent
     */
    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
        ChannelInterceptor.super.afterSendCompletion(message, channel, sent, ex);
    }
}
