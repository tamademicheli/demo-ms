package sandbox.worker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import sandbox.repositories.MeasureConfig;

@SpringBootApplication
// TODO Centralize
@EnableElasticsearchRepositories(basePackages = "sandbox/repositories")
@Import(MeasureConfig.class)
public class IngestorWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IngestorWorkerApplication.class, args);
	}
}
