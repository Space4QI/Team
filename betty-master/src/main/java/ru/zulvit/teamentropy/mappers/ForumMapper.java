package ru.zulvit.teamentropy.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.zulvit.teamentropy.DTO.ForumDTO;
import ru.zulvit.teamentropy.entity.Forum;

@Component
public class ForumMapper {
    private final org.modelmapper.ModelMapper forumMap;

    @Autowired
    public ForumMapper(org.modelmapper.ModelMapper forumMap) {
        this.forumMap = forumMap;
    }

    public ForumDTO toDTO(Forum input) {
        return forumMap.map(input, ForumDTO.class);
    }

    public Forum toEntity(ForumDTO input) {
        return forumMap.map(input, Forum.class);
    }
}



