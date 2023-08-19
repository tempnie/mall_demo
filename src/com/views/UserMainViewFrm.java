/*
 * Created by JFormDesigner on Fri Aug 18 17:32:14 CST 2023
 */

package com.views;

import java.awt.*;
import java.awt.event.*;
import javax.rmi.CORBA.Util;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import com.dao.CustomerUserDao;
import com.dao.ProductCarDao;
import com.dao.ProductDao;
import com.models.Customer;
import com.models.Product;
import com.models.ShopCar;
import com.utils.MysqlUtil;
import com.utils.StringUtil;
import net.miginfocom.swing.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

/**
 * 用户商城界面
 */
public class UserMainViewFrm extends JPanel {
    private  Customer customer;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private MysqlUtil util = new MysqlUtil();
    private ProductCarDao productCardao =  new ProductCarDao();
    private  ProductDao productd = new ProductDao();
    private CustomerUserDao cusDao = new CustomerUserDao();

    public UserMainViewFrm(){

    }
    public UserMainViewFrm(Customer customer,CardLayout cardLayout,JPanel cardPanel) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        this.customer = customer;
        initComponents();
        this.fillTablePro(new Product());
        this.fillTableCar();
    }

    /**
     * 点击选择事件
    * */
    private void productTabelMousePressed(MouseEvent e) {
       int row = this.productTabel.getSelectedRow();
       this.product.setText((String) productTabel.getValueAt(row,0));
       this.price.setText(Double.toString((Double)productTabel.getValueAt(row,4)));

    }

    private void carTableMousePressed(MouseEvent e) {
        int row = carTable.getSelectedRow();
        this.carAmoutUpadte.setText(Integer.toString((Integer)carTable.getValueAt(row,2)));
        this.textField1.setText(Integer.toString((Integer)carTable.getValueAt(row,2)));
    }

    /**
    * 退出
    * */
    private void exut(ActionEvent e) {
        cardLayout.show(cardPanel,"login");
    }
   /**
    * 删除事件处理
   * */
    private void deleteBU(ActionEvent e) {
        int row = carTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "请选择要删除的购物车记录！");
            return;
        }
        String productName = (String) carTable.getValueAt(row, 0);
        int result = JOptionPane.showConfirmDialog(null, "确认要删除所选购物车记录吗？", "确认删除", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            try {
                Connection connection = util.getCon();
                if (productCardao.deleteCartItem(connection, customer.getId(), productName)) {
                    JOptionPane.showMessageDialog(null, "购物车记录删除成功！");

                    // 增加库存数量
                    int deletedQuantity = - (int) carTable.getValueAt(row, 2);
                    updateDatabaseStockOnDelete(productName, deletedQuantity);

                    fillTableCar();
                    fillTablePro(new Product());
                } else {
                    JOptionPane.showMessageDialog(null, "购物车记录删除失败！");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    /**
    * 改变购物车内商品的数量
    * */
    private void changeBu(ActionEvent e) {
        int row = carTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "请选择要修改数量的购物车记录！");
            return;
        }

        String productName = (String) carTable.getValueAt(row, 0);
        int newQuantity;
        try {
            newQuantity = Integer.parseInt(carAmoutUpadte.getText());
            if (newQuantity <= 0) {
                JOptionPane.showMessageDialog(null, "请输入有效商品数量！");
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "请输入有效商品数量！");
            return;
        }

        try {
            Connection connection = util.getCon();
            if (productCardao.updateCartItemQuantity(connection, customer.getId(), productName, newQuantity)) {
                JOptionPane.showMessageDialog(null, "购物车记录数量修改成功！");
                updateDatabaseStock(productName, newQuantity - Integer.parseInt(this.textField1.getText())); // 更新库存数量
                fillTableCar();
                fillTablePro(new Product());
            } else {
                JOptionPane.showMessageDialog(null, "购物车记录数量修改失败！");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void payJu(ActionEvent e) {
        int result = JOptionPane.showConfirmDialog(null, "确认支付？", "确认支付", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            try {
                double totalPayment = calculateTotalPayment((DefaultTableModel) carTable.getModel());

                // 在数据库中更新用户的支付金额
                Connection connection = util.getCon();
                cusDao.updateTotalPayment(connection,this.customer.getId(),customer.getTotal_costmoney() + totalPayment);
                productCardao.clearCartItems(connection, this.customer.getId());
                JOptionPane.showMessageDialog(null, "支付成功！");
                this.fillTableCar();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "支付失败！");
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        productTabel = new JTable();
        label1 = new JLabel();
        product = new JTextField();
        label2 = new JLabel();
        price = new JTextField();
        label3 = new JLabel();
        amout = new JTextField();
        addCar = new JButton();
        scrollPane2 = new JScrollPane();
        carTable = new JTable();
        button2 = new JButton();
        label4 = new JLabel();
        carAmoutUpadte = new JTextField();
        changeBu = new JButton();
        deleteBU = new JButton();
        exutBUtton = new JButton();
        label5 = new JLabel();
        textField1 = new JTextField();
        payJu = new JButton();

        //======== this ========

        //======== scrollPane1 ========
        {
            scrollPane1.setBorder(new TitledBorder("\u6311\u9009\u5546\u54c1"));

            //---- productTabel ----
            productTabel.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "\u5546\u54c1", "\u751f\u4ea7\u5382\u5546", "\u751f\u4ea7\u65e5\u671f", "\u4ea7\u54c1\u7c7b\u578b", "\u552e\u4ef7", "\u5e93\u5b58"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            productTabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    productTabelMousePressed(e);
                }
            });
            scrollPane1.setViewportView(productTabel);
        }

        //---- label1 ----
        label1.setText("\u5546\u54c1\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));

        //---- product ----
        product.setEditable(false);

        //---- label2 ----
        label2.setText("\u4ef7\u683c\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));

        //---- price ----
        price.setEditable(false);

        //---- label3 ----
        label3.setText("\u6570\u91cf\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));

        //---- addCar ----
        addCar.setText("\u6dfb\u52a0\u8d2d\u7269\u8f66");

        //======== scrollPane2 ========
        {
            scrollPane2.setBorder(new TitledBorder("\u8d2d\u7269\u8f66"));

            //---- carTable ----
            carTable.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null},
                    {null, null, null},
                },
                new String[] {
                    "\u5546\u54c1\u540d\u79f0", "\u4ef7\u683c", "\u6570\u91cf"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    true, false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            carTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    carTableMousePressed(e);
                }
            });
            scrollPane2.setViewportView(carTable);
        }

        //---- button2 ----
        button2.setText("\u5220\u9664\u9009\u62e9\u5546\u54c1");

        //---- label4 ----
        label4.setText("\u8d2d\u7269\u8f66\u5546\u54c1\u6570\u91cf\u4fee\u6539\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 5f));

        //---- changeBu ----
        changeBu.setText("\u4fee\u6539");
        changeBu.addActionListener(e -> changeBu(e));

        //---- deleteBU ----
        deleteBU.setText("\u5220\u9664");
        deleteBU.addActionListener(e -> deleteBU(e));

        //---- exutBUtton ----
        exutBUtton.setText("\u9000\u51fa");
        exutBUtton.addActionListener(e -> exut(e));

        //---- label5 ----
        label5.setText("\u539f\u672c\u6570\u91cf\uff1a");

        //---- textField1 ----
        textField1.setEditable(false);

        //---- payJu ----
        payJu.setText(" \u4ed8\u6b3e");
        payJu.addActionListener(e -> payJu(e));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 545, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(label2)
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label3))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(product, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(amout, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(price, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
                                .addComponent(addCar, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 529, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(176, 176, 176)
                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(payJu, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup()
                                    .addComponent(deleteBU, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(190, 190, 190)
                                                .addComponent(exutBUtton, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(label4)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(carAmoutUpadte, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(label5)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                                        .addComponent(changeBu, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15))))))
                    .addContainerGap(119, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label1)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(product, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label4)
                                    .addComponent(changeBu)
                                    .addComponent(carAmoutUpadte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label5)
                                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(label2)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deleteBU)))
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label3)
                                        .addComponent(amout, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(addCar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(37, 37, 37)
                                    .addComponent(payJu, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))))
                        .addComponent(exutBUtton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 34, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        addCar.addActionListener((e)->{
            int userid = customer.getId();
            String productname = product.getText();
            if (StringUtil.isEmpty(product.getText()) || StringUtil.isEmpty(price.getText())){
                JOptionPane.showMessageDialog(null,"请选择商品！");
                return;
            }
            if (StringUtil.isEmpty(amout.getText())) {
                JOptionPane.showMessageDialog(null,"请输入商品数量！");
                return;
            }
            double Price = Double.parseDouble(price.getText());
            System.out.println(Price);
            int proAmout = Integer.parseInt(amout.getText());
            if ( proAmout <= 0 ) {
                JOptionPane.showMessageDialog(null,"请输入有效商品数量！");
                return;
            }
            Connection connection = null;
            ShopCar carItem = new ShopCar(userid,productname,Price,proAmout);
            try {
                connection = util.getCon();
                if ( productCardao.addCar(connection,carItem)) {
                    JOptionPane.showMessageDialog(null,"购物车添加成功!");
                    this.fillTableCar();
                    this.updateDatabaseStock(productname,proAmout); //购物车库存
                    this.fillTablePro(new Product());
                } else{
                    JOptionPane.showMessageDialog(null,"购物车添加失败!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });



    }

    private  void fillTablePro(Product product) {
        DefaultTableModel productT = (DefaultTableModel) productTabel.getModel();
        productT.setRowCount(0);
        Connection con = null;
        try {
            con = util.getCon();
            ResultSet rs = productd.listProduct(con,product);
            while( rs.next() ){
                Vector v = new Vector();
                v.add(rs.getString("product_name"));
                v.add(rs.getString("manufacturer"));
                v.add(rs.getDate("production_date"));
                v.add(rs.getString("model"));
                v.add(rs.getDouble("retail_price"));
                v.add(rs.getInt("quantity"));
                productT.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillTableCar() {
        DefaultTableModel carTableModel = (DefaultTableModel) carTable.getModel();
        carTableModel.setRowCount(0);
        Connection con = null;
        try {
            con = util.getCon();
            List<ShopCar> cartItems = productCardao.getCartItems (con,customer.getId());
            for (ShopCar cartItem : cartItems) {
                Vector<Object> rowData = new Vector<>();
                rowData.add(cartItem.getProduct_name());
                rowData.add(cartItem.getPrice());
                rowData.add(cartItem.getAmout());
                carTableModel.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 更新数据库中的库存数量
    private void updateDatabaseStock(String productName, int quantity) {
        try {
            Connection connection = util.getCon();
            productd.updateStock(connection, productName, quantity);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    // 更新删除购物车记录后的库存数量
    private void updateDatabaseStockOnDelete(String productName, int deletedQuantity) {
        try {
            Connection connection = util.getCon();
            productd.updateStock(connection, productName, deletedQuantity);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private double calculateTotalPayment(DefaultTableModel cartTableModel) {
        double totalPayment = 0;
        for (int i = 0; i < cartTableModel.getRowCount(); i++) {
            double price = (Double) cartTableModel.getValueAt(i, 1);
            int quantity = (Integer) cartTableModel.getValueAt(i, 2);
            totalPayment += price * quantity;
        }
        return totalPayment;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable productTabel;
    private JLabel label1;
    private JTextField product;
    private JLabel label2;
    private JTextField price;
    private JLabel label3;
    private JTextField amout;
    private JButton addCar;
    private JScrollPane scrollPane2;
    private JTable carTable;
    private JButton button2;
    private JLabel label4;
    private JTextField carAmoutUpadte;
    private JButton changeBu;
    private JButton deleteBU;
    private JButton exutBUtton;
    private JLabel label5;
    private JTextField textField1;
    private JButton payJu;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
