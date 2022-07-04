package edu.duke.summer.client.service;

import org.springframework.stereotype.Service;

@Service
public class SeqNumService {

    /**
     * This is the sequence number
     */
    private static int seqNum = 0;

    /**
     * This constructs a sequence number factory, in which
     * the sequence number starts from 1
     */
    public SeqNumService() {}

    /**
     * This returns the current sequence number, and then
     * increase the sequence number by 1
     */
    public synchronized int createSeqNum() {
        return seqNum++;
    }

}
