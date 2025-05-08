package org.hyeonqz.toy.external.telegram.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

	@Bean
	public RestClient restClient() {
		return RestClient.builder()
			.requestFactory(clientHttpRequestFactory())
			.build();
	}

	private ClientHttpRequestFactory clientHttpRequestFactory() {
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		factory.setConnectTimeout(5000); // 연결 타임아웃 5초
		factory.setReadTimeout(5000); // 읽기 타임아웃 5초
		return factory;
	}
}
