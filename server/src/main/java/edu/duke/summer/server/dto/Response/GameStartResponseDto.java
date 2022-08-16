package edu.duke.summer.server.dto.Response;

import edu.duke.summer.server.dto.Function.ParamDto;
import edu.duke.summer.server.dto.Object.ObjectDto;

import java.util.ArrayList;
import java.util.List;

public class GameStartResponseDto {

    // objectFieldDto contains all field information of the object type in this game
    public List<ObjectDto> objects;

    // functionInfoDto contains all parameter information of the function in this game
    public List<ParamDto> functions;

    public List<ObjectDto> getObjects() {
        return objects;
    }

    public void setObjects(List<ObjectDto> objects) {
        this.objects = objects;
    }

    public void addObjects(ObjectDto objectDto) {
        objects.add(objectDto);
    }

    public List<ParamDto> getFunctions() {
        return functions;
    }

    public void setFunctions(List<ParamDto> functions) {
        this.functions = functions;
    }

    public void addFunctions(ParamDto paramDto) {
        functions.add(paramDto);
    }

    public GameStartResponseDto() {
        this.objects = new ArrayList<>();
        this.functions = new ArrayList<>();
    };

    public GameStartResponseDto(List<ObjectDto> objects, List<ParamDto> functions) {
        this.objects = objects;
        this.functions = functions;
    }

    @Override
    public String toString() {
        return "GameStartResponseDto{" +
                "objects=" + objects +
                ", functions=" + functions +
                '}';
    }
}
