package com.compile.testcompilerspring;

import lombok.Getter;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class TelegramBotUtils {

    @Getter
    private String answer = "";
    @Getter
    private InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

    public TelegramBotUtils(Update update) {
        if (update.hasCallbackQuery()) {
            String text = update.getCallbackQuery().getMessage().getText();
            text = update.getCallbackQuery().getData();
            answer = text;
            fillInlineKeyboardMarkup(text);
        }else {
            String text = update.getMessage().getText();
            answer = text;
            fillInlineKeyboardMarkup(text);
        }

    }

    private void fillInlineKeyboardMarkup(String text) {
        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(new InlineKeyboardButtonSpeed("Получить последние ошибки","getErrorsAPI"));
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        keyboardButtonsRow2.add(new InlineKeyboardButtonSpeed("Дата последнего бэкапа","getDataLastBackupAPI"));
        List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();
        keyboardButtonsRow3.add(new InlineKeyboardButtonSpeed("Проверить работу обмена","checkExchangeAPI"));
        List<InlineKeyboardButton> keyboardButtonsRow4 = new ArrayList<>();
        keyboardButtonsRow4.add(new InlineKeyboardButtonSpeed("Получить элемент по GUID","getElementByGuidAPI"));

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        rowList.add(keyboardButtonsRow3);
        rowList.add(keyboardButtonsRow4);
        inlineKeyboardMarkup.setKeyboard(rowList);
    }

    private class InlineKeyboardButtonSpeed extends InlineKeyboardButton{
        private String textButton;
        private String textCommand;

        public InlineKeyboardButtonSpeed(String textButton, String textCommand) {
            this.textButton = textButton;
            this.textCommand = textCommand;
            this.setText(this.textButton);
            this.setCallbackData(this.textCommand);
        }

    }

}
