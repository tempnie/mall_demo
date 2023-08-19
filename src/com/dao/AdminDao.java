package com.dao;

import com.models.Admin;
import com.models.Customer;

import java.sql.*;
import java.util.Date;

/**
 * 管理员Dao类
 */
public class AdminDao {



    /**
     * 登陆
     * @param connection
     * @param admin
     * @return
     * @throws Exception
     * */
    public Admin adminLogin(Connection connection, Admin admin) {
        Admin resultAdmin = null;
        String sql = "select * from dp_admin where adminName=? and password=?";
        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setString(1, admin.getAdminName());
            pt.setString(2, admin.getPasssword());
            ResultSet rs = pt.executeQuery();
            if (rs.next()) {
                resultAdmin = new Admin();
                resultAdmin.setAdminName(rs.getString("adminName"));
                resultAdmin.setPasssword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultAdmin;
    }

   /**
   * 管理员重置密码操作
   * */
   public int updateAdminPassword(Connection connection,Admin admin) throws Exception{
       String sql = "UPDATE dp_admin SET password = ? WHERE adminName = ?";
       PreparedStatement pstmt = connection.prepareStatement(sql);
       pstmt.setString(1, admin.getPasssword());
       pstmt.setString(2, admin.getAdminName());
       return pstmt.executeUpdate();
    }
}

