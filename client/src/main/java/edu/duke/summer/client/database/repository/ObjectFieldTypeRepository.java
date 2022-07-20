package edu.duke.summer.client.database.repository;

import edu.duke.summer.client.database.model.ObjectField;
import edu.duke.summer.client.database.model.ObjectFieldType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.*;

@Repository
public interface ObjectFieldTypeRepository extends JpaRepository<ObjectFieldType, Long>{

    ObjectFieldType findById(String id);

    List<ObjectFieldType> findAll();

}
