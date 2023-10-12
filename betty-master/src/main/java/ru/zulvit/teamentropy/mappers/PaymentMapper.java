package ru.zulvit.teamentropy.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.zulvit.teamentropy.DTO.PaymentDTO;
import ru.zulvit.teamentropy.entity.Payment;

@Component
public class PaymentMapper {
    private final org.modelmapper.ModelMapper paymentMap;

    @Autowired
    public PaymentMapper(org.modelmapper.ModelMapper paymentMap) {
        this.paymentMap = paymentMap;
    }

    public PaymentDTO toDTO(Payment input) { return paymentMap.map(input, PaymentDTO.class); }

    public Payment toEntity(PaymentDTO input) { return paymentMap.map(input, Payment.class); }
}