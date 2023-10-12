package ru.zulvit.teamentropy.DTO;

import ru.zulvit.teamentropy.entity.Payment;

import java.math.BigDecimal;

public class PaymentDTO {

    private Long id;

    private BigDecimal amount;

    private String userId;

    public PaymentDTO(){

    }

    public PaymentDTO(Long id, BigDecimal amount, String userId) {
        this.id = id;
        this.amount = amount;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
