package sandbox.loadbalancer;


import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FallBackConfiguration {

    @Bean
    public FallbackProvider genericFallbackProvider(){
        return new LoadBalancerFallbackProvider();
    }

    public class LoadBalancerFallbackProvider implements FallbackProvider{
        @Override
        public String getRoute() {
            return "measure-slow-query-ms";
        }

        @Override
        public ClientHttpResponse fallbackResponse(String route, final Throwable cause) {
            if (cause instanceof HystrixTimeoutException) {
                return response(HttpStatus.GATEWAY_TIMEOUT, route);
            } else {
                return response(HttpStatus.INTERNAL_SERVER_ERROR, route);
            }
        }

        private ClientHttpResponse response(final HttpStatus status, String route) {
            return new ClientHttpResponse() {
                @Override
                public HttpStatus getStatusCode() throws IOException {
                    return status;
                }

                @Override
                public int getRawStatusCode() throws IOException {
                    return status.value();
                }

                @Override
                public String getStatusText() throws IOException {
                    return status.getReasonPhrase();
                }

                @Override
                public void close() {
                }

                @Override
                public InputStream getBody() throws IOException {
                    return new ByteArrayInputStream(("service instance not available for route: "+route).getBytes());
                }

                @Override
                public HttpHeaders getHeaders() {
                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.APPLICATION_JSON);
                    return headers;
                }
            };
        }
    }
}
