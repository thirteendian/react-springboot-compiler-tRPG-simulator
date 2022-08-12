package edu.duke.summer.server.dto.Object;

import javax.validation.constraints.NotNull;

public class ObjectFieldDto {

    @NotNull
    private String id;

    @NotNull
    private String FieldName;

    @NotNull
    private ObjectFieldTypeDto objectFieldTypeDto;
}
