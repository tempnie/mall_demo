/*
 * Created by JFormDesigner on Fri Aug 18 07:55:32 CST 2023
 */

package com.views;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import com.dao.ProductDao;
import com.models.Product;
import com.utils.MysqlUtil;
import com.utils.StringUtil;
import net.miginfocom.swing.*;

/**
 * 商品数据维护页面
 */
public class AdminProductManage extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    MysqlUtil dbutil = new MysqlUtil();
    ProductDao productDao = new ProductDao();
    public AdminProductManage(CardLayout cardLayout,JPanel cardPanel) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        initComponents();
        this.fillTable(new Product());
    }

    /**
    * 表格行点击事件处理
    * */
    private void productTableMousePressed(MouseEvent event) {
        int row = productTable.getSelectedRow();
        idText.setText(Integer.toString((Integer)productTable.getValueAt(row,0)));
        productName.setText((String)productTable.getValueAt(row,1));
        manufacturerName.setText((String) productTable.getValueAt(row,2));
        java.sql.Date dateValue = (java.sql.Date) productTable.getValueAt(row, 3);
        if (dateValue != null) {
            date.setText(dateValue.toString()); // 转换为合适的日期格式
        } else {
            date.setText("");
        }
        model.setText((String) productTable.getValueAt(row,4));
        purPrice.setText( Double.toString((Double)(productTable.getValueAt(row,5))));
        soldPrice.setText(Double.toString((Double)(productTable.getValueAt(row,6))));
        quantiText.setText(Integer.toString((Integer) productTable.getValueAt(row,7)));

    }

    MysqlUtil util = new MysqlUtil();
    ProductDao proDao = new ProductDao();
    private void initComponents() {
        
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        productTable = new JTable();
        panel1 = new JPanel();
        label3 = new JLabel();
        idText = new JTextField();
        label4 = new JLabel();
        productName = new JTextField();
        label5 = new JLabel();
        manufacturerName = new JTextField();
        label9 = new JLabel();
        date = new JTextField();
        label10 = new JLabel();
        model = new JTextField();
        label11 = new JLabel();
        purPrice = new JTextField();
        label12 = new JLabel();
        soldPrice = new JTextField();
        label13 = new JLabel();
        quantiText = new JTextField();
        deleteInfo = new JButton();
        updateBu = new JButton();
        reBU = new JButton();

        //---- label1 ----
        label1.setText("text");

        //======== this ========

        //======== scrollPane1 ========
        {

            //---- productTable ----
            productTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "\u7f16\u53f7", "\u5546\u54c1\u540d\u79f0", "\u751f\u4ea7\u5382\u5546", "\u751f\u4ea7\u65e5\u671f", "\u4ea7\u54c1\u7c7b\u578b", "\u8fdb\u8d27\u4ef7\u683c", "\u96f6\u552e\u4ef7\u683c", "\u5e93\u5b58"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false, true, false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            {
                TableColumnModel cm = productTable.getColumnModel();
                cm.getColumn(0).setMinWidth(40);
                cm.getColumn(0).setMaxWidth(35);
                cm.getColumn(0).setPreferredWidth(125);
            }
            productTable.setFont(productTable.getFont().deriveFont(productTable.getFont().getStyle() | Font.BOLD));
            productTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    productTableMousePressed(e);
                }
            });
            scrollPane1.setViewportView(productTable);
        }

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("\u8868\u5355"));

            //---- label3 ----
            label3.setText("\u7f16\u53f7\uff1a");

            //---- idText ----
            idText.setEditable(false);

            //---- label4 ----
            label4.setText("\u5546\u54c1\u540d\u79f0\uff1a");

            //---- label5 ----
            label5.setText("\u751f\u4ea7\u5382\u5546\uff1a");

            //---- label9 ----
            label9.setText("\u751f\u4ea7\u65e5\u671f\uff1a");

            //---- label10 ----
            label10.setText("\u7c7b\u578b\uff1a");

            //---- label11 ----
            label11.setText("\u8fdb\u8d27\u4ef7\u683c\uff1a");

            //---- label12 ----
            label12.setText("\u96f6\u552e\u4ef7\u683c\uff1a");

            //---- label13 ----
            label13.setText("\u5e93\u5b58\uff1a");

            //---- deleteInfo ----
            deleteInfo.setText("\u5220\u9664");

            //---- updateBu ----
            updateBu.setText("\u4fee\u6539");

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idText, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(productName, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(label5)
                                    .addComponent(label9))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(manufacturerName, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(date, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label10)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(model))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(label11)
                                    .addComponent(label12))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(purPrice)
                                    .addComponent(soldPrice)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label13)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(updateBu)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                        .addComponent(deleteInfo, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11))
                                    .addComponent(quantiText))))
                        .addContainerGap(76, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(idText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(productName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5)
                            .addComponent(manufacturerName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label9)
                            .addComponent(date, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label10)
                            .addComponent(model, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label11)
                            .addComponent(purPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label12)
                            .addComponent(soldPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label13)
                            .addComponent(quantiText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(deleteInfo)
                            .addComponent(updateBu))
                        .addContainerGap(16, Short.MAX_VALUE))
            );
        }

        //---- reBU ----
        reBU.setText("\u8fd4\u56de");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 973, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(reBU))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(reBU)
                            .addGap(0, 469, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
       reBU.addActionListener((e)->{
           cardLayout.show(cardPanel,"adminMan");
       });

       /*
       * 商品修改处理
       * */
       updateBu.addActionListener((e)->{
           String id = this.idText.getText();
           if (StringUtil.isEmpty(id)) {
               JOptionPane.showMessageDialog(null, "请选择要修改的记录");
               return;
           }
           if (StringUtil.isEmpty(id)) {
               JOptionPane.showMessageDialog(null, "请选择要修改的记录");
               return;
           }

           id = this.idText.getText();
           String productname = productName.getText();
           String manufacturername = manufacturerName.getText();
           String productTime = date.getText();
           String modeL = model.getText();
           String purprice = purPrice.getText();
           String soldprice = soldPrice.getText();
           String quantitext = quantiText.getText();

           if (StringUtil.isEmpty(productname)) {
               JOptionPane.showMessageDialog(null, "请输入产品名称");
               return;
           }
           if (StringUtil.isEmpty(manufacturername)) {
               JOptionPane.showMessageDialog(null, "请输入制造商名称");
               return;
           }
           if (StringUtil.isEmpty(productTime)) {
               JOptionPane.showMessageDialog(null, "请选择产品日期");
               return;
           }
           if (StringUtil.isEmpty(modeL)) {
               JOptionPane.showMessageDialog(null, "请输入型号");
               return;
           }
           if (StringUtil.isEmpty(purprice)) {
               JOptionPane.showMessageDialog(null, "请输入进货价格");
               return;
           }
           if (StringUtil.isEmpty(soldprice)) {
               JOptionPane.showMessageDialog(null, "请输入销售价格");
               return;
           }
           if (StringUtil.isEmpty(quantitext)) {
               JOptionPane.showMessageDialog(null, "请输入数量");
               return;
           }

           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
           try {
               Date date = sdf.parse(productTime);
               Product product = new Product(Integer.parseInt(id),productname,manufacturername,date,modeL,Double.parseDouble(purprice),Double.parseDouble(soldprice),Integer.parseInt(quantitext));
               Connection connection = null;
               connection = dbutil.getCon();
               int modifyNumber = proDao.update(connection,product);
               if (modifyNumber == 1 ) {
                   JOptionPane.showMessageDialog(null, "修改成功！");
                   this.resetValue();
                   this.fillTable(new Product());
               }
               else {
                   JOptionPane.showMessageDialog(null, "修改失败！");
               }
           } catch (ParseException ex) {
               System.out.println("无法将字符串转换为 Date 值");
           } catch (Exception ex) {
               ex.printStackTrace();
           }
       });

      /**
      * 商品删除处理
      * */
       deleteInfo.addActionListener((e)->{
           String id = this.idText.getText();
           if (StringUtil.isEmpty(id)) {
               JOptionPane.showMessageDialog(null, "请选择要删除的商品");
               return;
           }
           int flag = JOptionPane.showConfirmDialog(null,"删除后无法恢复，确定要删除该记录吗？");
           if (flag == 0) {
               Connection connection = null;
               try {
                   connection = dbutil.getCon();
                   int deleteNUm =  proDao.delete(connection,id);
                   if (deleteNUm == 1) {
                       JOptionPane.showMessageDialog(null, "删除成功！");
                       resetValue();
                       this.fillTable(new Product());

                   }else{
                       JOptionPane.showMessageDialog(null, "删除失败！");
                   }
               } catch (Exception ex) {
                   ex.printStackTrace();
               }
           }
       });
    }

    private void fillTable(Product product) {
        DefaultTableModel dtm = (DefaultTableModel) productTable.getModel();
        dtm.setRowCount(0);
        Connection con = null;
        try {
            con = util.getCon();
            ResultSet rs = proDao.listProduct(con, product);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getInt("product_id"));
                v.add(rs.getString("product_name"));
                v.add(rs.getString("manufacturer"));
                v.add(rs.getDate("production_date"));
                v.add(rs.getString("model"));
                v.add(rs.getDouble("purchase_price"));
                v.add(rs.getDouble("retail_price"));
                v.add(rs.getInt("quantity"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                util.closeCon(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
  /**
   * 重置表单
   * */
    private void resetValue( ){
        this.idText.setText("");
        this.productName.setText("");
        this.manufacturerName.setText("");
        this.date.setText("");
        this.model.setText("");
        this.purPrice.setText("");
        this.soldPrice.setText("");
        this.quantiText.setText("");
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable productTable;
    private JPanel panel1;
    private JLabel label3;
    private JTextField idText;
    private JLabel label4;
    private JTextField productName;
    private JLabel label5;
    private JTextField manufacturerName;
    private JLabel label9;
    private JTextField date;
    private JLabel label10;
    private JTextField model;
    private JLabel label11;
    private JTextField purPrice;
    private JLabel label12;
    private JTextField soldPrice;
    private JLabel label13;
    private JTextField quantiText;
    private JButton deleteInfo;
    private JButton updateBu;
    private JButton reBU;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

