package model;

import model.product.Product;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.random.RandomGenerator;

public class DiscountCode {
    private double discountPercent;
    private int discountCapacity;
    private String discountCode;
    private LocalDate discountCredit;
    private int discountCapacityCount;

    public DiscountCode(double discountPercent, int discountCapacity, LocalDate discountCredit) {
        this.discountPercent = discountPercent;
        this.discountCapacity = discountCapacity;
        this.discountCredit = discountCredit;
        this.discountCode = buildCode();
    }

    private String buildCode() {
        StringBuilder code = new StringBuilder();
        code.append("DC");
        Random random = new Random();
        int number = random.nextInt();
        code.append(number);
        return code.toString();
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public void setDiscountCapacity(int discountCapacity) {
        this.discountCapacity = discountCapacity;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }


    public double getDiscountPercent() {
        return discountPercent;
    }

    public int getDiscountCapacity() {
        return discountCapacity;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCredit(LocalDate discountCredit) {
        this.discountCredit = discountCredit;
    }

    public LocalDate getDiscountCredit() {
        return discountCredit;
    }

    public void setDiscountCapacityCount(int discountCapacityCount) {
        this.discountCapacityCount = discountCapacityCount;
    }

    public int getDiscountCapacityCount() {
        return discountCapacityCount;
    }
}
