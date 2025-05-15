package org.hyeonqz.toy.external.telegram;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MessageType {

    ALARM_NORMAL("[ALARM]"),
    EVENT("[EVENT]"),
    ;

    private final String text;
}
