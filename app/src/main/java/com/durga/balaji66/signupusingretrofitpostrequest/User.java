package com.durga.balaji66.signupusingretrofitpostrequest;

public class User {
    private String name;
    private String email;
    private String phone;
    private String password;
    private int fine;

    public User()
    {

    }
    public User(String name, String email, String phone, String password, int fine)
    {
        this.name = name;
        this.email =email;
        this.phone = phone;
        this.password =password;
        this.fine =fine;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
