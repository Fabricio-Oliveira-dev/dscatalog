package com.devfabricio.dscatalog.dtos;

public class UserInsertDto extends UserDTO {

    private String password;

    public UserInsertDto() {
        super();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
