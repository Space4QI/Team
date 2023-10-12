package ru.zulvit.teamentropy.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipient", referencedColumnName = "email")
    private User recipient;

    @ManyToOne
    @JoinColumn(name = "sender", referencedColumnName = "email")
    private User sender;

    @Column(name = "amount")
    private BigDecimal amount;

    public Payment(Long id, User recipient, User sender, BigDecimal amount) {
        this.id = id;
        this.recipient = recipient;
        this.sender = sender;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setUser(User user) {
    }
}