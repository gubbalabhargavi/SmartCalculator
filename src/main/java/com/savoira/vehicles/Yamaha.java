package com.savoira.vehicles;

public class Yamaha extends Bike {

    private boolean absEnabled;
    private boolean digitalDisplay;

    public Yamaha(String brand, double fuelTankCapacity, boolean absEnabled, boolean digitalDisplay) {
        super(brand, fuelTankCapacity);
        this.absEnabled = absEnabled;
        this.digitalDisplay = digitalDisplay;
        System.out.println("Yamaha constructor running, ABS: " + absEnabled + ", digitalDisplay: " + digitalDisplay);
    }

    @Override
    public void move() {
        System.out.println(brand + " (Yamaha) accelerates with a sporty feel.");
    }

    public void showFeatures() {
        System.out.println(brand + " features -> fuelTankCapacity: " + fuelTankCapacity
                + ", ABS: " + absEnabled
                + ", digitalDisplay: " + digitalDisplay);
    }
}