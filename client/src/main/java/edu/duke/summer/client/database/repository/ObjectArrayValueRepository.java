package edu.duke.summer.client.database.repository;

import edu.duke.summer.client.database.model.ObjectArrayValue;
import edu.duke.summer.client.database.model.ObjectField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.*;

@Repository
public interface ObjectArrayValueRepository extends JpaRepository<ObjectArrayValue, Long> {

}
