package sandbox.worker;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import sandbox.ingestor.IngestorApplication;
import sandbox.repositories.TemperatureMeasure;
import sandbox.ingestor.temperature.TemperatureSender;

import java.time.LocalDateTime;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = IngestorApplication.class)
@ActiveProfiles(profiles = "integration")
public class IngestorApplicationIntegrationTests {

    @Autowired
    TemperatureSender sender;


    @Test
    public void testSend() {
        TemperatureMeasure temperatureMeasure = getTemperatureMeasure();
        sender.send(temperatureMeasure);

    }

    private TemperatureMeasure getTemperatureMeasure() {
        Assert.assertNotNull(sender);
        TemperatureMeasure temperatureMeasure = new TemperatureMeasure();
        temperatureMeasure.setDeviceId("bosch-heinrichstrasse-x123");
        temperatureMeasure.setMeasureTime(LocalDateTime.now());
        temperatureMeasure.setLocation( new Random().nextDouble(), new Random().nextDouble());
        temperatureMeasure.setCelsius(new Random().nextDouble());
        return temperatureMeasure;
    }

}
