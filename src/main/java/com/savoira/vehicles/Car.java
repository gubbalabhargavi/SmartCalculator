package com.savoira.vehicles;

public abstract class Car extends FourWheeler {

    protected boolean airConditioning;

    public Car(String brand, double tankCapacity, boolean airConditioning) {
        super(brand, tankCapacity);
        this.airConditioning = airConditioning;
        System.out.println("Car constructor running, airConditioning: " + airConditioning);
    }

    @Override
    public void move() {
        System.out.println(brand + " (a car) drives smoothly on the road.");
    }
}