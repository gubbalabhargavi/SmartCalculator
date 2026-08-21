package com.savoira.w5;

/**
 * Represents a loan that can be exported as a CSV row.
 */
public interface Exportable {

    /**
     * @return this loan's fields as a single comma-separated CSV row
     */
    String toCSVRow();
}