package edu.duke.summer.server.database.repository;

import edu.duke.summer.server.database.model.ObjectFieldType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ObjectFieldTypeRepository extends JpaRepository<ObjectFieldType, Long>{

    ObjectFieldType findById(String id);

    List<ObjectFieldType> findAll();

}
