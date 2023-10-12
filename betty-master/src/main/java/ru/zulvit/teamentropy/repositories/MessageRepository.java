package ru.zulvit.teamentropy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zulvit.teamentropy.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository <Message, Long> {
}
