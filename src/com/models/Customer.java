package com.models;

import com.models.user_type;

import java.util.Date;
/*
* 用户类
*
*
* */

public class Customer {

    private int id;
    private String userName;
    private String password;
    private com.models.user_type user_type;
    private String phoneNumber;
    private String email;
    private float total_costmoney;
    private Date registrationDate; //注册时间

    public Customer() {
        super();
    }

    public Customer(String userName,String  password) {
        this.userName = userName;
        this.password = password;
    }
    public Customer(String userName,String phoneNumber,String email,String password) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public Customer(String userName,String phoneNumber,String email){
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public float getTotal_costmoney() {return total_costmoney;}

    public void setTotal_costmoney(float total_costmoney) {this.total_costmoney = total_costmoney;}

    public Date getRegistrationDate() {return registrationDate;}

    public void setRegistrationDate(Date registrationDate) {this.registrationDate = registrationDate;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getUserName() {return userName;}

    public void setUserName(String userName) {this.userName = userName;}

    public com.models.user_type getUser_type() {return user_type;}

    public void setUser_type(com.models.user_type user_type) {this.user_type = user_type;}
}
