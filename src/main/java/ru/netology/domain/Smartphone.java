package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Smartphone extends Product {
    private String manufacture;

    public Smartphone() {
    }

    public Smartphone(int id, String name, int price, String manufacture) {
        super(id, name, price);
        this.manufacture = manufacture;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search))
            return true;
        return getManufacture().contains(search);
    }
}
