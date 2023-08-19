
package com.views;

import java.awt.*;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.border.*;

import com.dao.CustomerUserDao;
import com.models.Customer;
import com.utils.MysqlUtil;
import net.miginfocom.swing.*;

/**
 * 注册界面
 */
public class RegisterFram extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    public RegisterFram(JPanel cardPanel,CardLayout cardLayout) {
        this.cardLayout =   cardLayout;
        this.cardPanel = cardPanel;
        initComponents();
    }

    private MysqlUtil util = new MysqlUtil();
    private CustomerUserDao cusDao = new CustomerUserDao();

    private void initComponents() {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        this.add(panel1);
        registerText = new JLabel();
        userName = new JLabel();
        userNameText = new JTextArea();
        email = new JLabel();
        emailText = new JTextArea();
        phonenumber = new JLabel();
        phonenumberText = new JTextArea();
        password1 = new JLabel();
        pwdText1 = new JTextArea();
        password2 = new JLabel();
        pwdTxet2 = new JTextArea();
        registerBu = new JButton();
        exitBUtton = new JButton();

        //======== panel1 ========
        {
            panel1.setLayout(new MigLayout(
                "hidemode 3",
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
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- registerText ----
            registerText.setText("  \u6ce8\u518c");
            registerText.setFont(new Font("\u65b9\u6b63\u5c0f\u6807\u5b8b\u7b80\u4f53", Font.BOLD, 19));
            panel1.add(registerText, "cell 9 3");

            //---- userName ----
            userName.setText(" \u7528\u6237\u540d");
            userName.setFont(userName.getFont().deriveFont(userName.getFont().getSize() + 5f));
            panel1.add(userName, "cell 7 5");

            //---- userNameText ----
            userNameText.setBackground(Color.lightGray);
            panel1.add(userNameText, "cell 8 5 9 1,hmin 20");

            //---- email ----
            email.setFont(email.getFont().deriveFont(email.getFont().getSize() + 5f));
            email.setText(" Email");
            panel1.add(email, "cell 7 6");

            //---- emailText ----
            emailText.setBackground(Color.lightGray);
            panel1.add(emailText, "cell 8 6 9 1,hmin 20");

            //---- phonenumber ----
            phonenumber.setFont(phonenumber.getFont().deriveFont(phonenumber.getFont().getSize() + 5f));
            phonenumber.setText("\u7535\u8bdd\u53f7\u7801");
            panel1.add(phonenumber, "cell 7 7");

            //---- phonenumberText ----
            phonenumberText.setBackground(Color.lightGray);
            panel1.add(phonenumberText, "cell 8 7 9 1,hmin 20");

            //---- password1 ----
            password1.setFont(password1.getFont().deriveFont(password1.getFont().getSize() + 5f));
            password1.setText("  \u5bc6\u7801");
            panel1.add(password1, "cell 7 8");

            //---- pwdText1 ----
            pwdText1.setBackground(Color.lightGray);
            panel1.add(pwdText1, "cell 8 8 9 1,hmin 20");

            //---- password2 ----
            password2.setFont(password2.getFont().deriveFont(password2.getFont().getSize() + 5f));
            password2.setText("  \u5bc6\u7801");
            panel1.add(password2, "cell 7 9");

            //---- pwdTxet2 ----
            pwdTxet2.setBackground(Color.lightGray);
            panel1.add(pwdTxet2, "cell 8 9 9 1,height 20:20");

            //---- registerBu ----
            registerBu.setText("\u786e\u5b9a");
            registerBu.setFont(registerBu.getFont().deriveFont(registerBu.getFont().getSize() + 6f));
            panel1.add(registerBu, "cell 9 11");

            //---- exitBUtton ----
            exitBUtton.setText("\u9000\u51fa");
            exitBUtton.setFont(exitBUtton.getFont().deriveFont(exitBUtton.getFont().getSize() + 6f));
            panel1.add(exitBUtton, "cell 12 11");
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        /**
         * 注册事件处理流程
         * @param e
         * */
        registerBu.addActionListener((e)->{
            if (isValidInput()) {
                Customer currentCus = new Customer( userNameText.getText(),phonenumberText.getText(),emailText.getText(),pwdTxet2.getText());
                Connection connection = null;
                try {
                    connection = util.getCon();
                    if ( cusDao.addCutomer(connection,currentCus)) {
                        JOptionPane.showMessageDialog(null,"注册成功!");
                    }else{
                        JOptionPane.showMessageDialog(null,"注册失败!");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }else {
                JOptionPane.showMessageDialog(RegisterFram.this, "请正确填写所有字段。");
            }
        });

        exitBUtton.addActionListener((e -> {
            cardLayout.show(cardPanel,"login");
        }));

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JLabel registerText;
    private JLabel userName;
    private JTextArea userNameText;
    private JLabel email;
    private JTextArea emailText;
    private JLabel phonenumber;
    private JTextArea phonenumberText;
    private JLabel password1;
    private JTextArea pwdText1;
    private JLabel password2;
    private JTextArea pwdTxet2;
    private JButton registerBu;
    private JButton exitBUtton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on


    // 验证邮箱
    private boolean isValidEmail(String email) {
        // 使用正则表达式验证邮箱格式
        String regex = "^[A-Za-z0-9+_.-]+@(.+)\\.com$";
        return email.matches(regex);
    }

    //验证输入是否有效
    private boolean isValidInput() {
        String username = userNameText.getText();
        String phoneNumber = phonenumberText.getText();
        String email = emailText.getText();
        String password1 = new String(pwdText1.getText());
        String password2 = new String(pwdTxet2.getText());
        return !username.isEmpty() && !phoneNumber.isEmpty() && isValidEmail(email) &&
                !password1.isEmpty() && password1.equals(password2);
    }

}
