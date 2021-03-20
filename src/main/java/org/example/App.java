package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        // https://core.telegram.org/bots#3-how-do-i-create-a-bot
        String botUserName = "DemoEchoBot";
        String botToken = "1638665295:AAHzIhSKtxXKJPrSHLL6HZ8AIaECW2fLLEU";

        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new DemoEchoHandlers(botUserName, botToken));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
