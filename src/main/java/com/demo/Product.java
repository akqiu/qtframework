package com.demo;

/**
 * Created by qiutian on 16-9-9.
 */
public class Product {

    private String productName;

    private String productNo;

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String toString() {
        return this.productName + " "    + this.productNo;

    }
}
