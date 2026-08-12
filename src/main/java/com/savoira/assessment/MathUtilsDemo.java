package com.savoira.assessment;

public class MathUtilsDemo {

    public static void main(String[] args) {
        System.out.println("Rounded 45.678 -> " + MathUtils.roundToTwoDecimalPlaces(45.678));

        double simpleInterest = MathUtils.calculateSimpleInterest(10000, 8, 3);
        System.out.println("Simple interest on Rs.10000 at 8% for 3 years -> Rs." + simpleInterest);

        double compoundAmount = MathUtils.calculateCompoundInterest(10000, 8, 4, 3);
        System.out.println("Compound amount on Rs.10000 at 8% compounded quarterly for 3 years -> Rs." + compoundAmount);
    }
}