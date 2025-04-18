package org.safepassenger.model;

/**
 * PasswordHolder interface represents a generic data structure with methods to set and get password.
 * It can be implemented by different classes such as User and Driver.
 */

public interface PasswordHolder {

    public void SetNewPassword(String password);
}
