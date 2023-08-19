package com.dao;

import com.models.Product;
import com.utils.StringUtil;

import java.sql.*;

/**
 * 商品Dao类
 */
public class ProductDao {

    /**
    * 添加商品
     * @param connection
     * @param product
     * @return
     * @throws Exception
    * */
    public boolean addProduct(Connection connection, Product product) {
        boolean flag = false;
        String sql = "INSERT INTO dp_product VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setString(1, product.getProductName());
            pt.setString(2, product.getManufacturer());
            pt.setObject(3,product.getProductionDate());
            pt.setString(4,product.getModel());
            pt.setDouble(5,product.getPurchasePrice());
            pt.setDouble(6,product.getRetailPrice());
            pt.setInt(7,product.getQuantity());

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
    * 列出商品信息功能实现
    * @param con
     * @param product
     * @return
     * @throws Exception
    * */
    public ResultSet listProduct(Connection con,Product product) throws Exception {
         StringBuffer sb = new StringBuffer("select * from dp_product");
         if (StringUtil.isNotEmtpty(product.getProductName())){
             sb.append("and product_name like '%" + product.getProductName() + "%'");
         }
        PreparedStatement pt = con.prepareStatement(sb.toString().replaceFirst("and","where"));
        return pt.executeQuery();
    }

  /**
  * 删除产品信息
  *
  * */
  public int delete(Connection connection,String id) throws Exception{
      String sql = "delete from dp_product where product_id=?";
      PreparedStatement pstmt=connection.prepareStatement(sql);
      pstmt.setString(1,id);
      return pstmt.executeUpdate();
  }

/**
 * 更新产品信息
* */
  public int update(Connection connection,Product product) throws Exception{
      String sql="update dp_product set product_name=?,manufacturer=?,production_date=?,model=?,purchase_price=?,retail_price=?,quantity=?where product_id=?";
      PreparedStatement pstmt=connection.prepareStatement(sql);
      pstmt.setString(1, product.getProductName());
      pstmt.setString(2, product.getManufacturer());
      java.sql.Date sqlRegistrationDate = new java.sql.Date(product.getProductionDate().getTime());
      pstmt.setDate(3, sqlRegistrationDate);
      pstmt.setString(4, product.getModel());
      pstmt.setDouble(5, product.getPurchasePrice());
      pstmt.setDouble(6, product.getRetailPrice());
      pstmt.setDouble(7, product.getQuantity());
      pstmt.setInt(8, product.getId());
      return pstmt.executeUpdate();
  }

  /**
  * 更新商品库存
  * */
  public boolean updateStock(Connection connection, String productName, int quantity) {
      PreparedStatement preparedStatement = null;
      try {
          String sql = "UPDATE dp_product SET quantity = quantity - ? WHERE product_name = ?";
          preparedStatement = connection.prepareStatement(sql);
          preparedStatement.setInt(1, quantity);
          preparedStatement.setString(2, productName);
          int rowsAffected = preparedStatement.executeUpdate();
          return rowsAffected > 0;
      } catch (Exception e) {
          e.printStackTrace();
          return false;
      } finally {
          try {
              if (preparedStatement != null) {
                  preparedStatement.close();
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
  }




}
