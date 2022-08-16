package edu.duke.summer.server.dto.Function;

import edu.duke.summer.server.dto.Object.ObjectFieldDto;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.*;

public class FunctionDto {

    @NotNull
    private String id;

    @NotNull
    private String functionName;

    @NotNull
    private List<ParamDto> params;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public List<ParamDto> getParams() {
        return params;
    }

    public void setParams(List<ParamDto> params) {
        this.params = params;
    }

    public void addParams(ParamDto paramDto) {
        params.add(paramDto);
    }

    public FunctionDto() {
        this.params = new ArrayList<>();
    }

    public FunctionDto(String id, String functionName, List<ParamDto> params) {
        this.id = id;
        this.functionName = functionName;
        this.params = params;
    }

    @Override
    public String toString() {
        return "FunctionDto{" +
                "id='" + id + '\'' +
                ", functionName='" + functionName + '\'' +
                ", params=" + params +
                '}';
    }
}
