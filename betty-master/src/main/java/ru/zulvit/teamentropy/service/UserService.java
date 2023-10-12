package ru.zulvit.teamentropy.service;

import org.springframework.stereotype.Service;
import ru.zulvit.teamentropy.DTO.UserDTO;
import ru.zulvit.teamentropy.mappers.UserMapper;
import ru.zulvit.teamentropy.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(String email) {
        if(userRepository.findById(email).isPresent())
            return userMapper.toDTO(userRepository.findById(email).get());
        else
            throw new IllegalArgumentException("Ошибка: нет такого id");
    }

    public UserDTO updateUser(UserDTO updatedForum, String email) {
        return userRepository.findById(email)
                .map(user -> {
                    user.setPassword(updatedForum.getPassword());
                    user.setCredentials(updatedForum.getCredentials());
                    user.setLicensesKey(updatedForum.getLicensesKey());
                    user.setAvatar(updatedForum.getAvatar());
                    user.setAdmin(updatedForum.isAdmin());
                    user.setStatus(updatedForum.getStatus());
                    return userMapper.toDTO(userRepository.save(user));
                })
                .orElseThrow(() -> new IllegalArgumentException("Ошибка: невозможно обновить пользователя"));
    }

    public UserDTO saveUser(UserDTO forum) {
        return userMapper.toDTO(userRepository.save(userMapper.toEntity(forum)));
    }

    public void deleteUser(String email) {
        userRepository.deleteById(email);
    }
}
