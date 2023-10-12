package ru.zulvit.teamentropy.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.zulvit.teamentropy.DTO.MessageDTO;
import ru.zulvit.teamentropy.entity.Message;

@Component
public class MessageMapper {
    private final org.modelmapper.ModelMapper messageMap;

    @Autowired
    public MessageMapper(org.modelmapper.ModelMapper messageMap) {
        this.messageMap = messageMap;
    }

    public MessageDTO toDTO(Message input) {
        return messageMap.map(input, MessageDTO.class);
    }

    public Message toEntity(MessageDTO input) {
        return messageMap.map(input, Message.class);
    }
}