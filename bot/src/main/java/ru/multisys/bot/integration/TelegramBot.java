package ru.multisys.bot.integration;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@Slf4j
public class TelegramBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "null";
    }

    @Override
    public String getBotToken() {
        return System.getenv("testBotApi");
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {

        log.info("Bot run update msg");
        //todo add process
//        ArrayList<ChatMember> execute = this.execute(GetChatAdministrators.builder()
//                .chatId(String.valueOf(update.getMessage().getChatId()))
//                .build());
////        GetChatAdministrators.builder().chatId(String.valueOf(update.getMessage().getChatId()))
//        System.out.println(execute.get(0).getUser().getId());
    }
}
