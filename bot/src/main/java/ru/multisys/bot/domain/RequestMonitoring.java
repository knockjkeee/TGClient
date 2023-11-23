package ru.multisys.bot.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RequestMonitoring {
    String msgCommon;
    String msgPrivate;
    String nameGroup;
    long[] numbers;
}
