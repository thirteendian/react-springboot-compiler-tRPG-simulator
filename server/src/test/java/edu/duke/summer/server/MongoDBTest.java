package edu.duke.summer.server;

import edu.duke.summer.server.database.model.FunctionInfo;
import edu.duke.summer.server.database.repository.FunctionInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MongoDBTest {
    @Autowired
    private FunctionInfoRepository functionInfoRepository;

    @Test
    public void test_mongo() {
        HashMap<Integer, String> testMap = new HashMap<>();
        testMap.put(2, "test");
        FunctionInfo functionInfo = new FunctionInfo("game1", testMap);
        functionInfoRepository.save(functionInfo);
        assertEquals("test", functionInfoRepository.findByGameId("game1").getTest().get(2));

    }
}
