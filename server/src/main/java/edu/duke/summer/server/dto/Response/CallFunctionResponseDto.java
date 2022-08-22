package edu.duke.summer.server.dto.Response;

import edu.duke.summer.server.algorithm.UserOptionInfo;
import edu.duke.summer.server.dto.FunctionOneOptionDto;
import edu.duke.summer.server.dto.FunctionOneRollDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CallFunctionResponseDto {

    List<FunctionOneRollDto> rolls;

    //all existing userOptions
    List<FunctionOneOptionDto> userOptions;

    //Msgs that need to be shown for the users
    List<String> outputMsgs;

    public List<FunctionOneRollDto> getRolls() {
        return rolls;
    }

    public void setRolls(List<FunctionOneRollDto> rolls) {
        this.rolls = rolls;
    }

    public List<FunctionOneOptionDto> getUserOptions() {
        return userOptions;
    }

    public void setUserOptions(List<FunctionOneOptionDto> userOptions) {
        this.userOptions = userOptions;
    }

    public List<String> getOutputMsgs() {
        return outputMsgs;
    }

    public void setOutputMsgs(List<String> outputMsgs) {
        this.outputMsgs = outputMsgs;
    }

    public CallFunctionResponseDto() {}

    public CallFunctionResponseDto(List<FunctionOneRollDto> rolls, List<FunctionOneOptionDto> userOptions, List<String> outputMsgs) {
        this.rolls = rolls;
        this.userOptions = userOptions;
        this.outputMsgs = outputMsgs;
    }
}
