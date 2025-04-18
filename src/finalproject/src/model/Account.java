package org.safepassenger.model;

/**
 * Account interface represents a generic account with methods to set and get email and password.
 * It can be implemented by different classes such as User and Driver.
 */

public interface Account {
    String setEmail(String email);
    String setPassword(String password);
    String getEmail();
    String getPassword();
}
