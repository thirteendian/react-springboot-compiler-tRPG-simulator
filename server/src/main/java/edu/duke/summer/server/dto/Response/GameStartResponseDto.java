package edu.duke.summer.server.dto.Response;

import edu.duke.summer.server.dto.Function.FunctionInfoDto;
import edu.duke.summer.server.dto.Object.ObjectDto;

import java.util.ArrayList;
import java.util.List;

public class GameStartResponseDto {

    // objectFieldDto contains all field information of the object type in this game
    public List<ObjectDto> objects;

    // functionInfoDto contains all parameter information of the function in this game
    public List<FunctionInfoDto> functions;

    public List<ObjectDto> getObjects() {
        return objects;
    }

    public void setObjects(List<ObjectDto> objects) {
        this.objects = objects;
    }

    public void addObjects(ObjectDto objectDto) {
        objects.add(objectDto);
    }

    public List<FunctionInfoDto> getFunctions() {
        return functions;
    }

    public void setFunctions(List<FunctionInfoDto> functions) {
        this.functions = functions;
    }

    public void addFunctions(FunctionInfoDto functionInfoDto) {
        functions.add(functionInfoDto);
    }

    public GameStartResponseDto() {
        this.objects = new ArrayList<>();
        this.functions = new ArrayList<>();
    };

    public GameStartResponseDto(List<ObjectDto> objects, List<FunctionInfoDto> functions) {
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
