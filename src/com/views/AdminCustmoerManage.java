/*
 * Created by JFormDesigner on Fri Aug 18 09:37:13 CST 2023
 */

package com.views;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import com.dao.CustomerUserDao;
import com.dao.ProductDao;
import com.models.Customer;
import com.models.Product;
import com.models.user_type;
import com.utils.MysqlUtil;
import com.utils.StringUtil;
import net.miginfocom.swing.*;

/**
 * 用户管理界面
 */
public class AdminCustmoerManage extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private MysqlUtil util = new MysqlUtil();
    private CustomerUserDao cusDao = new CustomerUserDao();
    public AdminCustmoerManage(CardLayout cardLayout,JPanel cardPanel) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        initComponents();
        this.fillTable(new Customer());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane2 = new JScrollPane();
        customerTable = new JTable();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        emailText = new JTextField();
        searachBUtton = new JButton();
        usernameText = new JLabel();
        userName = new JTextField();
        textField3 = new JTextField();
        reButton = new JButton();
        deleBu = new JButton();

        //======== this ========

        //======== scrollPane2 ========
        {

            //---- customerTable ----
            customerTable.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null, null},
                },
                new String[] {
                    "\u7f16\u53f7", "\u7528\u6237\u540d", "\u7528\u6237\u7ea7\u522b", "\u7535\u8bdd\u53f7\u7801", "\u90ae\u7bb1", "\u5df2\u6d88\u8d39\u91d1\u989d", "\u6ce8\u518c\u65e5\u671f"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false, true, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            {
                TableColumnModel cm = customerTable.getColumnModel();
                cm.getColumn(0).setMinWidth(40);
                cm.getColumn(0).setMaxWidth(35);
                cm.getColumn(0).setPreferredWidth(125);
            }
            customerTable.setFont(customerTable.getFont().deriveFont(customerTable.getFont().getStyle() | Font.BOLD));
            scrollPane2.setViewportView(customerTable);
        }

        //---- label7 ----
        label7.setText("\u7535\u8bdd\u53f7\u7801");

        //---- label8 ----
        label8.setText("   \u90ae\u7bb1");

        //---- searachBUtton ----
        searachBUtton.setText("\u67e5\u8be2");

        //---- usernameText ----
        usernameText.setText("\u7528\u6237\u540d");

        //---- reButton ----
        reButton.setText("\u8fd4\u56de");

        //---- deleBu ----
        deleBu.setText("\u5220\u9664");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 973, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(label7)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label6)
                                    .addGap(2, 2, 2)
                                    .addComponent(usernameText))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(label8)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(userName, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                .addComponent(emailText)
                                .addComponent(textField3, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(searachBUtton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(deleBu))
                        .addComponent(reButton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup()
                            .addComponent(userName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameText)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label7)
                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(label8)
                        .addComponent(emailText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(searachBUtton)
                        .addComponent(deleBu))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(reButton)
                    .addContainerGap(662, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    /**
    * 搜索用用户事件处理
    * */
        searachBUtton.addActionListener((e)->{
            String userNameValue = userName.getText();
            String phoneNUmber = textField3.getText();
            String emailValue = emailText.getText();
            Customer customer = new Customer(userNameValue,phoneNUmber,emailValue);
            customer.setUserName(userNameValue);
            this.fillTable(customer);

        });

        /**
        * 删除用户事件处理
        * */
        deleBu.addActionListener((ex)->{
            int row = customerTable.getSelectedRow();
            String userName = (String) customerTable.getValueAt(row,1);
            if (StringUtil.isEmpty(userName)) {
                JOptionPane.showMessageDialog(null, "请选择要删除的客户");
                return;
            }
            int flag = JOptionPane.showConfirmDialog(null, "删除后无法恢复，确定要删除该记录吗？");
            if (flag == 0) {
                Connection connection = null;
                try {
                    connection = util.getCon();
                    int deleteResult = cusDao.delete(connection, userName);
                    if (deleteResult > 0) {
                        JOptionPane.showMessageDialog(null, "删除成功！");
                        this.resetValue();
                        this.fillTable(new Customer());
                    } else {
                        JOptionPane.showMessageDialog(null, "删除失败！");
                    }
                } catch (Exception exc) {
                    exc.printStackTrace();
                    JOptionPane.showMessageDialog(null, "删除失败！");
                } finally {
                    // 关闭数据库连接等操作
                    try {
                        if (connection != null) {
                            connection.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        reButton.addActionListener((e)->{
            cardLayout.show(cardPanel,"adminMan");
        });
    }


    private void fillTable(Customer customer){
        DefaultTableModel dtm = (DefaultTableModel) customerTable.getModel();
        dtm.setRowCount(0);
        Connection con =  null;
        try {
            con = util.getCon();
            ResultSet rs = cusDao.list(con,customer);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getInt("id"));
                v.add(rs.getString("userName"));
                v.add(rs.getString("user_type"));
                v.add(rs.getString("phoneNumber"));
                v.add(rs.getString("email"));
                v.add(rs.getFloat("total_costmoney"));
                v.add(rs.getTimestamp("registrationDate"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private  void resetValue(){
        this.userName.setText("");
        this.textField3.setText("");
        this.emailText.setText("");
    }





    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane2;
    private JTable customerTable;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JTextField emailText;
    private JButton searachBUtton;
    private JLabel usernameText;
    private JTextField userName;
    private JTextField textField3;
    private JButton reButton;
    private JButton deleBu;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
