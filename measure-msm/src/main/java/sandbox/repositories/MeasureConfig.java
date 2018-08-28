package sandbox.repositories;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;


@Configuration
public class MeasureConfig {


    @Value("${elasticsearch.host}")
    String eshost;

    @Value("${elasticsearch.port}")
    int esport;

    @Value("${elasticsearch.home}")
    String elasticsearchHome;

    @Value("${elasticsearch.clustername}")
    String clusterName;


    @Bean
    public Client client() throws UnknownHostException {
        Settings elasticsearchSettings = Settings.builder()
                .put("client.transport.sniff", true)
                .put("path.home", elasticsearchHome)
                .put("cluster.name", clusterName).build();

        try (TransportClient client = new PreBuiltTransportClient(elasticsearchSettings)) {
            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(eshost), esport));
            return client;
        }

    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws UnknownHostException {
        return new ElasticsearchTemplate(client());
    }


}


