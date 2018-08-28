package sandbox.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * see https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/
 */
public interface TemperatureMeasureRepository extends ElasticsearchCrudRepository<TemperatureMeasure, String> {


    List<TemperatureMeasure> findByDeviceId(String deviceId);



}
