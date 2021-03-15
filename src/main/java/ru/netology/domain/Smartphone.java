package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product {
    private String phoneMaker;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String phoneMaker) {
        super(id, name, price);
        this.phoneMaker = phoneMaker;
    }

    public String getPhoneMaker() {
        return phoneMaker;
    }

    public void setPhoneMaker(String phoneMaker) {
        this.phoneMaker = phoneMaker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return Objects.equals(phoneMaker, that.phoneMaker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), phoneMaker);
    }
}