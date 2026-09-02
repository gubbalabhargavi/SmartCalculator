package com.savoira.assessment;

/**
 * Represents an object that can be exported as a CSV row.
 */
public interface Exportable {

    /**
     * @return this object's key fields as a comma-separated CSV row
     */
    String toCSVRow();
}