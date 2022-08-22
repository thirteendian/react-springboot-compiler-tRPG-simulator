package edu.duke.summer.server.dto.Function;

import edu.duke.summer.server.dto.Object.ObjectFieldTypeDto;
import org.antlr.v4.runtime.misc.NotNull;

public class ParamInfoDto {

    @NotNull
    private String id;

    // key: primitive, boolean, array, user, option
    @NotNull
    private String k;

    // while name is not null, it would be primitive, boolean, or user
    // either name or elem would be null
    private String name;

    // while elem is not null, it would be either array or option
    private ParamInfoDto elem;

    /**
     * JSON {id:id,
     *       k:k,
     *       name:null,
     *       elem: {
     *           id:id,
     *           k:k,
     *           name:null,
     *           elem:{
     *               id:id,
     *               k:k,
     *               name:name,
     *               elem:null,
     *               value: [Object1, Object2, Object3]
     *           }
     *       }}
     *
     */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParamInfoDto getElem() {
        return elem;
    }

    public void setElem(ParamInfoDto elem) {
        this.elem = elem;
    }

    public ParamInfoDto() {}

    public ParamInfoDto(String id, String k, String name, ParamInfoDto elem) {
        this.id = id;
        this.k = k;
        this.name = name;
        this.elem = elem;
    }

    @Override
    public String toString() {
        return "Param Info {" +
                " id = " + id +
                ", k = " + k +
                ", name = " + name +
                ", elem = " + elem +
                "}";
    }

}

