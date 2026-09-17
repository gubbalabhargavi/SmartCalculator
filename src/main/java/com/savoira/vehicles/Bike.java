package com.savoira.vehicles;

public abstract class Bike extends TwoWheeler {

    protected double fuelTankCapacity;

    public Bike(String brand, double fuelTankCapacity) {
        super(brand);
        this.fuelTankCapacity = fuelTankCapacity;
        System.out.println("Bike constructor running, fuelTankCapacity: " + fuelTankCapacity);
    }

    @Override
    public void move() {
        System.out.println(brand + " (a bike) rides swiftly through traffic.");
    }
}