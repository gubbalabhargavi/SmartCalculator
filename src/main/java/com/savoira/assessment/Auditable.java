package com.savoira.assessment;

/**
 * Represents an object that can produce an audit log summary.
 */
public interface Auditable {

    /**
     * @return a summary of this object formatted for audit purposes
     */
    String getAuditLog();

    /**
     * @return the standard prefix used to mark audit output
     */
    default String getAuditPrefix() {
        return "[AUDIT] ";
    }
}