package edu.duke.summer.client.stomp;

import edu.duke.summer.client.database.model.MagicCheck;

import java.util.List;

/**
 * An Output JSON carry the dicerolling result
 */
public class RespDiceRollingResult {
    private String content;// dice rolling result
    private List<MagicCheck> magicCheckList; //saved rolls

    public RespDiceRollingResult() {
    }

    public RespDiceRollingResult(String input, String result, List<MagicCheck> magicCheckList) {
        this.content = "Your result of "+ input +" is " + result;
        this.magicCheckList = magicCheckList;
    }

    public List<MagicCheck> getMagicCheckList() {
        return magicCheckList;
    }


    public String getContent() {
        return content;
    }

}
