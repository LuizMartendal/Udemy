package br.com.erudio.dtos.security;

import java.io.Serializable;

public class AccountCredentialsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userName;
    private String password;

    public AccountCredentialsDTO(String userName, String password) {
        this.setUserName(userName);
        this.setPassword(password);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}