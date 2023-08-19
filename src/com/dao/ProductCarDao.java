package com.dao;

import com.models.ShopCar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 商城管理类
 *
 */
public class ProductCarDao {

   /**
   * 添加购物车条目
   * */
    public boolean addCar(Connection connection, ShopCar carItem) throws Exception{
        boolean flag = false;
        String sql="insert into dp_car values(null,?,?,?,?)";
        PreparedStatement pstmt=connection.prepareStatement(sql);
        pstmt.setInt(1, carItem.getUser_id());
        pstmt.setString(2, carItem.getProduct_name());
        pstmt.setDouble(3, carItem.getPrice());
        pstmt.setInt(4, carItem.getAmout());
        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            flag = true;
        }
        return  flag;
    }
    /**
    * 购物车列表
    * */
    public List<ShopCar> getCartItems(Connection connection, int customerId) {
        List<ShopCar> cartItems = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "SELECT * FROM dp_car WHERE customer_Id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, customerId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ShopCar cartItem = new ShopCar();
                cartItem.setUser_id(resultSet.getInt("customer_Id"));
                cartItem.setProduct_name(resultSet.getString("productname"));
                cartItem.setPrice(resultSet.getDouble("price"));
                cartItem.setAmout(resultSet.getInt("amount"));
                cartItems.add(cartItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cartItems;
    }
    /**
    * 购物车删除
    * */
    public boolean deleteCartItem(Connection con, int customerId, String productName) throws SQLException {
        String sql = "DELETE FROM dp_car WHERE customer_Id = ? AND productname = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, customerId);
            pstmt.setString(2, productName);
            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean updateCartItemQuantity(Connection con, int customerId, String productName, int newQuantity) throws SQLException {
        String sql = "UPDATE dp_car SET amount = ? WHERE customer_Id = ? AND productname = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, newQuantity);
            pstmt.setInt(2, customerId);
            pstmt.setString(3, productName);
            return pstmt.executeUpdate() > 0;
        }
    }
    /**
     * 清空购物车
     * */
    public boolean clearCartItems(Connection con, int customerId) throws SQLException {
        String sql = "DELETE FROM dp_car WHERE customer_Id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, customerId);
            return pstmt.executeUpdate() > 0;
        }
    }

}
