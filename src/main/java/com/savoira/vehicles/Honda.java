package com.savoira.vehicles;

public class Honda extends Bike {

    private boolean selfStart;
    private boolean mobileCharging;

    public Honda(String brand, double fuelTankCapacity, boolean selfStart, boolean mobileCharging) {
        super(brand, fuelTankCapacity);
        this.selfStart = selfStart;
        this.mobileCharging = mobileCharging;
        System.out.println("Honda constructor running, selfStart: " + selfStart + ", mobileCharging: " + mobileCharging);
    }

    @Override
    public void move() {
        System.out.println(brand + " (Honda) rides smoothly and efficiently.");
    }

    public void showFeatures() {
        System.out.println(brand + " features -> fuelTankCapacity: " + fuelTankCapacity
                + ", selfStart: " + selfStart
                + ", mobileCharging: " + mobileCharging);
    }
}