package edu.duke.summer.server.dto.Response;

import edu.duke.summer.server.dto.FunctionOneOptionDto;
import edu.duke.summer.server.dto.FunctionOneRollDto;

import java.util.List;

public class ReCallFunctionResponseDto {

    List<FunctionOneRollDto> rolls;

    //all existing userOptions
    List<FunctionOneOptionDto> userOptions;

    //Msgs that need to be shown for the users
    List<String> outputMsgs;

}
