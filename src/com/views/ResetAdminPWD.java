/*
 * Created by JFormDesigner on Fri Aug 18 16:37:28 CST 2023
 */

package com.views;

import java.awt.*;
import java.sql.Connection;
import javax.swing.*;

import com.dao.AdminDao;
import com.models.Admin;
import com.utils.MysqlUtil;
import net.miginfocom.swing.*;

/**
 * @author lenovo
 */
public class ResetAdminPWD extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private MysqlUtil util = new MysqlUtil();
    private AdminDao admindao =  new AdminDao();
    public ResetAdminPWD( CardLayout cardLayout,JPanel cardPanel) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        pwd1 = new JTextField();
        pwd2 = new JTextField();
        resetJB = new JButton();
        reJB = new JButton();
        label4 = new JLabel();
        name = new JTextField();

        //======== this ========

        //---- label1 ----
        label1.setText("  \u7ba1\u7406\u5458\u5bc6\u7801\u91cd\u7f6e");
        label1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 24));

        //---- label2 ----
        label2.setText("\u65b0\u5bc6\u7801\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 4f));

        //---- label3 ----
        label3.setText("\u65b0\u5bc6\u7801\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 4f));

        //---- resetJB ----
        resetJB.setText("\u786e\u5b9a");
        resetJB.setFont(resetJB.getFont().deriveFont(resetJB.getFont().getSize() + 5f));

        //---- reJB ----
        reJB.setText("\u8fd4\u56de");
        reJB.setFont(reJB.getFont().deriveFont(reJB.getFont().getSize() + 5f));

        //---- label4 ----
        label4.setText("\u7528\u6237\u540d\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 4f));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(367, 367, 367)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pwd2, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(384, 384, 384)
                            .addComponent(resetJB, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                            .addGap(65, 65, 65)
                            .addComponent(reJB, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(406, 406, 406)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(365, 365, 365)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(pwd1, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
                                .addComponent(name, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(504, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(175, 175, 175)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(8, 8, 8)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addComponent(pwd1))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addComponent(pwd2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(resetJB, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(reJB, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(255, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        reJB.addActionListener((e)->{
            cardLayout.show(cardPanel,"adminMan");
        });

        resetJB.addActionListener((e)->{
            String adminName = name.getText();
            String newAdminPassword = pwd1.getText();// 获取新密码的逻辑，可能是从界面上获取
            String confirmPassword = pwd2.getText();

            // 判断密码是否为空
            if (adminName.isEmpty() || newAdminPassword.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(null, "请输入完整信息！");
                return;
            }
            // 判断两次输入的密码是否一致
            if (!newAdminPassword.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(null, "两次输入的密码不一致！");
                return;
            }

            // 判断密码长度是否小于8
            if (newAdminPassword.length() < 8) {
                JOptionPane.showMessageDialog(null, "密码长度不得小于8位！");
                return;
            }
            try {
                Connection connection = util.getCon();
                Admin admin = new Admin(adminName,newAdminPassword);
                int result = admindao.updateAdminPassword(connection,admin);
                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "管理员密码修改成功！");
                    resetValue();
                } else {
                    JOptionPane.showMessageDialog(null, "管理员密码修改失败！");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "管理员密码修改失败！");
            }
        });

    }

    private void resetValue() {
        this.name.setText("");
        this.pwd1.setText("");
        this.pwd2.setText("");
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField pwd1;
    private JTextField pwd2;
    private JButton resetJB;
    private JButton reJB;
    private JLabel label4;
    private JTextField name;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
