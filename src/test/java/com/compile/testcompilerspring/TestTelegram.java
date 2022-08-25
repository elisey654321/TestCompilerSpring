package com.compile.testcompilerspring;

import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ForceReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.ArrayList;
import java.util.List;

public class TestTelegram {
    @Test
    void testBot() {
        run();
    }

    private void run() {
        try {
            MyClassicBot myClassicBot = new MyClassicBot();
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(myClassicBot);

            while (true) {
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
            return "testedJava_bot";
        }

        @Override
        public String getBotToken() {
            return "5634796223:AAHG5cUYHSohNCP3ySOGdnULzicMQJWZ-nY";
        }

        @Override
        public void onUpdateReceived(Update update) {
            TelegramBotUtils utilsTelergamBot = new TelegramBotUtils(update);

            SendMessage message = new SendMessage();
            message.setChatId("552286993");
            message.setText(utilsTelergamBot.getAnswer());
            message.setReplyMarkup(utilsTelergamBot.getInlineKeyboardMarkup());

            if (update.hasMessage() && update.getMessage().hasText()) {
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }if (update.hasCallbackQuery()){
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
