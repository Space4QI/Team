package ru.zulvit.teamentropy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zulvit.teamentropy.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
