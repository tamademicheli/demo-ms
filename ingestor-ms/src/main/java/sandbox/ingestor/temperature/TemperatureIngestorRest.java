package sandbox.ingestor.temperature;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sandbox.repositories.TemperatureMeasure;

import javax.ws.rs.core.Response;

@RestController
public class TemperatureIngestorRest {

    @Value("${eureka.instance.instance-id}")
    private String instanceid;

    @Autowired
    TemperatureSender sender;

    @PostMapping(path = "/tempmeasure")
    public Response ingestTemperature(@RequestBody TemperatureMeasure measure) {
        //TODO move to common package with interceptor
        System.err.println("Temp Measure instance: "+instanceid);


        sender.send(measure);

        return Response.status(Response.Status.OK).build();


    }


}
