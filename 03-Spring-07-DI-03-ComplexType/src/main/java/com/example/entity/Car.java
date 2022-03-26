package com.example.entity;

public class Car {
    private String color;

    public Car() {

    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                '}';
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Car(String color) {
        this.color = color;
    }
}
