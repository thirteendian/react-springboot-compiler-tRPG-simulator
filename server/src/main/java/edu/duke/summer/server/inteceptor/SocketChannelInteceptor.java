package edu.duke.summer.server.inteceptor;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;

public class SocketChannelInteceptor implements ChannelInterceptor {


    /**
     * used before message actually be sent to the channel
     */
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        return ChannelInterceptor.super.preSend(message, channel);
    }

    private void connect(String sessionID) {
        System.out.println("        .connect()---[SessionID:]" + sessionID);
    }

    /**
     * call this method after .send is called
     */
    @Override
    public void postSend(Message<?> message, MessageChannel channel, boolean sent) {

        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(message);
        if (headerAccessor.getCommand() == null) return;// avoid no stomp message(heartbeat etc.)
    }

    /**
     * used for clean Resources after sent
     */
    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
        ChannelInterceptor.super.afterSendCompletion(message, channel, sent, ex);
    }
}
