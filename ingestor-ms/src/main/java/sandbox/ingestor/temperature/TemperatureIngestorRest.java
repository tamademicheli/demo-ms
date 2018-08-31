package sandbox.ingestor.temperature;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sandbox.repositories.TemperatureMeasure;

import javax.ws.rs.core.Response;

@RestController
public class TemperatureIngestorRest {

    @Autowired
    TemperatureSender sender;
    @Value("${eureka.instance.instance-id}")
    private String instanceid;

    @PostMapping(path = "/tempmeasure")
    @HystrixCommand(fallbackMethod = "fallbackIngestTemperature")
    public Response ingestTemperature(@RequestBody TemperatureMeasure measure) {
        //TODO move to common package with interceptor
        System.err.println("Temp Measure instance: " + instanceid);


        sender.send(measure);

        return Response.status(Response.Status.OK).build();


    }

    public Response fallbackIngestTemperature(@RequestBody TemperatureMeasure measure) {
        System.err.println("service unavailable,......: " + instanceid);
        return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
    }




}
