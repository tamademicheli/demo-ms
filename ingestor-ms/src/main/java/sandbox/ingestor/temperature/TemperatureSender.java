package sandbox.ingestor.temperature;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import sandbox.repositories.TemperatureMeasure;

@Component
public class TemperatureSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemperatureSender.class);

    @Value("${temperature.topic}")
    String temperatureTopic;


    @Autowired
    JmsTemplate template;


    // TODO Enhance Callback
    public void send(TemperatureMeasure temperatureMeasure) {
        LOGGER.info("sending temperatureMeasure='{}' to topic='{}'", temperatureMeasure, temperatureTopic);
        template.convertAndSend(temperatureTopic, temperatureMeasure);
    }

}
