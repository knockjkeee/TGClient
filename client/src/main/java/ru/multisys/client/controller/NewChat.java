package ru.multisys.client.controller;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.multisys.client.TdlibRunner;
import ru.multisys.client.domain.RequestNewChat;
import ru.multisys.client.domain.ResponseChat;
//import ru.nisteam.customtelegram.TdlibRunner;
//import ru.nisteam.customtelegram.domain.RequestNewChat;
//import ru.nisteam.customtelegram.domain.ResponseChat;

@Log4j2
@RestController
@RequestMapping("/api")
public class NewChat {

    private final TdlibRunner tdlibRunner;

    public NewChat(TdlibRunner tdlibRunner) {
        this.tdlibRunner = tdlibRunner;
    }

    @SneakyThrows
    @PostMapping("/newchat")
    public ResponseEntity<ResponseChat> createNewChat(@RequestBody RequestNewChat requestNewChat) {
        log.warn("[createNewChat] start method " );
        ResponseChat responseChat = tdlibRunner.httpSendMeToCommandLiner(requestNewChat);
        tdlibRunner.clearObj();
        log.warn("[createNewChat] get responseChat " );
        if( responseChat.getError() != null && responseChat.getGroupId() == 0 ){
            log.error("[NOT CREATE CHAT] responseChat: " + responseChat);
            return new ResponseEntity<>(responseChat, HttpStatus.BAD_REQUEST);
        }else{
            log.info("[CREATE CHAT] responseChat: " + responseChat);
            return new ResponseEntity<>(responseChat, HttpStatus.OK);
        }
    }

    @GetMapping("/test")
    public ResponseEntity<String> test (){
        return new ResponseEntity<>("GOOD DAY", HttpStatus.OK);
    }
}
