package sandbox.worker.temperature;

import org.apache.logging.log4j.Logger;
import org.elasticsearch.common.logging.Loggers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import sandbox.repositories.TemperatureMeasure;
import sandbox.repositories.TemperatureMeasureRepository;

@Component
public class TemperatureReceiver {

    protected final Logger logger = Loggers.getLogger(TemperatureReceiver.class);


    @Autowired
    TemperatureMeasureRepository temperatureMeasureRepository;


    @JmsListener(destination = "${temperature.topic}", concurrency = "${temperature.concurrency}")
    public void receive(TemperatureMeasure temperatureMeasure) {
        logger.info("Received Temperature: "+ temperatureMeasure);
        temperatureMeasureRepository.save(temperatureMeasure);
    }
}
