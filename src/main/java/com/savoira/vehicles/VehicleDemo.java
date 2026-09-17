package com.savoira.vehicles;

import java.util.List;

public class VehicleDemo {

    public static void main(String[] args) {

        System.out.println("----- Creating a BMW -----");
        // Watch the console: Vehicle -> FourWheeler -> Car -> BMW constructors
        // all run in that order, because of super() chaining.
        Vehicle v1 = new BMW("BMW X5", 80.0, true, true, true);

        System.out.println();
        System.out.println("----- Creating a Toyota -----");
        Vehicle v2 = new Toyota("Toyota Camry", 60.0, true, true);

        System.out.println();
        System.out.println("----- Creating a Yamaha -----");
        Vehicle v3 = new Yamaha("Yamaha R15", 11.0, true, true);

        System.out.println();
        System.out.println("----- Creating a Honda -----");
        Vehicle v4 = new Honda("Honda Shine", 12.0, true, true);

        System.out.println();
        System.out.println("----- Polymorphism demo: same method call, different behavior -----");
        // Each object is stored as a Vehicle reference, but move() runs
        // the version that belongs to its ACTUAL class (BMW/Toyota/Yamaha/Honda).
        List<Vehicle> vehicles = List.of(v1, v2, v3, v4);
        for (Vehicle v : vehicles) {
            v.move();
        }

        System.out.println();
        System.out.println("----- Accessing subclass-only methods -----");
        // v1 is declared as type Vehicle, so we must cast it back to BMW
        // to call showFeatures(), since Vehicle itself has no such method.
        ((BMW) v1).showFeatures();
        ((Toyota) v2).showFeatures();
        ((Yamaha) v3).showFeatures();
        ((Honda) v4).showFeatures();

        // The following line, if uncommented, will NOT compile:
        // Vehicle broken = new Vehicle("Generic"); // Vehicle is abstract!
    }
}