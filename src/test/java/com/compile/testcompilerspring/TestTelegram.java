package com.compile.testcompilerspring;

import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class TestTelegram {
    @Test
    void testBot(){
        run();
    }

    private void run() {
        try {
            MyClassicBot myClassicBot = new MyClassicBot();
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(myClassicBot);

            while (true){
                Thread.sleep(5000);
            }

        } catch (TelegramApiException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class MyClassicBot extends TelegramLongPollingBot {

        @Override
        public String getBotUsername() {
            return "פûגפûגפûגפûג";
        }

        @Override
        public String getBotToken() {
            return "גפûûûûûûûûûû";
        }

        @Override
        public void onUpdateReceived(Update update) {
            if (update.hasMessage() && update.getMessage().hasText()) {
                SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
                message.setChatId(update.getMessage().getChatId().toString());
                message.setText("This is chat id = " + update.getMessage().getChatId().toString());

                try {
                    execute(message); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
