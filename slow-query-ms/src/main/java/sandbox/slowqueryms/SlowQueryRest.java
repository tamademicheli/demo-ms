package sandbox.slowqueryms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sandbox.repositories.TemperatureMeasure;
import sandbox.repositories.TemperatureMeasureRepository;

import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@RestController
public class SlowQueryRest {


    @Autowired
    TemperatureMeasureRepository temperatureMeasureRepository;


    @GetMapping(path = "/temperature/{deviceId}")
    @ResponseBody
    public Response ingestTemperature(@PathVariable String deviceId) {
        List<TemperatureMeasure> byDeviceId = temperatureMeasureRepository.findByDeviceId(deviceId);
        return Response.status(Response.Status.OK).entity(byDeviceId).build();
    }
}
