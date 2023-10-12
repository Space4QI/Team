package ru.zulvit.teamentropy.DTO;

import java.math.BigDecimal;
import java.util.Date;

public class ProductDTO {

    private String name;

    private Date releaseDate;

    private String version;

    private BigDecimal price;

    private String pack;

    private boolean studentsDiscount;

    private boolean specialDiscounts;

    private String userId;

    public ProductDTO(){

    }

    public ProductDTO(String name, Date releaseDate, String version, BigDecimal price, String pack, boolean studentsDiscount, boolean specialDiscounts, String userId) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.version = version;
        this.price = price;
        this.pack = pack;
        this.studentsDiscount = studentsDiscount;
        this.specialDiscounts = specialDiscounts;
        this.userId = userId;
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

    public boolean isStudentsDiscount() {
        return studentsDiscount;
    }

    public void setStudentsDiscount(boolean studentsDiscount) {
        this.studentsDiscount = studentsDiscount;
    }

    public boolean isSpecialDiscounts() {
        return specialDiscounts;
    }

    public void setSpecialDiscounts(boolean specialDiscounts) {
        this.specialDiscounts = specialDiscounts;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
