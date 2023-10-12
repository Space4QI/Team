package ru.zulvit.teamentropy.service;

import org.springframework.stereotype.Service;
import ru.zulvit.teamentropy.DTO.ForumDTO;
import ru.zulvit.teamentropy.mappers.ForumMapper;
import ru.zulvit.teamentropy.repositories.ForumRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForumService {

    private final ForumRepository forumRepository;

    private final ForumMapper forumMapper;

    public ForumService(ForumRepository forumRepository, ForumMapper forumMapper) {
        this.forumRepository = forumRepository;
        this.forumMapper = forumMapper;
    }

    public List<ForumDTO> getAllForums() {
        return forumRepository.findAll()
                .stream()
                .map(forumMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ForumDTO getForumById(String topic) {
        if(forumRepository.findById(topic).isPresent())
            return forumMapper.toDTO(forumRepository.findById(topic).get());
        else
            throw new IllegalArgumentException("Ошибка: нет такого id");
    }

    public ForumDTO updateForum(ForumDTO updatedForum, String topic) {
        return forumRepository.findById(topic)
                .map(forum -> {
                    forum.setTheme(updatedForum.getTheme());
                    forum.setTags(updatedForum.getTags());
                    return  forumMapper.toDTO(forumRepository.save(forum));
                })
                .orElseThrow(() -> new IllegalArgumentException("Ошибка: невозможно обновить форум"));
    }

    public ForumDTO saveForum(ForumDTO forum) {
        return forumMapper.toDTO(forumRepository.save(forumMapper.toEntity(forum)));
    }

    public void deleteForum(String topic) {
        forumRepository.deleteById(topic);
    }
}
