package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class DemoEchoHandlers extends TelegramLongPollingBot {

    private final String botUserName;
    private final String botToken;

    public DemoEchoHandlers(String botUserName, String botToken) {
        this.botUserName = botUserName;
        this.botToken = botToken;
    }

    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage() == null) {
            return;
        }

        Long chatId = update.getMessage().getChatId();
        String text = update.getMessage().getText();

        try {
            SendMessage textMessage = new SendMessage();
            textMessage.setChatId(String.valueOf(chatId));
            textMessage.setText(text);
            execute(textMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
