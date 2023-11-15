package com.dictionaryapp.model.binding;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserLoginBindingModel {

    @NotNull
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 symbols")
    private String username;

    @NotNull
    @Size(min = 3, max = 20,  message = "Password must be between 3 and 20 symbols")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
