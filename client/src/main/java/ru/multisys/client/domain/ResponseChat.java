package ru.multisys.client.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ResponseChat {
    String link;
    long groupId;
    String error;
}
