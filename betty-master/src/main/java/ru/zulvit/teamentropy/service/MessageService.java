package ru.zulvit.teamentropy.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import ru.zulvit.teamentropy.DTO.MessageDTO;
import ru.zulvit.teamentropy.entity.Forum;
import ru.zulvit.teamentropy.entity.Message;
import ru.zulvit.teamentropy.entity.User;
import ru.zulvit.teamentropy.mappers.MessageMapper;
import ru.zulvit.teamentropy.repositories.ForumRepository;
import ru.zulvit.teamentropy.repositories.MessageRepository;
import ru.zulvit.teamentropy.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    private final MessageMapper messageMapper;

    private final ForumRepository forumRepository;

    private final UserRepository userRepository;

    public MessageService(MessageRepository messageRepository, MessageMapper messageMapper, ForumRepository forumRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
        this.forumRepository = forumRepository;
        this.userRepository = userRepository;
    }

    public List<MessageDTO> getAllMessages() {
        return messageRepository.findAll()
                .stream()
                .map(messageMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MessageDTO getMessageById(Long id) {
        if(messageRepository.findById(id).isPresent())
            return messageMapper.toDTO(messageRepository.findById(id).get());
        else
            throw new IllegalArgumentException("Ошибка: нет такого id");
    }

    public MessageDTO updateMessage(MessageDTO updatedMessage, Long id) {
        return messageRepository.findById(id)
                .map(message -> {
                    message.setText(updatedMessage.getText());
                    message.setRecipient(updatedMessage.getRecipient());
                    message.setContent(updatedMessage.getContent());
                    message.setReputation(updatedMessage.getReputation());
                    return  messageMapper.toDTO(messageRepository.save(message));
                })
                .orElseThrow(() -> new IllegalArgumentException("Ошибка: невозможно обновить сообщение"));
    }

    public MessageDTO saveMessage(MessageDTO message) {
        Message temp = messageMapper.toEntity(message);
        Forum forum = forumRepository.findById(message.getForumId()).
                orElseThrow(EntityNotFoundException::new);
        User user = userRepository.findById(message.getUserId()).
                orElseThrow(EntityNotFoundException::new);
        temp.setForum(forum);
        temp.setUser(user);
        return messageMapper.toDTO(messageRepository.save(temp));
    }

    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}
