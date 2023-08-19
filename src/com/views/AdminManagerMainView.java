/*
 * Created by JFormDesigner on Thu Aug 17 15:49:46 CST 2023
 */

package com.views;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import net.miginfocom.swing.*;




/**
 * 管理员后台界面
 */
public class AdminManagerMainView extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;


    public AdminManagerMainView(CardLayout cardLayout,JPanel cardPanel) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        initComponents();

    }

    private void exit(ActionEvent e) {
       cardLayout.show(cardPanel,"login");
    }


    private void initComponents() {

        //商品添加
        JPanel addProduct = new ProductAddFrm(cardPanel,cardLayout);
        cardPanel.add(addProduct, "addProduct");

        //商品维护
        JPanel adminProductMan = new AdminProductManage(cardLayout,cardPanel);
        cardPanel.add(adminProductMan,"adminProductMan");

        //用户维护
        JPanel adminCustomerMan = new AdminCustmoerManage(cardLayout,cardPanel);
        cardPanel.add(adminCustomerMan,"adminCustomerMan");

        JPanel resetAdmin = new ResetAdminPWD(cardLayout,cardPanel);
        cardPanel.add(resetAdmin,"resetAdmin");


        // 调整菜单栏的布局
        menuBar1 = new JMenuBar();
        menuBar1.add(Box.createHorizontalGlue()); // 在菜单栏中添加一个占位组件，使其右对齐
        add(menuBar1, BorderLayout.NORTH);

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        dataManage = new JMenu();
        product = new JMenu();
        productMana = new JMenuItem();
        productAdd = new JMenuItem();
        cutomerMana = new JMenu();
        custoInfoMan = new JMenuItem();
        custoPWD = new JMenuItem();
        adminPWDRreset = new JMenuItem();
        exit = new JMenuItem();

        //======== this ========
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[611,fill]" +
            "[727,fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[0]" +
            "[0]" +
            "[0]" +
            "[0]" +
            "[497]" +
            "[]" +
            "[]"));

        //======== menuBar1 ========
        {

            //======== dataManage ========
            {
                dataManage.setText("\u6570\u636e\u7ba1\u7406");
                dataManage.setIcon(new ImageIcon(getClass().getResource("/resource/icons/dataP.png")));

                //======== product ========
                {
                    product.setText("\u5546\u54c1\u7ba1\u7406");
                    product.setIcon(new ImageIcon(getClass().getResource("/resource/icons/productMan.png")));

                    //---- productMana ----
                    productMana.setText("\u5546\u54c1\u4fe1\u606f\u7ef4\u62a4");
                    productMana.setIcon(new ImageIcon(getClass().getResource("/resource/icons/productMan.png")));
                    product.add(productMana);

                    //---- productAdd ----
                    productAdd.setText("\u5546\u54c1\u4fe1\u606f\u6dfb\u52a0");
                    productAdd.setIcon(new ImageIcon(getClass().getResource("/resource/icons/productAdd.png")));
                    product.add(productAdd);
                }
                dataManage.add(product);

                //======== cutomerMana ========
                {
                    cutomerMana.setText("\u5ba2\u6237\u7ba1\u7406");
                    cutomerMana.setIcon(new ImageIcon(getClass().getResource("/resource/icons/custoInfo.png")));

                    //---- custoInfoMan ----
                    custoInfoMan.setText("\u5ba2\u6237\u4fe1\u606f\u7ef4\u62a4");
                    custoInfoMan.setIcon(new ImageIcon(getClass().getResource("/resource/icons/custoMan.png")));
                    cutomerMana.add(custoInfoMan);

                    //---- custoPWD ----
                    custoPWD.setText("\u5ba2\u6237\u5bc6\u7801\u7ba1\u7406");
                    custoPWD.setIcon(new ImageIcon(getClass().getResource("/resource/icons/custoPWD.png")));
                    cutomerMana.add(custoPWD);
                }
                dataManage.add(cutomerMana);
            }
            menuBar1.add(dataManage);

            //---- adminPWDRreset ----
            adminPWDRreset.setText("\u7ba1\u7406\u5458\u5bc6\u7801\u7ba1\u7406");
            adminPWDRreset.setIcon(new ImageIcon(getClass().getResource("/resource/icons/adminReset.png")));
            menuBar1.add(adminPWDRreset);

            //---- exit ----
            exit.setText("\u9000\u51fa");
            exit.setIcon(new ImageIcon(getClass().getResource("/resource/icons/exit.png")));
            exit.addActionListener(e -> exit(e));
            menuBar1.add(exit);
        }
        add(menuBar1, "cell 0 1");


        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        /**
        * 返回原始登陆界面
        *
        * */
        exit.addActionListener((e)->{
               cardLayout.show(cardPanel,"login");
        });

        productAdd.addActionListener((e) -> {
            cardLayout.show(cardPanel,"addProduct");
        });

        productMana.addActionListener((e)->{
            cardLayout.show(cardPanel,"adminProductMan");
        });

        custoInfoMan.addActionListener((e)->{
            cardLayout.show(cardPanel,"adminCustomerMan");
        });

        adminPWDRreset.addActionListener((e)->{
            cardLayout.show(cardPanel,"resetAdmin");
        });

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenu dataManage;
    private JMenu product;
    private JMenuItem productMana;
    private JMenuItem productAdd;
    private JMenu cutomerMana;
    private JMenuItem custoInfoMan;
    private JMenuItem custoPWD;
    private JMenuItem adminPWDRreset;
    private JMenuItem exit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

}
