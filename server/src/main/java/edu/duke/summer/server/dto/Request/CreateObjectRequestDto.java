package edu.duke.summer.server.dto.Request;

import edu.duke.summer.server.dto.Object.FieldValueDto;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.*;

public class CreateObjectRequestDto {

    @NotNull
    private String gameId;

    @NotNull
    private String playerUuid;

    @NotNull
    // JSON object
    private String value;
}

