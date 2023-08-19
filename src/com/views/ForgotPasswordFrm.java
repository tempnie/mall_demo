package com.views;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 2023/8/16
 * Time: 14:35
 * Description: No Description
 */
import javax.swing.*;
import java.awt.*;

public class ForgotPasswordFrm extends JPanel {

    public ForgotPasswordFrm() {
        initComponents();
    }

    private void initComponents() {
        JLabel label = new JLabel("这是找回密码界面。");
        label.setFont(new Font("宋体", Font.PLAIN, 18));

        setLayout(new BorderLayout());
        add(label, BorderLayout.CENTER);
    }
}

