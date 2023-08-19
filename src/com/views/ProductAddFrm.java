package com.views;

import com.dao.CustomerUserDao;
import com.dao.ProductDao;
import com.models.Product;
import com.utils.MysqlUtil;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductAddFrm extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private MysqlUtil util = new MysqlUtil();
    private ProductDao proDao = new ProductDao();
    public ProductAddFrm(JPanel cardPanel,CardLayout cardLayout) {
        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        initComponents();
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label11 = new JLabel();
        productName = new JLabel();
        productNameText = new JTextField();
        manufacturer = new JLabel();
        manufacturerText = new JTextField();
        label4 = new JLabel();
        productDate = new JLabel();
        productDateText = new JTextField();
        model = new JLabel();
        textField3 = new JTextField();
        purchasePrice = new JLabel();
        textField4 = new JTextField();
        soldPrice = new JLabel();
        soldPriceText = new JTextField();
        quantiy = new JLabel();
        quantiyText = new JTextField();
        addProB = new JButton();
        returnBUtton = new JButton();

        //======== this ========
        setLayout(new MigLayout(
            "flowy,insets 400 500 400 400,hidemode 3",
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
            "[83,fill]" +
            "[fill]" +
            "[fill]" +
            "[185,fill]" +
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
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label11 ----
        label11.setText("\u5546\u54c1\u4fe1\u606f");
        label11.setFont(label11.getFont().deriveFont(label11.getFont().getSize() + 4f));
        add(label11, "cell 13 6");

        //---- productName ----
        productName.setText("\u5546\u54c1\u540d\u79f0\uff1a");
        productName.setFont(productName.getFont().deriveFont(productName.getFont().getSize() + 5f));
        add(productName, "cell 10 8");
        add(productNameText, "cell 13 8");

        //---- manufacturer ----
        manufacturer.setText("\u751f\u4ea7\u5382\u5546\uff1a");
        manufacturer.setFont(manufacturer.getFont().deriveFont(manufacturer.getFont().getSize() + 5f));
        add(manufacturer, "cell 10 9");
        add(manufacturerText, "cell 13 9,wmin 200");

        //---- label4 ----
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 5f));
        add(label4, "cell 13 9");

        //---- productDate ----
        productDate.setText("\u751f\u4ea7\u65e5\u671f\uff1a");
        productDate.setFont(productDate.getFont().deriveFont(productDate.getFont().getSize() + 5f));
        add(productDate, "cell 10 10");
        add(productDateText, "cell 13 10");

        //---- model ----
        model.setText("\u5546\u54c1\u7c7b\u578b\uff1a");
        model.setFont(model.getFont().deriveFont(model.getFont().getSize() + 5f));
        add(model, "cell 10 11");
        add(textField3, "cell 13 11");

        //---- purchasePrice ----
        purchasePrice.setText("\u8fdb\u8d27\u4ef7\u683c\uff1a");
        purchasePrice.setFont(purchasePrice.getFont().deriveFont(purchasePrice.getFont().getSize() + 5f));
        add(purchasePrice, "cell 10 12");
        add(textField4, "cell 13 12");

        //---- soldPrice ----
        soldPrice.setText("\u96f6\u552e\u4ef7\u683c\uff1a");
        soldPrice.setFont(soldPrice.getFont().deriveFont(soldPrice.getFont().getSize() + 5f));
        add(soldPrice, "cell 10 13");
        add(soldPriceText, "cell 13 13");

        //---- quantiy ----
        quantiy.setText("\u5e93\u5b58\uff1a");
        quantiy.setFont(quantiy.getFont().deriveFont(quantiy.getFont().getSize() + 5f));
        add(quantiy, "cell 10 14");
        add(quantiyText, "cell 13 14");

        //---- addProB ----
        addProB.setText("\u6dfb\u52a0");
        addProB.setFont(addProB.getFont().deriveFont(addProB.getFont().getStyle() | Font.BOLD, addProB.getFont().getSize() + 3f));
        add(addProB, "cell 10 15");

        //---- returnBUtton ----
        returnBUtton.setText("\u8fd4\u56de");
        returnBUtton.setFont(returnBUtton.getFont().deriveFont(returnBUtton.getFont().getStyle() | Font.BOLD, returnBUtton.getFont().getSize() + 4f));
        add(returnBUtton, "cell 13 15,alignx leading,growx 0,width 40");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

    /**
    * 返回界面处理
    * */
        returnBUtton.addActionListener((e)->{
            cardLayout.show(cardPanel,"adminMan");
        });
      /**
       * 添加商品事件处理
       * @param e
      * */
        addProB.addActionListener((e)->{
              if (isvalidInput()) {
                  String productDateStr = productDateText.getText();
                  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                  try {
                      Date productdatecus = sdf.parse(productDateStr);
                      Connection connection = null;
                      Product product = new Product(productNameText.getText(),manufacturerText.getText(), productdatecus, textField3.getText(),Double.parseDouble( textField4.getText()),Double.parseDouble(soldPriceText.getText()),Integer.parseInt(quantiyText.getText()));
                      connection = util.getCon();
                      if (proDao.addProduct(connection,product)){
                          JOptionPane.showMessageDialog(null,"商品添加成功!");
                      }else{
                          JOptionPane.showMessageDialog(null,"商品添加失败!");
                      }
                  } catch (ParseException ex) {
                      ex.printStackTrace();
                  } catch (Exception ex) {
                      ex.printStackTrace();
                  }

              }
        });


    }
    private boolean isvalidInput() {
        String productName = productNameText.getText();
        String manufacturer = manufacturerText.getText();
        String productDate = productDateText.getText();
        String model = textField3.getText();
        String purchasePrice = textField4.getText();
        String soldPrice = soldPriceText.getText();
        String quantity = quantiyText.getText();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date productdate = sdf.parse(productDate);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "请输入有效的日期，格式为 yyyy-MM-dd", "输入错误", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (productName.isEmpty() || manufacturer.isEmpty() || productDate.isEmpty() ||
                model.isEmpty() || purchasePrice.isEmpty() || soldPrice.isEmpty() ||
                quantity.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请填写所有必填项", "输入错误", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            double purchasePriceValue = Double.parseDouble(purchasePrice);
            double soldPriceValue = Double.parseDouble(soldPrice);
            int quantityValue = Integer.parseInt(quantity);

            if (purchasePriceValue <= 0 || soldPriceValue <= 0 || quantityValue <= 0) {
                JOptionPane.showMessageDialog(this, "价格和库存数量必须大于零", "输入错误", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "请输入有效的数字", "输入错误", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label11;
    private JLabel productName;
    private JTextField productNameText;
    private JLabel manufacturer;
    private JTextField manufacturerText;
    private JLabel label4;
    private JLabel productDate;
    private JTextField productDateText;
    private JLabel model;
    private JTextField textField3;
    private JLabel purchasePrice;
    private JTextField textField4;
    private JLabel soldPrice;
    private JTextField soldPriceText;
    private JLabel quantiy;
    private JTextField quantiyText;
    private JButton addProB;
    private JButton returnBUtton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
