package com.marcopolobot.telegram;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
public class TelegramBot extends TelegramLongPollingBot {


    @Override
    public String getBotUsername() {
        return Constant.TELEGRAM_USERNAME;
    }

    @Override
    public String getBotToken() {
        return Constant.TELEGRAM_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        log.info("UPDATE RECEIVED");
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();
            // Process the message and generate a response
            String response = processMessage(messageText);
            // Send the response back to the user
            try {
                execute(new SendMessage(chatId.toString(), response));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private String processMessage(String messageText) {
        log.info("{} processMessage : "+messageText);
        String response="";
        if(messageText.equals("/start")){
            response = "you pushed start";
        }else if(messageText.equals("/paused")){
            response = "you pushed paused";
        }
        return response;
    }


}
