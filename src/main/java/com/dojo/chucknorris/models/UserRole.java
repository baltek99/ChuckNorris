package com.dojo.chucknorris.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;

public enum UserRole {
    ADMIN("admin"),
    USER("user");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
