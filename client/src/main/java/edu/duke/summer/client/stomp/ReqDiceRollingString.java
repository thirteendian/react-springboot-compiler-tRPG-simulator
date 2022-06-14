package edu.duke.summer.client.stomp;

/**
 * An INPUT JSON message to carry DiceRolling user input string and Magic check information
 * {
 *     "diceString":"d20+5"
 *     "magicCheck":true
 * }
 */
public class ReqDiceRollingString {

    private String rawString;
    private Boolean magicCheck;

    public ReqDiceRollingString() {
    }

    public ReqDiceRollingString(String rawString, Boolean magicCheck) {
        this.rawString = rawString;
        this.magicCheck = magicCheck;
    }

    public String getRawString() {
        return rawString;
    }

    public void setRawString(String rawString) {
        this.rawString = rawString;
    }

    public Boolean getMagicCheck() {
        return magicCheck;
    }

    public void setMagicCheck(Boolean magicCheck) {
        this.magicCheck = magicCheck;
    }
}
