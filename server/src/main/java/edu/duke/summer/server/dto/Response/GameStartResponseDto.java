package edu.duke.summer.server.dto.Response;

import edu.duke.summer.server.dto.Function.FunctionInfoDto;
import edu.duke.summer.server.dto.Object.ObjectDto;

import java.util.List;

public class GameStartResponseDto {

    // objectFieldDto contains all field information of the object type in this game
    public List<ObjectDto> objects;

    // functionInfoDto contains all parameter information of the function in this game
    public List<FunctionInfoDto> functions;

}
