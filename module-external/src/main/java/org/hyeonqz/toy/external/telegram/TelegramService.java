package org.hyeonqz.toy.external.telegram;

import static java.nio.charset.StandardCharsets.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class TelegramService implements NotificationService {
	private static final String BASE_URL = "https://api.telegram.org/bot";
	private static final String BOTTOM = "/sendMessage?chat_id=";
	private static final String TEXT = "$text=";

	private final RestClient restClient;

	@Value("${telegram.chatId}")
	private String chatId;

	@Value("${telegram.token}")
	private String botToken;

	// kafkaListener 로 처리
	@Override
	public void sendNotification(String message) {
		String url = BASE_URL + botToken + BOTTOM + chatId + TEXT + message;

		int maxRetries = 3;
		for (int i = 1; i <= maxRetries; i++) {
			try {
				restClient.post()
					.uri(url)
					.retrieve()
					.toBodilessEntity();
				return;
			} catch (Exception e) {
				if (i == maxRetries)
					log.error("Telegram Send Message Error : {} \n{}", e.getMessage(), e.getStackTrace());
				try {
					Thread.sleep(2000);
				} catch (InterruptedException ie) {
					Thread.currentThread().interrupt();
				}
			}
		}

	}

}
