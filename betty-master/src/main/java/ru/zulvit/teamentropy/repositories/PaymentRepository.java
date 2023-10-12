package ru.zulvit.teamentropy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zulvit.teamentropy.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
