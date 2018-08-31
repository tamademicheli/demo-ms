package sandbox.fastqueryms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import sandbox.repositories.MeasureConfig;

@SpringBootApplication
@EnableEurekaClient
@EnableElasticsearchRepositories(basePackages = "sandbox/repositories")
@Import(MeasureConfig.class)
public class FastQueryMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastQueryMsApplication.class, args);
	}
}
