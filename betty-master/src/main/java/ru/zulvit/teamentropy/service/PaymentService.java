package ru.zulvit.teamentropy.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import ru.zulvit.teamentropy.DTO.PaymentDTO;
import ru.zulvit.teamentropy.entity.Payment;
import ru.zulvit.teamentropy.entity.User;
import ru.zulvit.teamentropy.mappers.PaymentMapper;
import ru.zulvit.teamentropy.repositories.PaymentRepository;
import ru.zulvit.teamentropy.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    private final PaymentMapper paymentMapper;

    private final UserRepository userRepository;

    public PaymentService(PaymentRepository paymentRepository, PaymentMapper paymentMapper, UserRepository userRepository) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
        this.userRepository = userRepository;
    }

    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll()
                .stream()
                .map(paymentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PaymentDTO getPaymentById(Long id) {
        if (paymentRepository.findById(id).isPresent())
            return paymentMapper.toDTO(paymentRepository.findById(id).get());
        else
            throw new IllegalArgumentException("Ошибка: нет такого id");
    }

    public PaymentDTO updatePayment(PaymentDTO updatedPayment, Long id) {
        return paymentRepository.findById(id)
                .map(payment -> {
                    payment.setAmount(updatedPayment.getAmount());
                    return paymentMapper.toDTO(paymentRepository.save(payment));
                })
                .orElseThrow(() -> new IllegalArgumentException("Ошибка: невозможно обновить оплату"));
    }

    public PaymentDTO savePayment(PaymentDTO payment) {
        Payment temp = paymentMapper.toEntity(payment);
        User user = userRepository.findById(payment.getUserId()).
                orElseThrow(EntityNotFoundException::new);
        temp.setUser(user);
        temp.setId(null);
        return  paymentMapper.toDTO(paymentRepository.save(temp));

    }

    public void deletePayment(Long id) { paymentRepository.deleteById(id); }
}
