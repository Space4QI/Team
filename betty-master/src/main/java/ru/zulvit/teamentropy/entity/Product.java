package ru.zulvit.teamentropy.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table
public class Product {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "version")
    private String version;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "pack")
    private String pack;

    @Column(name = "student_discounts", nullable = false)
    private boolean studentDiscounts;

    @Column(name = "special_discounts", nullable = false)
    private boolean specialDiscounts;

    @ManyToOne
    @JoinColumn(name = "key", referencedColumnName = "licenses_key")
    private User key;

    public Product(String name, Date releaseDate, String version, BigDecimal price, String pack, boolean studentDiscounts, boolean specialDiscounts, User key) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.version = version;
        this.price = price;
        this.pack = pack;
        this.studentDiscounts = studentDiscounts;
        this.specialDiscounts = specialDiscounts;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public boolean isStudentDiscounts() {
        return studentDiscounts;
    }

    public void setStudentDiscounts(boolean studentDiscounts) {
        this.studentDiscounts = studentDiscounts;
    }

    public boolean isSpecialDiscounts() {
        return specialDiscounts;
    }

    public void setSpecialDiscounts(boolean specialDiscounts) {
        this.specialDiscounts = specialDiscounts;
    }

    public User getKey() {
        return key;
    }

    public void setKey(User key) {
        this.key = key;
    }

    public void setUser(User user) {
    }
}
