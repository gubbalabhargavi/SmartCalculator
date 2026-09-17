package com.savoira.vehicles;

public abstract class Vehicle {

    protected String brand;

    public Vehicle(String brand) {
        this.brand = brand;
        System.out.println("Vehicle constructor running for: " + brand);
    }

    public abstract void move();
}