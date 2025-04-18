package org.safepassenger.model;

/**
 * BasicData interface represents a generic data structure with methods to set and get basic information.
 * It can be implemented by different classes such as User and Driver.
 */

public interface BasicData {
    public void BasicInformation(String name, String lastName, String email);
}
