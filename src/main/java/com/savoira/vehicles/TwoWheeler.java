package com.savoira.vehicles;

public abstract class TwoWheeler extends Vehicle {

    public TwoWheeler(String brand) {
        super(brand);
        System.out.println("TwoWheeler constructor running for: " + brand);
    }

    @Override
    public void move() {
        System.out.println(brand + " moves on two wheels.");
    }
}