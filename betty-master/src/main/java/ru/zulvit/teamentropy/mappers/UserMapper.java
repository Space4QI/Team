package ru.zulvit.teamentropy.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.zulvit.teamentropy.DTO.UserDTO;
import ru.zulvit.teamentropy.entity.User;

@Component
public class UserMapper {
    private final org.modelmapper.ModelMapper userMap;

    @Autowired
    public UserMapper(org.modelmapper.ModelMapper userMap) {
        this.userMap = userMap;
    }

    public UserDTO toDTO(User input) {
        return userMap.map(input, UserDTO.class);
    }

    public User toEntity(UserDTO input) { return userMap.map(input, User.class); }
}