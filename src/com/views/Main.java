package com.views;

import com.dao.CustomerUserDao;
import com.models.Customer;
import com.utils.MysqlUtil;
import com.utils.StringUtil;
import sun.security.util.Password;

import javax.rmi.CORBA.Util;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;

public class Main extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private MysqlUtil util = new MysqlUtil();
    private CustomerUserDao cusDao = new CustomerUserDao();
    JPanel userMainViewFrm = new UserMainViewFrm();


    public Main() {
        initCom();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(600, 400);
    }

    private void initCom() {
        setTitle("MALL");
        setBackground(new Color(240, 240, 240));

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        JPanel loginPanel = createLoginPanel();
        cardPanel.add(loginPanel, "login");




        JPanel registerPanel = new RegisterFram(cardPanel,cardLayout);
        cardPanel.add(registerPanel, "register");

        JPanel forgotPasswordPanel = new ForgotPasswordFrm();
        cardPanel.add(forgotPasswordPanel, "forgotPassword");

        JPanel adminLogin = new AdminLogin(cardPanel,cardLayout);
        cardPanel.add(adminLogin,"adminLogin");

        add(cardPanel);

        pack();
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setBackground(Color.WHITE);

        JLabel labe3 = new JLabel("欢迎来到商城");
        labe3.setFont(new Font("微软雅黑", Font.BOLD, 35));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 20, 10);
        panel.add(labe3, gbc);

        ImageIcon userIcon = new ImageIcon("./images/user.png");
        Image scaledUserImage = userIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        JLabel userLabel = new JLabel(new ImageIcon(scaledUserImage));
        JLabel label1 = new JLabel("账号:");

        JTextField username = new JTextField("", 20);
        username.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); // Add padding
        username.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        userPanel.add(userLabel);
        userPanel.add(label1);
        userPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Add spacing
        userPanel.add(username);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 0, 10, 5);
        panel.add(userPanel, gbc);

        ImageIcon pswIcon = new ImageIcon("./images/password.png");
        Image scaledPWDImage = pswIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        JLabel pswLabel = new JLabel(new ImageIcon(scaledPWDImage));
        JLabel label2 = new JLabel("密码:");

        JPasswordField pwd = new JPasswordField("", 20);
        pwd.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); // Add padding
        pwd.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JPanel pswPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        pswPanel.add(pswLabel);
        pswPanel.add(label2);
        pswPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Add spacing
        pswPanel.add(pwd);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 0, 10, 5);
        panel.add(pswPanel, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.setBackground(Color.white);
        JButton login = new JButton("登陆");
        JButton register = new JButton("注册");
        JButton resetPWD = new JButton("忘记密码");
        JButton adminLogin =  new JButton("管理员登陆");


        buttonPanel.add(login);
        buttonPanel.add(register);
        buttonPanel.add(resetPWD);
        buttonPanel.add(adminLogin);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 10, 10);
        panel.add(buttonPanel, gbc);

        register.addActionListener((e) -> {
            cardLayout.show(cardPanel, "register");
        });

        resetPWD.addActionListener((e) -> {
            cardLayout.show(cardPanel, "forgotPassword");
        });
        /**
         * 用户登录处理
         * @param e
         * */
        login.addActionListener((e) -> {
            String entreUsername = username.getText();
            String password = new String(pwd.getPassword());
            if (StringUtil.isEmpty(entreUsername)) {
                JOptionPane.showMessageDialog(null,"用户名不能为空!");
                return;
            }
            if (StringUtil.isEmpty(password)) {
                JOptionPane.showMessageDialog(null,"密码不能为空!");
                return;
            }
            Customer cus = new Customer(entreUsername,password);
            Connection connection = null;
            try {
                connection = util.getCon();
                Customer ccurrentCus = cusDao.login(connection,cus);
                if (ccurrentCus != null ) {
                    JOptionPane.showMessageDialog(null,"登录成功!");
                    this.userMainViewFrm = new UserMainViewFrm(ccurrentCus,cardLayout,cardPanel);
                    cardPanel.add(this.userMainViewFrm, "UserMainViewFrm");
                    cardLayout.show(cardPanel,"UserMainViewFrm");
                }else{
                    JOptionPane.showMessageDialog(null,"用户名或密码错误!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

        adminLogin.addActionListener((e) ->{
            cardLayout.show(cardPanel,"adminLogin");
        });


        return panel;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new Main().setVisible(true));
    }
}
