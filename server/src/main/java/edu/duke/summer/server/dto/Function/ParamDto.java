package edu.duke.summer.server.dto.Function;

import org.antlr.v4.runtime.misc.NotNull;

import java.util.*;

public class ParamDto {

    @NotNull
    private String id;

    @NotNull
    private String paramName;

    @NotNull
    private ParamInfoDto paramInfoDto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public ParamInfoDto getParamInfoDto() {
        return paramInfoDto;
    }

    public void setParamInfoDto(ParamInfoDto paramInfoDto) {
        this.paramInfoDto = paramInfoDto;
    }

    public ParamDto() {}

    public ParamDto(String id, String paramName, ParamInfoDto paramInfoDto) {
        this.id = id;
        this.paramName = paramName;
        this.paramInfoDto = paramInfoDto;
    }

    @Override
    public String toString() {
        return "ParamDto{" +
                "id='" + id + '\'' +
                ", paramName='" + paramName + '\'' +
                ", paramInfoDto=" + paramInfoDto +
                '}';
    }
}

