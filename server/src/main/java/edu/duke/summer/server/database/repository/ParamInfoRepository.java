package edu.duke.summer.server.database.repository;

import edu.duke.summer.server.database.model.FunctionInfo;
import edu.duke.summer.server.database.model.ObjectField;
import edu.duke.summer.server.database.model.ObjectFieldType;
import edu.duke.summer.server.database.model.ParamInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.*;

@Repository
public interface ParamInfoRepository extends JpaRepository<ParamInfo, Long> {
    ParamInfo findById(String id);

    List<ParamInfo> findAll();
}

