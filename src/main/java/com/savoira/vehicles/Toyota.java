package com.savoira.vehicles;

public class Toyota extends Car {

    private boolean musicSystem;

    public Toyota(String brand, double tankCapacity, boolean airConditioning, boolean musicSystem) {
        super(brand, tankCapacity, airConditioning);
        this.musicSystem = musicSystem;
        System.out.println("Toyota constructor running, musicSystem: " + musicSystem);
    }

    @Override
    public void move() {
        System.out.println(brand + " (Toyota) drives reliably and efficiently.");
    }

    public void showFeatures() {
        System.out.println(brand + " features -> tankCapacity: " + tankCapacity
                + ", AC: " + airConditioning
                + ", musicSystem: " + musicSystem);
    }
}