package br.com.well.api.amazon.model.entities;

public enum UserRole {

    ADMIN("Admin"),
    USER("User");

    private String role;

    UserRole(String role) {
        this.role = role;
    }
}

