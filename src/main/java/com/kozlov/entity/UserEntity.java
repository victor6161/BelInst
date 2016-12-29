package com.kozlov.entity;


import java.io.Serializable;

/**
 *
 */
public class UserEntity implements Serializable {


    private String name;
    private String email;
    private String password;
    private String role;
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    private Integer count;

    public UserEntity() {

    }

    public UserEntity(String username, String password, String email) {
        this.name = username;
        this.password = password;
        this.email = email;
        this.role = "ROLE_USER";
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (!name.equals(that.name)) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        return password.equals(that.password);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + password.hashCode();
        return result;
    }

}
