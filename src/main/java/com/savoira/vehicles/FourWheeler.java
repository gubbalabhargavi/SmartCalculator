package com.savoira.vehicles;

public abstract class FourWheeler extends Vehicle {

    protected double tankCapacity;

    public FourWheeler(String brand, double tankCapacity) {
        super(brand);
        this.tankCapacity = tankCapacity;
        System.out.println("FourWheeler constructor running, tankCapacity: " + tankCapacity);
    }

    @Override
    public void move() {
        System.out.println(brand + " moves on four wheels.");
    }
}