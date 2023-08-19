/*
 * Created by JFormDesigner on Thu Aug 17 11:07:52 CST 2023
 */

package com.views;

import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;

import com.dao.AdminDao;
import com.dao.CustomerUserDao;
import com.models.Admin;
import com.models.Customer;
import com.utils.MysqlUtil;
import com.utils.StringUtil;
import net.miginfocom.swing.*;

/**
 * 管理员登录界面
 */
public class AdminLogin extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private MysqlUtil util = new MysqlUtil();
    private AdminDao adminDao = new AdminDao();

    public AdminLogin(JPanel cardPanel,CardLayout cardLayout) {
        this.cardLayout =   cardLayout;
        this.cardPanel = cardPanel;
        initComponents();
    }
    private void initComponents() {

        JPanel adminMan = new AdminManagerMainView(this.cardLayout,this.cardPanel);
        cardPanel.add(adminMan,"adminMan");

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        title = new JLabel();
        userName = new JLabel();
        scrollPane1 = new JScrollPane();
        adminText = new JTextArea();
        userNameText = new JLabel();
        passwordText = new JPasswordField();
        adminLogin = new JButton();
        exit = new JButton();

        //======== this ========
        setLayout(new MigLayout(
            "filly,hidemode 3,alignx right",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- title ----
        title.setText("    \u7ba1\u7406\u5458\u767b\u9646");
        title.setFont(title.getFont().deriveFont(title.getFont().getStyle() | Font.BOLD, title.getFont().getSize() + 12f));
        add(title, "cell 15 3 4 1");

        //---- userName ----
        userName.setText("\u8d26\u53f7");
        userName.setFont(userName.getFont().deriveFont(userName.getFont().getSize() + 5f));
        add(userName, "cell 12 4");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(adminText);
        }
        add(scrollPane1, "cell 13 4 9 1,wmin 200,hmin 20");

        //---- userNameText ----
        userNameText.setText("\u5bc6\u7801");
        userNameText.setFont(userNameText.getFont().deriveFont(userNameText.getFont().getSize() + 5f));
        add(userNameText, "cell 12 5");

        //---- passwordText ----
        passwordText.setFont(passwordText.getFont().deriveFont(passwordText.getFont().getSize() - 2f));
        add(passwordText, "cell 13 5 9 1,hmin 20");

        //---- adminLogin ----
        adminLogin.setText("\u767b\u9646");
        adminLogin.setFont(adminLogin.getFont().deriveFont(adminLogin.getFont().getSize() + 3f));
        add(adminLogin, "cell 15 6");

        //---- exit ----
        exit.setText("\u9000\u51fa");
        exit.setFont(exit.getFont().deriveFont(exit.getFont().getSize() + 3f));
        add(exit, "cell 19 6");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        /**
        * 管理员登陆事件处理
        *
        * */
        adminLogin.addActionListener((e)->{
            String entreAdminname = adminText.getText();
            String passWord = new String(passwordText.getPassword());
            if (StringUtil.isEmpty(entreAdminname)) {
                JOptionPane.showMessageDialog(null,"用户名不能为空!");
                return;
            }
            if (StringUtil.isEmpty(passWord)) {
                JOptionPane.showMessageDialog(null,"密码不能为空!");
                return;
            }
            Admin admins = new Admin(entreAdminname,passWord);
            Connection connection = null;
            try {
                connection = util.getCon();
                Admin ccurrentAdmin = adminDao.adminLogin(connection,admins);
                if (ccurrentAdmin != null ) {
                    JOptionPane.showMessageDialog(null,"登陆成功!");

                    cardLayout.show(cardPanel,"adminMan");
                }else{
                    JOptionPane.showMessageDialog(null,"用户名或密码错误!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

        exit.addActionListener((e) -> {
           cardLayout.show(cardPanel,"login");
        });

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel title;
    private JLabel userName;
    private JScrollPane scrollPane1;
    private JTextArea adminText;
    private JLabel userNameText;
    private JPasswordField passwordText;
    private JButton adminLogin;
    private JButton exit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
