package com.savoira;

public class StringBuilderDemo {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            // StringBuilder is preferred over String concatenation inside a loop
            // because String objects are immutable in Java, so each "+" concatenation
            // creates a brand new String object in memory and discards the old one,
            // which becomes very expensive as the loop grows. StringBuilder instead
            // uses a resizable internal buffer and modifies it in place, so appending
            // in a loop is much faster and uses far less memory.
            sb.append("Item ").append(i).append(" ");
        }

        System.out.println(sb.toString());
    }
}