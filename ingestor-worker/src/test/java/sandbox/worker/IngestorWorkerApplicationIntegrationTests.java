package sandbox.worker;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore("Use only for local development tests or implement an embedded elastic search")
public class IngestorWorkerApplicationIntegrationTests {


    @Test
    public void contextLoads() {
    }

}
