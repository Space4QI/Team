package ru.zulvit.teamentropy.mappers;

import ru.zulvit.teamentropy.DTO.ForumDTO;
import ru.zulvit.teamentropy.entity.Forum;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper (){

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
        TypeMap<ForumDTO, Forum> forumMapper = modelMapper.createTypeMap
                (ForumDTO.class, Forum.class);
        return modelMapper;
    }
}
