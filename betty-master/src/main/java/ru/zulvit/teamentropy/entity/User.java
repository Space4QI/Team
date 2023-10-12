package ru.zulvit.teamentropy.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "credentiels")
    private String credentials;

    @Column(name = "licenses_key", nullable = false, unique = true)
    private String licensesKey;

    @Column(name = "avatar", nullable = false)
    private String avatar;

    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin;

    @Column(name = "status", nullable = false)
    private short status;

    @OneToMany
    @JoinColumn(name = "key", referencedColumnName = "licenses_key")
    private List<Product> products;

    @OneToMany
    @JoinColumn(name = "recipient", referencedColumnName = "email")
    private List<Payment> paymentsReceived;

    @OneToMany
    @JoinColumn(name = "sender", referencedColumnName = "email")
    private List<Payment> paymentsSent;

    @OneToMany
    @JoinColumn(name = "sender", referencedColumnName = "email")
    private List<Message> sentMessages;

    public User(String email, String password, String credentials, String licensesKey, String avatar, boolean isAdmin, short status, List<Product> products, List<Payment> paymentsReceived, List<Payment> paymentsSent, List<Message> sentMessages) {
        this.email = email;
        this.password = password;
        this.credentials = credentials;
        this.licensesKey = licensesKey;
        this.avatar = avatar;
        this.isAdmin = isAdmin;
        this.status = status;
        this.products = products;
        this.paymentsReceived = paymentsReceived;
        this.paymentsSent = paymentsSent;
        this.sentMessages = sentMessages;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public String getLicensesKey() {
        return licensesKey;
    }

    public void setLicensesKey(String licensesKey) {
        this.licensesKey = licensesKey;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Payment> getPaymentsReceived() {
        return paymentsReceived;
    }

    public void setPaymentsReceived(List<Payment> paymentsReceived) {
        this.paymentsReceived = paymentsReceived;
    }

    public List<Payment> getPaymentsSent() {
        return paymentsSent;
    }

    public void setPaymentsSent(List<Payment> paymentsSent) {
        this.paymentsSent = paymentsSent;
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }
}
