package com.models;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 2023/8/11
 * Time: 15:31
 * Description: No Description
 */
import java.util.HashMap;
import java.util.Map;

public class Admin {
  String adminName;
  String passsword;

  public Admin() {
      super();
  }

  public Admin(String adminname,String passsword) {
      this.adminName = adminname;
      this.passsword = passsword;
  }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }
}
