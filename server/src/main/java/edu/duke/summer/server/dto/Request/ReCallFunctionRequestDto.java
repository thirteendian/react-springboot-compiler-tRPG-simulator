package edu.duke.summer.server.dto.Request;

import java.util.HashMap;
import java.util.List;

public class ReCallFunctionRequestDto {

    private String gameId;

    private String functionId;

    private String userId;

    // <paramId, JSON string> : param id -> json object of param value
    // should the same as the params of call function within one process
    private HashMap<String, String> params;

    // re-roll ids
    private List<String> reRollDiceIds;

    // true userOption ids
    private List<String> trueUserOptionIds;
}
