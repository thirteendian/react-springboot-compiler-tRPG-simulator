package edu.duke.summer.server.database.repository;

import edu.duke.summer.server.database.model.ParamInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ParamInfoRepository extends JpaRepository<ParamInfo, Long> {
    ParamInfo findById(String id);

}

