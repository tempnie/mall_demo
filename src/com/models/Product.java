package com.models;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 2023/8/11
 * Time: 15:34
 * Description: No Description
 */
import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class Product {
    private int id;                // 商品编号
    private String productName;   // 商品名称
    private String manufacturer;  // 生产厂家
    private Date productionDate;  // 生产日期
    private String model;         // 型号
    private double purchasePrice;  // 进货价
    private double retailPrice;    // 零售价格
    private int quantity;         // 数量

    public Product(){}

    public Product( String productName, String manufacturer, Date productionDate,
                   String model, double purchasePrice, double retailPrice, int quantity) {
        super();
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.productionDate = productionDate;
        this.model = model;
        this.purchasePrice = purchasePrice;
        this.retailPrice = retailPrice;
        this.quantity = quantity;
    }
    public Product( int id,String productName, String manufacturer, Date productionDate,
                    String model, double purchasePrice, double retailPrice, int quantity) {
        super();
        this.id = id;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.productionDate = productionDate;
        this.model = model;
        this.purchasePrice = purchasePrice;
        this.retailPrice = retailPrice;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(float retailPrice) {
        this.retailPrice = retailPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

