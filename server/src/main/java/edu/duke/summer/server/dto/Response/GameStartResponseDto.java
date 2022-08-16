package edu.duke.summer.server.dto.Response;

import edu.duke.summer.server.dto.Object.ObjectDto;
import edu.duke.summer.server.dto.Function.FunctionDto;

import java.util.ArrayList;
import java.util.List;

public class GameStartResponseDto {

    // objectFieldDto contains all field information of the object type in this game
    public List<ObjectDto> objects;

    // functionInfoDto contains all parameter information of the function in this game
    public List<FunctionDto> functions;

    public List<ObjectDto> getObjects() {
        return objects;
    }

    public void setObjects(List<ObjectDto> objects) {
        this.objects = objects;
    }

    public void addObjects(ObjectDto objectDto) {
        objects.add(objectDto);
    }

    public List<FunctionDto> getFunctions() {
        return functions;
    }

    public void setFunctions(List<FunctionDto> functions) {
        this.functions = functions;
    }

    public void addFunctions(FunctionDto functionDto) {
        functions.add(functionDto);
    }

    public GameStartResponseDto() {
        this.objects = new ArrayList<>();
        this.functions = new ArrayList<>();
    };

    public GameStartResponseDto(List<ObjectDto> objects, List<FunctionDto> functions) {
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
