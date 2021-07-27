package com.triggerise.store.domain;

/**
 * ProductEnum, this enum contains the description and cost fields
 * and is used to make the code more readable
 *
 * @author  Prenesh Naidoo
 * @version 1.0
 * @since  2021
 */
public enum ProductEnum {

    MUG("Mug", "Triggerise Mug ", 4.00),
    TSHIRT("T-shirt", "Triggerise Tshirt", 21.00),
    USBKEY("usbkey", "Triggerise USB Key", 10.00);

    private String name = null;
    private String description = null;
    private double cost = 0;

    ProductEnum(String name, String description, double cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public String getValue() {
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }
}
