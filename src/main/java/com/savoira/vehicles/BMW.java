package com.savoira.vehicles;

public class BMW extends Car {

    private boolean powerSteering;
    private boolean airbags;

    public BMW(String brand, double tankCapacity, boolean airConditioning,
               boolean powerSteering, boolean airbags) {
        super(brand, tankCapacity, airConditioning);
        this.powerSteering = powerSteering;
        this.airbags = airbags;
        System.out.println("BMW constructor running, powerSteering: " + powerSteering + ", airbags: " + airbags);
    }

    @Override
    public void move() {
        System.out.println(brand + " (BMW) glides on the road with premium handling.");
    }

    public void showFeatures() {
        System.out.println(brand + " features -> tankCapacity: " + tankCapacity
                + ", AC: " + airConditioning
                + ", powerSteering: " + powerSteering
                + ", airbags: " + airbags);
    }
}