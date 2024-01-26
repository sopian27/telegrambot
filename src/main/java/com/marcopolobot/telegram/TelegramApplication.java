package com.marcopolobot.telegram;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
@Slf4j
public class TelegramApplication {

	public static void main(String[] args) {
		log.info("START");
		SpringApplication.run(TelegramApplication.class, args);
		runBot();
	}


	public static void runBot(){

		TelegramBot telegramBot = new TelegramBot();
		try {
			TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
			botsApi.registerBot(telegramBot);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

}
