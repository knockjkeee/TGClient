package ru.multisys.client.domain;

import lombok.Data;
import org.drinkless.tdlib.TdApi;

@Data
public class ResponseTdApiCreate {
    TdApi.Chat chat;
    TdApi.Error error;

    public void clear(){
        chat = null;
        error = null;
    }
}
