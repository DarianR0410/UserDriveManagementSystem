package org.safepassenger.model;

/**
 * PhoneNumberHolder interface represents a generic data structure with methods to set and get phone number.
 * It can be implemented by different classes such as User and Driver.
 */

public interface PhoneNumberHolder {
    public void SetNewPhoneNumber(String phoneNumber);
}
