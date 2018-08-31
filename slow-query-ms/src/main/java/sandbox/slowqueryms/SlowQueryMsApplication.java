package sandbox.slowqueryms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import sandbox.repositories.MeasureConfig;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "sandbox/repositories")
@Import(MeasureConfig.class)
public class SlowQueryMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlowQueryMsApplication.class, args);
	}
}
