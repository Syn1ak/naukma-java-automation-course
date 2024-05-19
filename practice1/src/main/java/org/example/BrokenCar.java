package org.example;

public class BrokenCar {
    private String model;
    private int year;

    public BrokenCar(String model, int year) {
        this.model = model;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return "hello".hashCode();
    }

    @Override
    public String toString() {
        return "BrokenCar{" +
                "model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
