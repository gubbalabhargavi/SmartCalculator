package com.savoira.w5;

/**
 * Represents a loan that can produce an audit-friendly summary string.
 */
public interface Auditable {

    /**
     * @return a formatted audit summary for this loan
     */
    String auditSummary();

    /**
     * @return the standard prefix used to mark audit output
     */
    default String auditPrefix() {
        return "[AUDIT] ";
    }
}