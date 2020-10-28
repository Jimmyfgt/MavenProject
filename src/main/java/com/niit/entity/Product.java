package com.niit.entity;
public class Product {
    private Integer id;
    private String productName;

    private String productDecribe;

    private Integer productNum;

    private String productImg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }
       
    public String getProductDecribe() {
        return productDecribe;
    }

    public void setProductDecribe(String productDecribe) {
        this.productDecribe = productDecribe == null ? null : productDecribe.trim();
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg == null ? null : productImg.trim();
    }
}