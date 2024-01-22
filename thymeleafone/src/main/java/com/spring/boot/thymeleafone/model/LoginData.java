package com.spring.boot.thymeleafone.model;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginData {
    @NotBlank(message = "User Name can not be empty.!")
    @Size(min = 3, max = 12, message = "User name must be between 3 - 12 characters !!")
    private String userName;

    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid Email")
    private String email;

    @AssertTrue(message = "Must agree to terms & condition")
    private boolean agreed;
    public LoginData(String userName, String email, boolean agreed) {
        this.userName = userName;
        this.email = email;
        this.agreed = agreed;
    }

    public LoginData() {
    }

    public boolean isAgreed() {
        return agreed;
    }

    public void setAgreed(boolean agreed) {
        this.agreed = agreed;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "LoginData{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", agreed=" + agreed +
                '}';
    }
}
