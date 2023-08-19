package com.dao;

import com.models.Customer;
import com.models.Product;
import com.models.user_type;
import com.utils.StringUtil;
import sun.security.util.Password;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户Dao类
 *
 * */

public class CustomerUserDao {
   /**
   * 添加用户功能
   * @param user
    * @param connection
    * @return
    * @throws Exception
   */
    public  boolean addCutomer(Connection connection,Customer user) {
        boolean flag = false;
        String sql = "INSERT INTO dp_user VALUES (null,?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setString(1, user.getUserName());
            pt.setString(2, user.getPassword());
            pt.setString(4,user.getPhoneNumber());
            pt.setString(5,user.getEmail());
            pt.setFloat(6,0.0f);

            String userTypeValue = "铜";
            pt.setString(3, userTypeValue); // 将用户级别设置为相应的字符串

            java.util.Date currentDate = new java.util.Date();
            Timestamp timestamp = new Timestamp(currentDate.getTime());
            pt.setTimestamp(7, timestamp); // 设置注册时间为当前系统时间

            int rowsAffected = pt.executeUpdate();
            if (rowsAffected > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 用户登陆
     * @param connection
     * @param user
     * @return
     * @throws Exception
     * */
    public Customer login(Connection connection, Customer user) {
        Customer resultUser = null;
        String sql = "select * from dp_user where userName=? and password=?";
        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setString(1, user.getUserName());
            pt.setString(2, user.getPassword());
            ResultSet rs = pt.executeQuery();
            if (rs.next()) {
                resultUser = new Customer();
                resultUser.setId(rs.getInt("id"));
                resultUser.setUserName(rs.getString("userName"));
                resultUser.setPassword(rs.getString("password"));
                resultUser.setEmail(rs.getString("email"));
                resultUser.setTotal_costmoney(rs.getFloat("total_costmoney"));
                resultUser.setPhoneNumber(rs.getString("phoneNUmber"));
                //客户级别
                String userTypeValue = rs.getString("user_type");
                if ("金".equals(userTypeValue)) {
                    resultUser.setUser_type(com.models.user_type.金);
                } else if ("银".equals(userTypeValue)) {
                    resultUser.setUser_type(com.models.user_type.银);
                } else if ("铜".equals(userTypeValue)) {
                    resultUser.setUser_type(com.models.user_type.铜);
                } else {
                    // 默认处理（如果没有匹配到合适的值）
                    resultUser.setUser_type(null); // 或者设置一个默认的枚举值
                }

                // 获取数据库中的日期时间值
                Timestamp timestamp = rs.getTimestamp("registrationDate");
                if (timestamp != null) {
                    Date registrationDate = new Date(timestamp.getTime());
                    resultUser.setRegistrationDate(registrationDate);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultUser;
    }
    /**
     * 列出用户信息
     * @param connection
     * @param cus
     * @return
     * @throws Exception
     * */
    public ResultSet list(Connection connection,Customer cus) throws  Exception{
        StringBuilder sb = new StringBuilder("select * from dp_user");
        List<String> conditions = new ArrayList<>();
        List<Object> values = new ArrayList<>();

        if (StringUtil.isNotEmtpty(cus.getUserName())) {
            conditions.add("userName like ?");
            values.add("%" + cus.getUserName() + "%");
        }

        if (StringUtil.isNotEmtpty(cus.getEmail())) {
            conditions.add("email like ?");
            values.add("%" + cus.getEmail() + "%");
        }

        if (StringUtil.isNotEmtpty(cus.getPhoneNumber())) {
            conditions.add("phoneNumber like ?");
            values.add("%" + cus.getPhoneNumber() + "%");
        }

        // 拼接所有条件
        if (!conditions.isEmpty()) {
            sb.append(" where ").append(String.join(" and ", conditions));
        }

        PreparedStatement pstmt = connection.prepareStatement(sb.toString());

        // 设置参数值
        for (int i = 0; i < values.size(); i++) {
            pstmt.setObject(i + 1, values.get(i));
        }

        return pstmt.executeQuery();
    }
    /**
    * 删除客户信息
    * @param connection
     * @param userName
     * @return
     * @throws Exception
    * */
    public int delete(Connection connection,String userName) throws Exception{
        String selectIdSql = "SELECT id FROM dp_user WHERE userName=?";
        String deleteSql = "DELETE FROM dp_user WHERE id=?";
        PreparedStatement selectStmt = connection.prepareStatement(selectIdSql);
        selectStmt.setString(1, userName);
        ResultSet resultSet = selectStmt.executeQuery();
        int id = -1; // 初始化为一个无效的值
        if (resultSet.next()) {
            id = resultSet.getInt("id");
        }
        if (id != -1) {
            PreparedStatement deleteStmt = connection.prepareStatement(deleteSql);
            deleteStmt.setInt(1, id);
            return deleteStmt.executeUpdate();
        }
        return 0; // 未找到匹配的用户记录
    }
    /**
    * 更新消费值
    * */
    public boolean updateTotalPayment(Connection con, int customerId, double newTotalPayment) throws Exception {
        String sql = "UPDATE dp_user SET total_costmoney = ? WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setDouble(1, newTotalPayment);
            pstmt.setInt(2, customerId);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
}