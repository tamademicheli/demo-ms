package sandbox.fastqueryms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sandbox.repositories.TemperatureMeasure;
import sandbox.repositories.TemperatureMeasureRepository;

import javax.ws.rs.core.Response;
import java.util.Optional;

@RestController
public class FastQueryRest {


    @Autowired
    TemperatureMeasureRepository temperatureMeasureRepository;


    @GetMapping(path = "/temperature/{id}")
    @ResponseBody
    public Response getTemperatureById(@PathVariable String id) {
        Optional<TemperatureMeasure> byId = temperatureMeasureRepository.findById(id);
        TemperatureMeasure temperatureMeasure = byId.orElse(new TemperatureMeasure());
        return Response.status(Response.Status.OK).entity(temperatureMeasure).build();
    }
}
