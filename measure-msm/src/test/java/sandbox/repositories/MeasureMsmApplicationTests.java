package sandbox.repositories;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Optional;


@Ignore("Use only for local development tests or implement an embedded elastic search")
@RunWith(SpringRunner.class)
@SpringBootTest
public class MeasureMsmApplicationTests {

    @Autowired
    TemperatureMeasureRepository temperatureMeasureRepository;


    @Before
    public void setUp() throws Exception {

    }

    private TemperatureMeasure getTemperatureMeasure() {
        TemperatureMeasure temperatureMeasure = new TemperatureMeasure();
        temperatureMeasure.setDeviceId("test");
        temperatureMeasure.setMeasureTime(LocalDateTime.now());
        temperatureMeasure.setLocation(1.1234, 2.2345);
        temperatureMeasure.setCelsius(23.12);
        return temperatureMeasure;
    }

    @Test
    public void testSaveSuccessful() {
        TemperatureMeasure temperatureMeasure = getTemperatureMeasure();
        temperatureMeasureRepository.save(temperatureMeasure);

        Optional<TemperatureMeasure> measure = temperatureMeasureRepository.findById(temperatureMeasure.getId());

        Assert.assertTrue(measure.isPresent());


    }


}
